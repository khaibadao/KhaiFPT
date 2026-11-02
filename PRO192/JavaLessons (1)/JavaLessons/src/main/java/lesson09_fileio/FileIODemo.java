package lesson09_fileio;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * =====================================================================
 * LESSON 09 - ĐỌC / GHI FILE (FILE I/O)
 * =====================================================================
 * CHỨC NĂNG:
 *   Ghi/đọc file text, ghi nối (append), đọc file nhị phân,
 *   kiểm tra file bằng class File, try-with-resources.
 *
 * HAI NHÓM LUỒNG:
 *   +-------------------+-----------------------------+------------------------------+
 *   |                   | Đọc                         | Ghi                          |
 *   +-------------------+-----------------------------+------------------------------+
 *   | Ký tự (text)      | FileReader, BufferedReader  | FileWriter, BufferedWriter,  |
 *   |                   |                             | PrintWriter                  |
 *   | Byte (binary)     | FileInputStream,            | FileOutputStream,            |
 *   |                   | DataInputStream             | DataOutputStream             |
 *   +-------------------+-----------------------------+------------------------------+
 *
 * KÍCH THƯỚC:
 *   - BufferedReader/BufferedWriter có bộ đệm mặc định 8192 ký tự → ít lần
 *     truy cập ổ đĩa hơn, nhanh hơn đọc từng ký tự.
 *   - File text: kích thước phụ thuộc encoding (chữ có dấu UTF-8 tốn 2-3 byte).
 *   - File nhị phân DataOutputStream: int = 4 byte, double = 8 byte,
 *     đúng bằng kích thước kiểu dữ liệu ở lesson01.
 *
 * THUỘC TÍNH:
 *   - FileWriter(path)       : GHI ĐÈ file cũ
 *   - FileWriter(path, true) : GHI NỐI vào cuối file
 *   - readLine() trả về null khi hết file
 *   - Phải ĐÓNG file sau khi dùng; try-with-resources tự gọi close()
 *     theo thứ tự ngược với lúc mở.
 *   - Mọi thao tác file ném IOException (checked) → bắt buộc xử lý.
 * =====================================================================
 */
public class FileIODemo {

    private static final String TEXT_FILE = "data_students.txt";
    private static final String BIN_FILE = "data_scores.bin";

    public static void run() {
        System.out.println("===== LESSON 09: FILE I/O =====");
        try {
            writeText();
            appendText();
            readText();
            binaryDemo();
            fileInfo();
        } catch (IOException e) {
            System.out.println("  Loi I/O: " + e.getMessage());
        } finally {
            cleanup();
        }
        readMissingFile();
    }

    // Ghi đè: tạo file mới hoặc xóa nội dung cũ
    private static void writeText() throws IOException {
        try (PrintWriter pw = new PrintWriter(new BufferedWriter(new FileWriter(TEXT_FILE)))) {
            pw.println("DE210098,Le Khai,8.5");
            pw.println("DE210099,Nguyen An,7.0");
        }   // tự close() tại đây
        System.out.println("  Da ghi (ghi de) " + TEXT_FILE);
    }

    // Ghi nối: tham số thứ 2 = true
    private static void appendText() throws IOException {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(TEXT_FILE, true))) {
            bw.write("DE210100,Tran Binh,9.1");
            bw.newLine();
        }
        System.out.println("  Da ghi noi them 1 dong");
    }

    private static void readText() throws IOException {
        System.out.println("  -- Doc file text --");
        int lineNo = 0;
        double sum = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(TEXT_FILE))) {
            String line;
            while ((line = br.readLine()) != null) {     // null = hết file
                line = line.trim();
                if (line.isEmpty()) continue;
                String[] p = line.split(",");
                try {
                    double gpa = Double.parseDouble(p[2]);
                    sum += gpa;
                    lineNo++;
                    System.out.printf("  %d. %-10s %-12s %.1f%n", lineNo, p[0], p[1], gpa);
                } catch (NumberFormatException | ArrayIndexOutOfBoundsException e) {
                    System.out.println("  Bo qua dong sai dinh dang: " + line);
                }
            }
        }
        if (lineNo > 0) {
            System.out.printf("  GPA trung binh = %.2f%n", sum / lineNo);
        }
    }

    private static void binaryDemo() throws IOException {
        System.out.println("  -- File nhi phan --");
        try (DataOutputStream out = new DataOutputStream(new FileOutputStream(BIN_FILE))) {
            out.writeInt(3);            // 4 byte
            out.writeDouble(8.5);       // 8 byte
            out.writeDouble(7.0);       // 8 byte
            out.writeDouble(9.1);       // 8 byte
        }
        System.out.println("  Kich thuoc file = " + new File(BIN_FILE).length()
                + " byte (4 + 3x8 = 28)");
        try (DataInputStream in = new DataInputStream(new FileInputStream(BIN_FILE))) {
            int n = in.readInt();       // phải đọc đúng thứ tự và kiểu đã ghi
            StringBuilder sb = new StringBuilder("  Doc lai: ");
            for (int i = 0; i < n; i++) {
                sb.append(in.readDouble()).append(' ');
            }
            System.out.println(sb);
        }
    }

    private static void fileInfo() {
        File f = new File(TEXT_FILE);
        System.out.println("  -- Class File --");
        System.out.println("  exists=" + f.exists() + ", size=" + f.length() + " byte, path="
                + f.getAbsolutePath());
    }

    private static void cleanup() {
        // Xóa file demo để không để lại rác; muốn xem file thì comment 2 dòng này
        new File(TEXT_FILE).delete();
        new File(BIN_FILE).delete();
    }

    private static void readMissingFile() {
        System.out.println("  -- Mo file khong ton tai --");
        try (BufferedReader br = new BufferedReader(new FileReader("khong_co_file_nay.txt"))) {
            System.out.println(br.readLine());
        } catch (FileNotFoundException e) {          // lớp con đặt TRƯỚC
            System.out.println("  FileNotFoundException: " + e.getMessage());
        } catch (IOException e) {                    // lớp cha đặt SAU
            System.out.println("  IOException: " + e.getMessage());
        }
    }
}
