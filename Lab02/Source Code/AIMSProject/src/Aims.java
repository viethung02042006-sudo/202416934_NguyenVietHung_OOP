public class Aims {
    public static void main(String[] args) {
        // 1. Tạo một giỏ hàng mới
        Cart anOrder = new Cart();

        // 2. Tạo các đối tượng DVD mới và thêm vào giỏ hàng
        // Sử dụng các Constructor khác nhau đã học ở phần 8
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 124, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin",
                "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        // 3. In tổng chi phí của các mặt hàng trong giỏ hàng
        System.out.print("Total Cost is: ");
        System.out.println(anOrder.totalCost());

        // 4. Thử nghiệm phương thức xóa đĩa khỏi giỏ hàng
        // Sau khi xóa dvd2, tổng tiền phải giảm đi 24.95
        anOrder.removeDigitalVideoDisc(dvd2);
        System.out.println("Total Cost after removal: " + anOrder.totalCost());
    }
}