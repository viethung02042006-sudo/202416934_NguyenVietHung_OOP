package hust.soict.dsai.aims;

import hust.soict.dsai.aims.cart.Cart;
import hust.soict.dsai.aims.media.DigitalVideoDisc;

public class Aims {
    public static void main(String[] args) {
        // 1. Tạo giỏ hàng mới
        Cart anOrder = new Cart();

        // 2. Tạo các đối tượng DVD
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King", "Animation", "Roger Allers", 87, 19.95f);
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladin", "Animation", 18.99f);

        // 3. Thêm vào giỏ
        anOrder.addDigitalVideoDisc(dvd1);
        anOrder.addDigitalVideoDisc(dvd2);
        anOrder.addDigitalVideoDisc(dvd3);

        // 4. In tổng tiền trước khi xóa
        System.out.println("Total Cost before removal is: " + anOrder.totalCost());

        // 5. Thực hiện XÓA đĩa (Dòng này của bạn đang lỗi nếu sai tên biến)
        anOrder.removeDigitalVideoDisc(dvd2);

        // 6. Kiểm tra lại tổng tiền
        System.out.println("Total Cost after removal is: " + anOrder.totalCost());

        // 7. Thử in giỏ hàng (Chức năng mới Lab 03)
        anOrder.print();
    }
    // This line is added to demonstrate the GitHub Release Flow.
}