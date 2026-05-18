package hust.soict.dsai.test.store;

import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.store.Store;

public class StoreTest {
    public static void main(String[] args) {
        Store myStore = new Store();

        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King");
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars");
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin");

        // Test thêm đĩa
        myStore.addMedia(dvd1);
        myStore.addMedia(dvd2);
        myStore.addMedia(dvd3);

        // Test xóa đĩa
        myStore.removeMedia(dvd2); // Xóa đĩa có trong kho
        myStore.removeMedia(new DigitalVideoDisc("Avengers")); // Xóa đĩa không có trong kho
    }
}