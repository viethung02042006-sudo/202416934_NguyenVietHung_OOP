package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

    private List<String> authors = new ArrayList<String>();

    // Constructor mặc định
    public Book() {
        super();
    }

    // Constructor đầy đủ (tùy chọn để Hưng dùng sau này)
    public Book(String title, String category, float cost) {
        super();
        this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);
    }

    // Thêm tác giả vào danh sách (Kiểm tra trùng lặp)
    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Added author: " + authorName);
        } else {
            System.out.println("Author " + authorName + " is already in the list.");
        }
    }

    // Xóa tác giả khỏi danh sách (Kiểm tra tồn tại)
    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Removed author: " + authorName);
        } else {
            System.out.println("Author " + authorName + " not found in the list.");
        }
    }

    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    // Ghi đè toString để hiển thị thông tin sách
    @Override
    public String toString() {
        return "Book - " + getTitle() + " - " + getCategory() + " - Authors: " + authors + ": " + getCost() + " $";
    }
}