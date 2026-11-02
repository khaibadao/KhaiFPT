package lesson02_controlflow;

import java.util.Arrays;

/**
 * =====================================================================
 * LESSON 02 - CẤU TRÚC ĐIỀU KHIỂN (CONTROL FLOW) & MẢNG (ARRAY)
 * =====================================================================
 * CHỨC NĂNG:
 *   if/else, switch, for, for-each, while, do-while, break/continue,
 *   mảng 1 chiều và 2 chiều.
 *
 * KÍCH THƯỚC:
 *   - Mảng có kích thước CỐ ĐỊNH sau khi tạo, xem bằng arr.length
 *     (thuộc tính, KHÔNG có ngoặc; khác String.length() là method).
 *   - Bộ nhớ mảng ≈ header (~16 byte) + length × kích thước phần tử.
 *     Ví dụ int[1000] ≈ 16 + 1000×4 = ~4 KB.
 *   - Chỉ số từ 0 đến length-1; vượt ra ngoài → ArrayIndexOutOfBoundsException.
 *
 * THUỘC TÍNH:
 *   - Mảng là kiểu tham chiếu: gán b = a thì a và b cùng trỏ 1 mảng.
 *   - Phần tử mảng mới tạo nhận giá trị mặc định (0, false, null).
 *   - Mảng 2 chiều là "mảng của mảng", các hàng có thể dài khác nhau.
 * =====================================================================
 */
public class ControlFlow {

    public static void run() {
        System.out.println("===== LESSON 02: CONTROL FLOW & ARRAY =====");
        ifElseDemo(8.5);
        switchDemo(3);
        loopDemo();
        arrayDemo();
        array2DDemo();
    }

    private static void ifElseDemo(double gpa) {
        System.out.println("-- if / else if / else --");
        String rank;
        if (gpa >= 9) {
            rank = "Xuat sac";
        } else if (gpa >= 8) {
            rank = "Gioi";
        } else if (gpa >= 6.5) {
            rank = "Kha";
        } else {
            rank = "Trung binh";
        }
        // Toán tử 3 ngôi: điều_kiện ? giá_trị_đúng : giá_trị_sai
        String pass = gpa >= 5 ? "Dau" : "Rot";
        System.out.println("GPA " + gpa + " -> " + rank + ", " + pass);
    }

    private static void switchDemo(int day) {
        System.out.println("-- switch --");
        // switch kiểu cũ: nhớ break, nếu quên sẽ "rơi" xuống case sau (fall-through)
        switch (day) {
            case 1:
                System.out.println("Chu nhat");
                break;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                System.out.println("Ngay thuong (case gop)");
                break;
            default:
                System.out.println("Thu bay hoac khong hop le");
        }
        // switch expression (Java 14+): không cần break, trả về giá trị
        String name = switch (day) {
            case 1 -> "CN";
            case 7 -> "T7";
            default -> "T" + day;
        };
        System.out.println("switch expression -> " + name);
    }

    private static void loopDemo() {
        System.out.println("-- Vong lap --");
        // for: biết trước số lần lặp
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) continue;   // bỏ qua số chẵn
            if (i > 7) break;           // dừng hẳn vòng lặp
            sb.append(i).append(' ');
        }
        System.out.println("for (le, <=7): " + sb);

        // while: kiểm tra điều kiện TRƯỚC
        int n = 1234, sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        System.out.println("while - tong chu so 1234 = " + sum);

        // do-while: chạy ít nhất 1 lần, kiểm tra SAU
        int k = 100;
        do {
            System.out.println("do-while chay 1 lan du k=" + k);
        } while (k < 10);
    }

    private static void arrayDemo() {
        System.out.println("-- Mang 1 chieu --");
        int[] scores = {7, 9, 5, 8, 10};
        int[] empty = new int[3];          // {0, 0, 0}

        int max = scores[0];
        double total = 0;
        for (int s : scores) {             // for-each: duyệt từng phần tử
            total += s;
            if (s > max) max = s;
        }
        System.out.println("scores=" + Arrays.toString(scores) + ", length=" + scores.length);
        System.out.println("max=" + max + ", avg=" + total / scores.length);
        System.out.println("new int[3] = " + Arrays.toString(empty));

        int[] alias = scores;              // cùng trỏ 1 mảng
        int[] copy = Arrays.copyOf(scores, scores.length);  // mảng mới
        alias[0] = 99;
        System.out.println("Sau alias[0]=99: scores[0]=" + scores[0] + ", copy[0]=" + copy[0]);

        Arrays.sort(copy);
        System.out.println("copy sau sort = " + Arrays.toString(copy));
    }

    private static void array2DDemo() {
        System.out.println("-- Mang 2 chieu --");
        int[][] matrix = {
            {1, 2, 3},
            {4, 5, 6}
        };
        System.out.println("So hang = " + matrix.length + ", so cot = " + matrix[0].length);
        for (int[] row : matrix) {
            System.out.println("  " + Arrays.toString(row));
        }
        // Mảng răng cưa (jagged): mỗi hàng dài khác nhau
        int[][] jagged = new int[3][];
        for (int i = 0; i < jagged.length; i++) {
            jagged[i] = new int[i + 1];
        }
        System.out.println("jagged = " + Arrays.deepToString(jagged));
    }
}
