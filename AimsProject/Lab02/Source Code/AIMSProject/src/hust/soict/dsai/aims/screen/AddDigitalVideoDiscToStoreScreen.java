package hust.soict.dsai.aims.screen;

import javax.swing.*;
import hust.soict.dsai.aims.store.Store;
import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class AddDigitalVideoDiscToStoreScreen extends AddItemToStoreScreen {
    private JTextField tfDirector;
    private JTextField tfLength;

    public AddDigitalVideoDiscToStoreScreen(Store store, Cart cart) {
        super(store, cart, "Add DVD to Store");
    }

    @Override
    protected void addSubclassFields(JPanel form) {
        form.add(new JLabel("Director:"));
        tfDirector = new JTextField();
        form.add(tfDirector);

        form.add(new JLabel("Length (minutes):"));
        tfLength = new JTextField();
        form.add(tfLength);
    }

    @Override
    protected void handleAdd() {
        String title = tfTitle.getText().trim();
        String category = tfCategory.getText().trim();
        String costStr = tfCost.getText().trim();
        String director = tfDirector.getText().trim();
        String lengthStr = tfLength.getText().trim();

        if (title.isEmpty() || category.isEmpty() || costStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all standard fields (Title, Category, Cost)!", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        float cost;
        int length = 0;
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

        if (!lengthStr.isEmpty()) {
            try {
                length = Integer.parseInt(lengthStr);
                if (length < 0) {
                    JOptionPane.showMessageDialog(this, "Length must be a positive integer!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Invalid length! Please enter a valid integer.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
        }

        DigitalVideoDisc dvd = new DigitalVideoDisc(title, category, director, length, cost);

        store.addMedia(dvd);
        JOptionPane.showMessageDialog(this, "DVD added to store successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);

        // Go back to StoreScreen
        new StoreScreen(store, cart);
        dispose();
    }
}
