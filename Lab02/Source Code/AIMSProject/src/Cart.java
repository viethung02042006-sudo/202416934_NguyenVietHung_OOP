public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    // Thêm DVD vào giỏ hàng
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added");

            // Nếu sau khi thêm mà giỏ hàng chạm mốc 20
            if (qtyOrdered == MAX_NUMBERS_ORDERED) {
                System.out.println("The cart is almost full");
            }
        } else {
            // Nếu giỏ hàng đã đầy (>= 20)
            System.out.println("The cart is almost full");
        }
    }

    // Xóa DVD khỏi giỏ hàng
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        int indexFound = -1;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                indexFound = i;
                break;
            }
        }

        if (indexFound != -1) {
            // Dịch chuyển các phần tử phía sau lên trước
            for (int i = indexFound; i < qtyOrdered - 1; i++) {
                itemsOrdered[i] = itemsOrdered[i + 1];
            }
            itemsOrdered[qtyOrdered - 1] = null; // Xóa tham chiếu cuối cùng
            qtyOrdered--;
            System.out.println("The disc has been removed");
        } else {
            System.out.println("The disc is not found in the cart");
        }
    }

    // Tính tổng tiền các DVD trong giỏ
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            total += itemsOrdered[i].getCost();
        }
        return total;
    }
}