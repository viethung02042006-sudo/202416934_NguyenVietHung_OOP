package hust.soict.dsai.aims.media;

import java.util.ArrayList;
import java.util.List;

public class Book extends Media {

    // Thuộc tính riêng của lớp Book
    private List<String> authors = new ArrayList<String>();

    // Constructor mặc định
    public Book() {
        super();
    }

    // Constructor đầy đủ để Hưng dễ dùng trong bài test
    public Book(int id, String title, String category, float cost) {
        super();
        this.setId(id);
        this.setTitle(title);
        this.setCategory(category);
        this.setCost(cost);
    }

    // --- CÁC PHƯƠNG THỨC NGHIỆP VỤ (Yêu cầu ảnh image_095fd8.png) ---

    // Thêm tác giả: Kiểm tra xem tác giả đã có trong list chưa trước khi thêm
    public void addAuthor(String authorName) {
        if (!authors.contains(authorName)) {
            authors.add(authorName);
            System.out.println("Author '" + authorName + "' added to book: " + this.getTitle());
        } else {
            System.out.println("Author '" + authorName + "' is already in the list.");
        }
    }

    // Xóa tác giả: Kiểm tra xem tác giả có trong list không trước khi xóa
    public void removeAuthor(String authorName) {
        if (authors.contains(authorName)) {
            authors.remove(authorName);
            System.out.println("Author '" + authorName + "' removed from book: " + this.getTitle());
        } else {
            System.out.println("Author '" + authorName + "' does not exist in the list.");
        }
    }

    // --- GETTER VÀ SETTER CHO AUTHORS ---
    public List<String> getAuthors() {
        return authors;
    }

    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }
}