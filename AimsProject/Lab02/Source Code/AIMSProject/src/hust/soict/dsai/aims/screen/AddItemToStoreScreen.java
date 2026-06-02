package hust.soict.dsai.aims.screen;

import java.awt.*;
import javax.swing.*;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;

public abstract class AddItemToStoreScreen extends JFrame {
    protected Store store;
    protected Cart cart;
    protected JTextField tfTitle;
    protected JTextField tfCategory;
    protected JTextField tfCost;

    public AddItemToStoreScreen(Store store, Cart cart, String title) {
        this.store = store;
        this.cart = cart;

        Container cp = getContentPane();
        cp.setLayout(new BorderLayout());

        cp.add(createNorth(), BorderLayout.NORTH);
        cp.add(createCenter(), BorderLayout.CENTER);

        setVisible(true);
        setTitle(title);
        setSize(1024, 768);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
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
        
        JMenuItem addBook = new JMenuItem("Add Book");
        addBook.addActionListener(e -> {
            new AddBookToStoreScreen(store, cart);
            dispose();
        });
        JMenuItem addCD = new JMenuItem("Add CD");
        addCD.addActionListener(e -> {
            new AddCompactDiscToStoreScreen(store, cart);
            dispose();
        });
        JMenuItem addDVD = new JMenuItem("Add DVD");
        addDVD.addActionListener(e -> {
            new AddDigitalVideoDiscToStoreScreen(store, cart);
            dispose();
        });
        
        smUpdateStore.add(addBook);
        smUpdateStore.add(addCD);
        smUpdateStore.add(addDVD);

        JMenuItem viewStore = new JMenuItem("View store");
        viewStore.addActionListener(e -> {
            new StoreScreen(store, cart);
            dispose();
        });

        JMenuItem viewCart = new JMenuItem("View cart");
        viewCart.addActionListener(e -> {
            new CartScreen(store, cart);
            dispose();
        });

        menu.add(smUpdateStore);
        menu.add(viewStore);
        menu.add(viewCart);

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
        btnViewCart.addActionListener(e -> {
            new CartScreen(store, cart);
            dispose();
        });

        header.add(Box.createRigidArea(new Dimension(10, 10)));
        header.add(title);
        header.add(Box.createHorizontalGlue());
        header.add(btnViewCart);
        header.add(Box.createRigidArea(new Dimension(10, 10)));

        return header;
    }

    JPanel createCenter() {
        JPanel center = new JPanel(new BorderLayout());
        
        JPanel form = new JPanel(new GridLayout(0, 2, 10, 10));
        form.setBorder(BorderFactory.createEmptyBorder(20, 100, 20, 100));
        
        form.add(new JLabel("Title:"));
        tfTitle = new JTextField();
        form.add(tfTitle);
        
        form.add(new JLabel("Category:"));
        tfCategory = new JTextField();
        form.add(tfCategory);
        
        form.add(new JLabel("Cost ($):"));
        tfCost = new JTextField();
        form.add(tfCost);
        
        // Let subclasses append their specific fields
        addSubclassFields(form);
        
        center.add(form, BorderLayout.CENTER);

        JButton btnAdd = new JButton("Add Item");
        btnAdd.setPreferredSize(new Dimension(150, 40));
        btnAdd.addActionListener(e -> handleAdd());
        
        JPanel btnPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnPanel.add(btnAdd);
        center.add(btnPanel, BorderLayout.SOUTH);

        return center;
    }

    protected abstract void addSubclassFields(JPanel form);
    protected abstract void handleAdd();
}
