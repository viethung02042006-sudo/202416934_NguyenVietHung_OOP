package hust.soict.dsai.aims.media;

public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;
    // Khai báo 2 biến mới theo yêu cầu lab03
    private static int nbDigitalVideoDiscs = 0; // Biến class (chung cho tất cả đối tượng)
    private int id; // Biến instance (riêng cho mỗi đối tượng)

    // --- CÁC HÀM KHỞI TẠO (CONSTRUCTORS) - PHẦN 8 ---

    // 1. Khởi tạo bằng tiêu đề (title)
    public DigitalVideoDisc(String title) {
        this.title = title;
        // --- LAB3 ---
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    // 2. Khởi tạo bằng danh mục, tiêu đề và giá (category, title, cost)
    public DigitalVideoDisc(String category, String title, float cost) {
        this.category = category;
        this.title = title;
        this.cost = cost;
        // ---LAB3 ---
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    // 3. Khởi tạo bằng đạo diễn, danh mục, tiêu đề và giá (director, category, title, cost)
    public DigitalVideoDisc(String director, String category, String title, float cost) {
        this.director = director;
        this.category = category;
        this.title = title;
        this.cost = cost;
        // --- LAB3 ---
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    // 4. Khởi tạo bằng tất cả thuộc tính
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
        // --- LAB3 ---
        nbDigitalVideoDiscs++;
        this.id = nbDigitalVideoDiscs;
    }

    // --- CÁC HÀM LẤY DỮ LIỆU (GETTERS) - PHẦN 7 ---

    public String getTitle() {
        return title;
    }

    public String getCategory() {
        return category;
    }

    public String getDirector() {
        return director;
    }

    public int getLength() {
        return length;
    }

    public float getCost() {
        return cost;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    // Getter để lấy mã ID của đĩa
    public int getId() {
        return id;
    }

    // Getter để lấy tổng số đĩa hiện có (dùng static vì nó là biến chung của lớp)
    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }
    //PHẦN 6 LAB03
    // Hàm trả về chuỗi thông tin định dạng sẵn
    @Override
    public String toString() {
        return "DVD - " + title + " - " + category + " - " + director + " - " + length + ": " + cost + " $";
    }

    // Hàm kiểm tra tiêu đề có khớp không
    public boolean isMatch(String title) {
        return this.title.equals(title);
    }
}