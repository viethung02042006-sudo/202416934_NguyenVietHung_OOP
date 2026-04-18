package hust.soict.dsai.garbage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class GarbageCreator {
    public static void main(String[] args) {
        String filename = "test.exe"; // Tên file bạn đã để ở thư mục gốc
        byte[] inputBytes = { 0 };
        long startTime, endTime;

        try {
            inputBytes = Files.readAllBytes(Paths.get(filename));
            startTime = System.currentTimeMillis();
            String outputString = "";
            for (byte b : inputBytes) {
                outputString += (char)b; // Cách này tạo cực nhiều đối tượng rác
            }
            endTime = System.currentTimeMillis();
            System.out.println("Processing time (+): " + (endTime - startTime) + "ms");
        } catch (IOException e) {
            System.out.println("Loi: Khong tim thay file " + filename);
        }
    }
}