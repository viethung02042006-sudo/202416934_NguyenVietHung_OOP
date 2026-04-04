public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc itemsOrdered[] =
            new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered = 0;

    //   thêm DVD vào giỏ hàng
    public void addDigitalVideoDisc(DigitalVideoDisc disc) {
        if (qtyOrdered < MAX_NUMBERS_ORDERED) {
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added"); // Thông báo theo yêu cầu
        } else {
            System.out.println("The cart is almost full"); // Thông báo khi đầy
        }
    }

    //  xóa DVD khỏi giỏ hàng
    public void removeDigitalVideoDisc(DigitalVideoDisc disc) {
        int indexFound = -1;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] == disc) {
                indexFound = i;
                break;
            }
        }

        if (indexFound != -1) {
            // Dịch chuyển các phần tử phía sau lên để lấp chỗ trống
            for (int i = indexFound; i < qtyOrdered - 1; i++) {
                itemsOrdered[i] = itemsOrdered[i + 1];
            }
            itemsOrdered[qtyOrdered - 1] = null;
            qtyOrdered--;
            System.out.println("The disc has been removed");
        } else {
            System.out.println("The disc is not found in the cart");
        }
    }

    //   tính tổng tiền
    public float totalCost() {
        float total = 0;
        for (int i = 0; i < qtyOrdered; i++) {
            if (itemsOrdered[i] != null) {
                total += itemsOrdered[i].getCost(); // Sử dụng getter đã tạo ở phần 7
            }
        }
        return total;
    }
}