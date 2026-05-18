package hust.soict.dsai.test.polymorphism;

import java.util.ArrayList;
import java.util.List;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.media.DigitalVideoDisc;
import hust.soict.dsai.aims.media.Media;

public class PolymorphismTest {
    public static void main(String[] args) {
        List<Media> mediae = new ArrayList<Media>();

        // Create some media here
        CompactDisc cd = new CompactDisc(1, "The Dark Side of the Moon", "Progressive Rock", 15.99f, 43, "Alan Parsons", "Pink Floyd");
        DigitalVideoDisc dvd = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 124, 19.95f);
        Book book = new Book(2, "The Lord of the Rings", "Fantasy", 25.50f);
        book.addAuthor("J. R. R. Tolkien");

        // Add media to the list
        mediae.add(cd);
        mediae.add(dvd);
        mediae.add(book);

        System.out.println("---- ITERATING THROUGH THE LIST AND CALLING toString() ----");
        // Iterate through the list and print out the information of the media by using toString() method
        for (Media m : mediae) {
            System.out.println(m.toString());
        }
    }
}
