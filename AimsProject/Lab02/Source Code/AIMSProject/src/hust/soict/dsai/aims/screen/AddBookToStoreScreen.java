package hust.soict.dsai.aims.screen;

import javax.swing.*;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;

public class AddBookToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfAuthors;

    public AddBookToStoreScreen(Store store, Cart cart) {
        super(store, cart, "Add Book to Store");
    }

    @Override
    protected void addSubclassFields(JPanel form) {
        form.add(new JLabel("Authors (comma-separated):"));
        tfAuthors = new JTextField();
        form.add(tfAuthors);
    }

    @Override
    protected void handleAdd() {
        String title = tfTitle.getText().trim();
        String category = tfCategory.getText().trim();
        String costStr = tfCost.getText().trim();
        String authorsStr = tfAuthors.getText().trim();

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

        // Auto-increment ID based on store count
        int id = store.getItemsInStore().size() + 1;
        Book book = new Book(id, title, category, cost);

        if (!authorsStr.isEmpty()) {
            String[] authors = authorsStr.split(",");
            for (String author : authors) {
                book.addAuthor(author.trim());
            }
        }

        store.addMedia(book);
        JOptionPane.showMessageDialog(this, "Book added to store successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

        // Go back to StoreScreen
        new StoreScreen(store, cart);
        dispose();
    }
}
