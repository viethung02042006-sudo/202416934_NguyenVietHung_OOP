public class DigitalVideoDisc {
    private String title;
    private String category;
    private String director;
    private int length;
    private float cost;

    // --- CÁC HÀM KHỞI TẠO (CONSTRUCTORS) - PHẦN 8 ---

    // 1. Khởi tạo bằng tiêu đề (title)
    public DigitalVideoDisc(String title) {
        this.title = title;
    }

    // 2. Khởi tạo bằng danh mục, tiêu đề và giá (category, title, cost)
    public DigitalVideoDisc(String category, String title, float cost) {
        this.category = category;
        this.title = title;
        this.cost = cost;
    }

    // 3. Khởi tạo bằng đạo diễn, danh mục, tiêu đề và giá (director, category, title, cost)
    public DigitalVideoDisc(String director, String category, String title, float cost) {
        this.director = director;
        this.category = category;
        this.title = title;
        this.cost = cost;
    }

    // 4. Khởi tạo bằng tất cả thuộc tính
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        this.title = title;
        this.category = category;
        this.director = director;
        this.length = length;
        this.cost = cost;
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

    public float getCost()

    public void setTitle(String title) {
        this.title = title;
    }
}