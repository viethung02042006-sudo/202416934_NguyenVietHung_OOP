public class Aims {
    public static void main(String[] args) {
        // Chạy thử hàm khởi tạo số 1 (chỉ có title)
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("Interstella");

        // Chạy thử hàm khởi tạo số 2 (category, title, cost)
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Animation", "Aladdin", 18.99f);

        // Chạy thử hàm khởi tạo số 4 (đầy đủ thông tin)
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Star Wars", "Sci-fi", "George Lucas", 124, 24.95f);

        // In thử ra màn hình để kiểm tra
        System.out.println("DVD 1 Title: " + dvd1.getTitle());
        System.out.println("DVD 2 Title: " + dvd2.getTitle() + " - Cost: " + dvd2.getCost());
        System.out.println("DVD 3 Director: " + dvd3.getDirector());
    }
}