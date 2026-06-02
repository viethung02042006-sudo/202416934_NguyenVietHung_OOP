package hust.soict.dsai.aims.screen;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.exception.LimitExceededException;
import hust.soict.dsai.aims.exception.PlayerException;

public class MediaStore extends JPanel {
    private Media media;
    private Cart cart;

    public MediaStore(Media media, Cart cart) {
        this.media = media;
        this.cart = cart;
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));

        JLabel title = new JLabel(media.getTitle());
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
        title.setAlignmentX(CENTER_ALIGNMENT);

        JLabel cost = new JLabel("" + media.getCost() + " $");
        cost.setAlignmentX(CENTER_ALIGNMENT);

        JPanel container = new JPanel();
        container.setLayout(new FlowLayout(FlowLayout.CENTER));

        JButton btnAddToCart = new JButton("Add to cart");
        container.add(btnAddToCart);
        btnAddToCart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    cart.addMedia(MediaStore.this.media);
                    JOptionPane.showMessageDialog(null, 
                        MediaStore.this.media.getTitle() + " has been added to cart.",
                        "Cart Update", JOptionPane.INFORMATION_MESSAGE);
                } catch (LimitExceededException ex) {
                    JOptionPane.showMessageDialog(null, 
                        ex.getMessage(),
                        "Limit Exceeded", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        if (media instanceof Playable) {
            JButton btnPlay = new JButton("Play");
            container.add(btnPlay);
            btnPlay.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        ((Playable) MediaStore.this.media).play();

                        JDialog dialog = new JDialog((Frame) SwingUtilities.getWindowAncestor(MediaStore.this), "Play Media", true);
                        dialog.setLayout(new BorderLayout());
                        
                        StringBuilder message = new StringBuilder();
                        message.append("<html><body style='width: 250px; padding: 10px;'>");
                        if (MediaStore.this.media instanceof DigitalVideoDisc) {
                            DigitalVideoDisc dvd = (DigitalVideoDisc) MediaStore.this.media;
                            message.append("<h2 style='color: blue;'>Playing DVD: ").append(dvd.getTitle()).append("</h2>");
                            message.append("<p><b>Category:</b> ").append(dvd.getCategory()).append("</p>");
                            message.append("<p><b>Director:</b> ").append(dvd.getDirector()).append("</p>");
                            message.append("<p><b>Length:</b> ").append(dvd.getLength()).append(" minutes</p>");
                        } else if (MediaStore.this.media instanceof CompactDisc) {
                            CompactDisc cd = (CompactDisc) MediaStore.this.media;
                            message.append("<h2 style='color: blue;'>Playing CD: ").append(cd.getTitle()).append("</h2>");
                            message.append("<p><b>Artist:</b> ").append(cd.getArtist()).append("</p>");
                            message.append("<p><b>Category:</b> ").append(cd.getCategory()).append("</p>");
                            message.append("<p><b>Director:</b> ").append(cd.getDirector()).append("</p>");
                            message.append("<p><b>Length:</b> ").append(cd.getLength()).append(" seconds</p>");
                            message.append("<hr><b>Tracks:</b><br>");
                            if (cd.getTracks().isEmpty()) {
                                message.append("<i>No tracks available.</i>");
                            } else {
                                message.append("<ol>");
                                for (Track track : cd.getTracks()) {
                                    message.append("<li>").append(track.getTitle())
                                           .append(" (").append(track.getLength()).append("s)</li>");
                                }
                                message.append("</ol>");
                            }
                        }
                        message.append("</body></html>");

                        JLabel lblMessage = new JLabel(message.toString());
                        lblMessage.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
                        dialog.add(lblMessage, BorderLayout.CENTER);

                        JButton btnClose = new JButton("Close");
                        btnClose.addActionListener(new ActionListener() {
                            @Override
                            public void actionPerformed(ActionEvent evt) {
                                dialog.dispose();
                            }
                        });
                        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
                        btnPanel.add(btnClose);
                        dialog.add(btnPanel, BorderLayout.SOUTH);

                        dialog.pack();
                        dialog.setLocationRelativeTo(dialog.getParent());
                        dialog.setVisible(true);
                    } catch (PlayerException ex) {
                        JOptionPane.showMessageDialog(null, 
                            ex.getMessage(), 
                            "Player Error", JOptionPane.ERROR_MESSAGE);
                    }
                }
            });
        }

        this.add(Box.createVerticalGlue());
        this.add(title);
        this.add(cost);
        this.add(Box.createVerticalGlue());
        this.add(container);

        this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
    }
}
