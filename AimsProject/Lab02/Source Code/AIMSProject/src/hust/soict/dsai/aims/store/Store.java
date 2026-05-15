package hust.soict.dsai.aims.store;

import java.util.ArrayList;
import hust.soict.dsai.aims.media.Media;

public class Store {
    private ArrayList<Media> itemsInStore = new ArrayList<Media>();

    public void addMedia(Media media) {
        itemsInStore.add(media);
        System.out.println("The media '" + media.getTitle() + "' has been added to the store.");
    }

    public void removeMedia(Media media) {
        if (itemsInStore.remove(media)) {
            System.out.println("The media '" + media.getTitle() + "' has been removed from the store.");
        } else {
            System.out.println("The media '" + media.getTitle() + "' is not found in the store.");
        }
    }

    public void print() {
        System.out.println("***********************STORE***********************");
        System.out.println("Items in Store:");
        for (int i = 0; i < itemsInStore.size(); i++) {
            System.out.println((i + 1) + ". " + itemsInStore.get(i).toString());
        }
        System.out.println("***************************************************");
    }
}