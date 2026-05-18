package hust.soict.dsai.aims;

import java.util.Scanner;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.media.Playable;
import hust.soict.dsai.aims.store.Store;

public class Aims {
    private static Store store = new Store();
    private static Cart cart = new Cart();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initData();

        while (true) {
            showMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    storeMenu();
                    break;
                case 2:
                    updateStoreMenu();
                    break;
                case 3:
                    cartMenu();
                    break;
                case 0:
                    System.out.println("Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private static void initData() {
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 24.95f);
        CompactDisc cd1 = new CompactDisc(3, "The Dark Side of the Moon", "Progressive Rock", 15.99f, 43, "Alan Parsons", "Pink Floyd");
        Book book1 = new Book(4, "The Lord of the Rings", "Fantasy", 25.50f);
        book1.addAuthor("J. R. R. Tolkien");
        
        store.addMedia(dvd1);
        store.addMedia(dvd2);
        store.addMedia(cd1);
        store.addMedia(book1);
    }

    public static void showMenu() {
        System.out.println("AIMS: ");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void storeMenu() {
        while (true) {
            store.print();
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. See a media's details");
            System.out.println("2. Add a media to cart");
            System.out.println("3. Play a media");
            System.out.println("4. See current cart");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter media title: ");
                    String title1 = scanner.nextLine();
                    Media media1 = store.fetchMedia(title1);
                    if (media1 != null) {
                        System.out.println(media1.toString());
                        mediaDetailsMenu(media1);
                    } else {
                        System.out.println("Media not found in store.");
                    }
                    break;
                case 2:
                    System.out.print("Enter media title to add to cart: ");
                    String title2 = scanner.nextLine();
                    Media media2 = store.fetchMedia(title2);
                    if (media2 != null) {
                        cart.addMedia(media2);
                    } else {
                        System.out.println("Media not found in store.");
                    }
                    break;
                case 3:
                    System.out.print("Enter media title to play: ");
                    String title3 = scanner.nextLine();
                    Media media3 = store.fetchMedia(title3);
                    if (media3 != null) {
                        if (media3 instanceof Playable) {
                            ((Playable) media3).play();
                        } else {
                            System.out.println("This media cannot be played.");
                        }
                    } else {
                        System.out.println("Media not found in store.");
                    }
                    break;
                case 4:
                    cartMenu();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void mediaDetailsMenu(Media media) {
        while (true) {
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Add to cart");
            if (media instanceof Playable) {
                System.out.println("2. Play");
            }
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1" + (media instanceof Playable ? "-2" : ""));

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    break;
                case 2:
                    if (media instanceof Playable) {
                        ((Playable) media).play();
                    } else {
                        System.out.println("Invalid choice.");
                    }
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    public static void updateStoreMenu() {
        System.out.println("Update Store: ");
        System.out.println("1. Add a media");
        System.out.println("2. Remove a media");
        System.out.println("0. Back");
        System.out.print("Choose option: ");
        
        int choice = scanner.nextInt();
        scanner.nextLine();
        
        switch (choice) {
            case 1:
                System.out.println("Enter Media Type (1. DVD, 2. CD, 3. Book): ");
                int type = scanner.nextInt();
                scanner.nextLine();
                System.out.print("Enter title: ");
                String title = scanner.nextLine();
                System.out.print("Enter category: ");
                String category = scanner.nextLine();
                System.out.print("Enter cost: ");
                float cost = scanner.nextFloat();
                scanner.nextLine();
                
                if (type == 1) {
                    store.addMedia(new DigitalVideoDisc(title, category, cost));
                } else if (type == 2) {
                    store.addMedia(new CompactDisc(store.hashCode(), title, category, cost, 0, "", "")); // simplified
                } else if (type == 3) {
                    store.addMedia(new Book(store.hashCode(), title, category, cost));
                } else {
                    System.out.println("Invalid type.");
                }
                break;
            case 2:
                System.out.print("Enter media title to remove: ");
                String removeTitle = scanner.nextLine();
                Media mediaToRemove = store.fetchMedia(removeTitle);
                if (mediaToRemove != null) {
                    store.removeMedia(mediaToRemove);
                } else {
                    System.out.println("Media not found in store.");
                }
                break;
            case 0:
                return;
            default:
                System.out.println("Invalid choice.");
        }
    }

    public static void cartMenu() {
        while (true) {
            cart.print();
            System.out.println("Options: ");
            System.out.println("--------------------------------");
            System.out.println("1. Filter medias in cart");
            System.out.println("2. Sort medias in cart");
            System.out.println("3. Remove media from cart");
            System.out.println("4. Play a media");
            System.out.println("5. Place order");
            System.out.println("0. Back");
            System.out.println("--------------------------------");
            System.out.println("Please choose a number: 0-1-2-3-4-5");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Filter by: 1. ID | 2. Title");
                    int filterChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (filterChoice == 1) {
                        System.out.print("Enter ID: ");
                        int id = scanner.nextInt();
                        scanner.nextLine();
                        cart.searchById(id);
                    } else if (filterChoice == 2) {
                        System.out.print("Enter title: ");
                        String title = scanner.nextLine();
                        cart.searchByTitle(title);
                    }
                    break;
                case 2:
                    System.out.println("Sort by: 1. Title | 2. Cost");
                    int sortChoice = scanner.nextInt();
                    scanner.nextLine();
                    if (sortChoice == 1) {
                        cart.sortByTitleCost();
                    } else if (sortChoice == 2) {
                        cart.sortByCostTitle();
                    }
                    break;
                case 3:
                    System.out.print("Enter media title to remove from cart: ");
                    String titleToRemove = scanner.nextLine();
                    Media mediaToRemove = cart.fetchMedia(titleToRemove);
                    if (mediaToRemove != null) {
                        cart.removeMedia(mediaToRemove);
                    } else {
                        System.out.println("Media not found in cart.");
                    }
                    break;
                case 4:
                    System.out.print("Enter media title to play: ");
                    String titleToPlay = scanner.nextLine();
                    Media mediaToPlay = cart.fetchMedia(titleToPlay);
                    if (mediaToPlay != null) {
                        if (mediaToPlay instanceof Playable) {
                            ((Playable) mediaToPlay).play();
                        } else {
                            System.out.println("This media cannot be played.");
                        }
                    } else {
                        System.out.println("Media not found in cart.");
                    }
                    break;
                case 5:
                    System.out.println("An order is created.");
                    cart.empty();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}