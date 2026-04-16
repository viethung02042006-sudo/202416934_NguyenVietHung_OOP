public class Aims {
    public static void main(String[] args) {
        // 1. Khởi tạo giỏ hàng
        Cart anOrder = new Cart();

        // 2. Tạo các DVD mẫu
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin", "Animation", 18.99f);

        // 3. Thêm đĩa vào giỏ (Phần 9 & 10)
        anOrder.addDigitalVideoDisc(dvd1);
        anOrder.addDigitalVideoDisc(dvd2);
        anOrder.addDigitalVideoDisc(dvd3);

        // 4. In tổng tiền trước khi xóa
        System.out.println("Total Cost before removal is: " + anOrder.totalCost());

        // 5. Thực hiện XÓA đĩa (Phần 11)
        // Chúng ta sẽ thử xóa đĩa Star Wars (dvd2)
        anOrder.removeDigitalVideoDisc(dvd2);

        // 6. Kiểm tra lại tổng tiền sau khi xóa (Phải còn 38.94)
        System.out.println("Total Cost after removal is: " + anOrder.totalCost());

        // 7. Thử xóa một đĩa không tồn tại để kiểm tra thông báo lỗi
        anOrder.removeDigitalVideoDisc(dvd2);
    }
}