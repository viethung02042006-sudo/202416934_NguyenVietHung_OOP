public class Aims {
    public static void main(String[] args) {
        // Tạo một giỏ hàng mới (Create a new cart)
        Cart anOrder = new Cart();

        // Tạo các đối tượng DVD và thêm chúng vào giỏ hàng
        // Create new dvd objects and add them to the cart

        // DVD 1: The Lion King
        DigitalVideoDisc dvd1 = new DigitalVideoDisc("The Lion King",
                "Animation", "Roger Allers", 87, 19.95f);
        anOrder.addDigitalVideoDisc(dvd1);

        // DVD 2: Star Wars
        DigitalVideoDisc dvd2 = new DigitalVideoDisc("Star Wars",
                "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        // DVD 3: Aladdin
        DigitalVideoDisc dvd3 = new DigitalVideoDisc("Aladdin",
                "Animation", 18.99f);
        anOrder.addDigitalVideoDisc(dvd3);

        // In tổng chi phí của các mặt hàng trong giỏ hàng
        // Print total cost of the items in the cart
        System.out.println("Total Cost is: ");
        System.out.println(anOrder.totalCost());
    }
}