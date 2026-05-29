package hust.soict.dsai.aims.screen;

import java.awt.*;
import java.util.ArrayList;
import javax.swing.*;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.Book;

public class StoreScreen extends JFrame {
    private Store store;
    private Cart cart;

    public StoreScreen(Store store, Cart cart) {
        this.store = store;
        this.cart = cart;
        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle("Store");
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    JPanel createNorth() {
        JPanel north = new JPanel();
        north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
        north.add(createMenuBar());
        north.add(createHeader());
        return north;
    }

    JMenuBar createMenuBar() {
        JMenu menu = new JMenu("Options");

        JMenu smUpdateStore = new JMenu("Update Store");
        smUpdateStore.add(new JMenuItem("Add Book"));
        smUpdateStore.add(new JMenuItem("Add CD"));
        smUpdateStore.add(new JMenuItem("Add DVD"));

        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View store"));
        menu.add(new JMenuItem("View cart"));

        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);

        return menuBar;
    }

    JPanel createHeader() {
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

        JLabel title = new JLabel("AIMS");
        title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
        title.setForeground(Color.CYAN);

        JButton btnViewCart = new JButton("View cart");
        btnViewCart.setPreferredSize(new Dimension(100, 50));
        btnViewCart.setMaximumSize(new Dimension(100, 50));

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(btnViewCart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel();
        center.setLayout(new GridLayout(3, 3, 2, 2));

        ArrayList<Media> mediaInStore = store.getItemsInStore();
        int limit = Math.min(9, mediaInStore.size());
        for (int i = 0; i < limit; i++) {
            MediaStore cell = new MediaStore(mediaInStore.get(i), cart);
            center.add(cell);
        }

        return center;
    }

    public static void main(String[] args) {
        Store store = new Store();
        Cart cart = new Cart();

        // Thêm dữ liệu mẫu vào cửa hàng
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", "John Musker", 90, 18.99f);
        
        CompactDisc cd1 = new CompactDisc(3, "The Dark Side of the Moon", "Progressive Rock", 15.99f, 43, "Alan Parsons", "Pink Floyd");
        cd1.addTrack(new hust.soict.dsai.aims.media.Track("Speak to Me", 90));
        cd1.addTrack(new hust.soict.dsai.aims.media.Track("Breathe", 163));
        cd1.addTrack(new hust.soict.dsai.aims.media.Track("On the Run", 215));

        CompactDisc cd2 = new CompactDisc(4, "Abbey Road", "Rock", 12.99f, 47, "George Martin", "The Beatles");
        cd2.addTrack(new hust.soict.dsai.aims.media.Track("Come Together", 259));
        cd2.addTrack(new hust.soict.dsai.aims.media.Track("Something", 182));

        CompactDisc cd3 = new CompactDisc(5, "Thriller", "Pop", 14.99f, 42, "Quincy Jones", "Michael Jackson");

        Book book1 = new Book(6, "The Lord of the Rings", "Fantasy", 25.50f);
        book1.addAuthor("J. R. R. Tolkien");
        Book book2 = new Book(7, "Harry Potter", "Fantasy", 19.99f);
        book2.addAuthor("J. K. Rowling");
        Book book3 = new Book(8, "Sherlock Holmes", "Mystery", 15.00f);
        book3.addAuthor("Arthur Conan Doyle");

        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(dvd3);
        store.addMedia(cd1);
        store.addMedia(cd2);
        store.addMedia(cd3);
        store.addMedia(book1);
        store.addMedia(book2);
        store.addMedia(book3);

        new StoreScreen(store, cart);
    }
}
