package hust.soict.dsai.aims.screen;

import javax.swing.*;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Track;

public class AddCompactDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfArtist;
    private JTextField tfDirector;
    private JTextField tfTracks;

    public AddCompactDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart, "Add CD to Store");
    }

    @Override
    protected void addSubclassFields(JPanel form) {
        form.add(new JLabel("Artist:"));
        tfArtist = new JTextField();
        form.add(tfArtist);

        form.add(new JLabel("Director:"));
        tfDirector = new JTextField();
        form.add(tfDirector);

        form.add(new JLabel("Tracks (Format: Title1:Length1, Title2:Length2):"));
        tfTracks = new JTextField();
        form.add(tfTracks);
    }

    @Override
    protected void handleAdd() {
        String title = tfTitle.getText().trim();
        String category = tfCategory.getText().trim();
        String costStr = tfCost.getText().trim();
        String artist = tfArtist.getText().trim();
        String director = tfDirector.getText().trim();
        String tracksStr = tfTracks.getText().trim();

        if (title.isEmpty() || category.isEmpty() || costStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all standard fields (Title, Category, Cost)!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        float cost;
        try {
            cost = Float.parseFloat(costStr);
            if (cost < 0) {
                JOptionPane.showMessageDialog(this, "Cost must be a positive number!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Invalid cost! Please enter a valid number.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Auto-increment ID based on store size
        int id = store.getItemsInStore().size() + 1;
        CompactDisc cd = new CompactDisc(id, title, category, cost, 0, director, artist);

        if (!tracksStr.isEmpty()) {
            String[] trackTokens = tracksStr.split(",");
            for (String token : trackTokens) {
                String[] parts = token.split(":");
                if (parts.length == 2) {
                    String trackTitle = parts[0].trim();
                    int trackLength = 0;
                    try {
                        trackLength = Integer.parseInt(parts[1].trim());
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(this, "Invalid track length for: " + trackTitle, "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                    cd.addTrack(new Track(trackTitle, trackLength));
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid track format for: " + token.trim() + "\nExpected format is: Title:Length", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            }
        }

        store.addMedia(cd);
        JOptionPane.showMessageDialog(this, "CD added to store successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

        // Go back to StoreScreen
        new StoreScreen(store, cart);
        dispose();
    }
}
