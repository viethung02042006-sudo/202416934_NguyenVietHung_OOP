package hust.soict.dsai.test.cart;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class CartTest {
    public static void main(String[] args) {
        Cart cart = new Cart();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        cart.addMedia(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        cart.addMedia(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);
        cart.addMedia(dvd3);

        // Test hàm print
        cart.print();

        // To-do: Test các hàm search ở đây
        System.out.println("\nTesting search by ID:");
        cart.searchById(1);
        cart.searchById(5); // Thử ID không tồn tại

        System.out.println("\nTesting search by Title:");
        cart.searchByTitle("Star Wars");
        cart.searchByTitle("Avenger"); // Thử tiêu đề không tồn tại
    }
}