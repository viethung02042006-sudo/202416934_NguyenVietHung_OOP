package hust.soict.dsai.aims.store;

import hust.soict.dsai.aims.disc.DigitalVideoDisc;

public class Store {
    // Giả sử kho hàng có sức chứa lớn hơn giỏ hàng, ví dụ 100 đĩa
    private DigitalVideoDisc itemsInStore[] = new DigitalVideoDisc[100];
    private int qtyInStore = 0;

    // Phương thức thêm DVD vào kho
    public void addDVD(DigitalVideoDisc dvd) {
        if (qtyInStore < itemsInStore.length) {
            itemsInStore[qtyInStore] = dvd;
            qtyInStore++;
            System.out.println("The DVD '" + dvd.getTitle() + "' has been added to the store.");
        } else {
            System.out.println("The store is full, cannot add more DVDs.");
        }
    }

    // Phương thức xóa DVD khỏi kho
    public void removeDVD(DigitalVideoDisc dvd) {
        int indexFound = -1;
        for (int i = 0; i < qtyInStore; i++) {
            if (itemsInStore[i] == dvd) {
                indexFound = i;
                break;
            }
        }

        if (indexFound != -1) {
            for (int i = indexFound; i < qtyInStore - 1; i++) {
                itemsInStore[i] = itemsInStore[i + 1];
            }
            itemsInStore[qtyInStore - 1] = null;
            qtyInStore--;
            System.out.println("The DVD '" + dvd.getTitle() + "' has been removed from the store.");
        } else {
            System.out.println("The DVD '" + dvd.getTitle() + "' is not found in the store.");
        }
    }
}