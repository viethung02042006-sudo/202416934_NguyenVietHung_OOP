package hust.soict.dsai.aims.media;

public class DigitalVideoDisc extends Disc implements Playable {

    // Biến static để đếm số lượng DVD được tạo ra
    private static int nbDigitalVideoDiscs = 0;

    // --- CÁC HÀM KHỞI TẠO (CONSTRUCTORS) ĐÃ CẬP NHẬT KẾ THỪA ---

    // 1. Khởi tạo bằng tiêu đề (title)
    public DigitalVideoDisc(String title) {
        super(title);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }

    // 2. Khởi tạo bằng danh mục, tiêu đề và giá (category, title, cost)
    public DigitalVideoDisc(String category, String title, float cost) {
        super(title, category, cost);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }

    // 3. Khởi tạo bằng đạo diễn, danh mục, tiêu đề và giá (director, category, title, cost)
    public DigitalVideoDisc(String director, String category, String title, float cost) {
        super(title, category, director, cost);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }

    // 4. Khởi tạo bằng tất cả thuộc tính
    public DigitalVideoDisc(String title, String category, String director, int length, float cost) {
        super(title, category, director, length, cost);
        nbDigitalVideoDiscs++;
        this.setId(nbDigitalVideoDiscs);
    }

    // Getter để lấy tổng số đĩa hiện có
    public static int getNbDigitalVideoDiscs() {
        return nbDigitalVideoDiscs;
    }

    // --- CÁC PHƯƠNG THỨC GHI ĐÈ VÀ BỔ SUNG ---

    @Override
    public String toString() {
        // Sử dụng các hàm Getter từ lớp cha Disc và Media để lấy dữ liệu
        return "DVD - " + getTitle() + " - " + getCategory() + " - " + getDirector() + " - " + getLength() + ": " + getCost() + " $";
    }

    @Override
    public void play() {
        System.out.println("Playing DVD: " + this.getTitle());
        System.out.println("DVD length: " + this.getLength());
    }

    // Hàm kiểm tra tiêu đề có khớp không
    public boolean isMatch(String title) {
        return this.getTitle().equals(title);
    }
}