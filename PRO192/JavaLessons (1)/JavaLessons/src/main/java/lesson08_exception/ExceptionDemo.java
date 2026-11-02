package lesson08_exception;

/**
 * =====================================================================
 * LESSON 08 - XỬ LÝ NGOẠI LỆ (EXCEPTION HANDLING)
 * =====================================================================
 * CHỨC NĂNG:
 *   try / catch / finally, multi-catch, throw vs throws,
 *   checked vs unchecked, custom exception, lan truyền ngoại lệ.
 *
 * CÂY KẾ THỪA:
 *   Throwable
 *   ├── Error                      (lỗi JVM: OutOfMemoryError, StackOverflowError → không bắt)
 *   └── Exception                  (CHECKED: bắt buộc xử lý)
 *       ├── IOException, FileNotFoundException, InvalidScoreException...
 *       └── RuntimeException       (UNCHECKED: không bắt buộc)
 *           ├── ArithmeticException, NullPointerException
 *           ├── ArrayIndexOutOfBoundsException, NumberFormatException
 *           └── IllegalArgumentException, InsufficientStockException...
 *
 * THUỘC TÍNH:
 *   - throw  : NÉM 1 object exception, viết trong thân method
 *   - throws : KHAI BÁO method có thể ném, viết ở chữ ký method
 *   - catch cụ thể đặt TRƯỚC catch tổng quát (Exception), ngược lại lỗi biên dịch
 *   - finally luôn chạy, kể cả khi có return trong try
 * =====================================================================
 */
public class ExceptionDemo {

    private static int stock = 5;

    public static void run() {
        System.out.println("===== LESSON 08: EXCEPTION HANDLING =====");
        basicTryCatch();
        multiCatch(new String[]{"10", "abc", "0", null});
        checkedDemo();
        uncheckedDemo();
        System.out.println("-- finally voi return --");
        System.out.println("  ket qua = " + finallyWithReturn());
        propagationDemo();
    }

    private static void basicTryCatch() {
        System.out.println("-- try / catch / finally --");
        try {
            int[] arr = new int[3];
            arr[5] = 1;                                   // ném ArrayIndexOutOfBoundsException
            System.out.println("  Dong nay khong chay");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("  Bat duoc: " + e.getClass().getSimpleName() + " - " + e.getMessage());
        } finally {
            System.out.println("  finally luon chay");
        }
    }

    private static void multiCatch(String[] inputs) {
        System.out.println("-- Nhieu catch --");
        for (String in : inputs) {
            try {
                int n = Integer.parseInt(in.trim());      // null → NullPointerException
                System.out.println("  100 / " + n + " = " + (100 / n));
            } catch (NumberFormatException e) {
                System.out.println("  '" + in + "' khong phai so");
            } catch (ArithmeticException | NullPointerException e) {   // multi-catch (Java 7+)
                System.out.println("  Loi tinh toan/null: " + e.getClass().getSimpleName());
            }
        }
    }

    // throws: khai báo method có thể ném checked exception
    public static void validateScore(double score) throws InvalidScoreException {
        if (score < 0 || score > 10) {
            throw new InvalidScoreException("Diem phai tu 0 den 10", score);   // throw: ném
        }
    }

    private static void checkedDemo() {
        System.out.println("-- Checked custom exception --");
        double[] scores = {8.5, 11, -1};
        for (double s : scores) {
            try {
                validateScore(s);
                System.out.println("  " + s + " hop le");
            } catch (InvalidScoreException e) {
                System.out.println("  " + e.getMessage() + ", nhan duoc " + e.getInvalidScore());
            }
        }
    }

    private static void sell(int qty) {
        if (qty > stock) {
            throw new InsufficientStockException("Can " + qty + " nhung kho chi con " + stock);
        }
        stock -= qty;
    }

    private static void uncheckedDemo() {
        System.out.println("-- Unchecked custom exception --");
        sell(3);                                   // không cần try-catch vẫn biên dịch được
        System.out.println("  Ban 3, kho con " + stock);
        try {
            sell(10);
        } catch (InsufficientStockException e) {
            System.out.println("  " + e.getMessage());
        }
    }

    @SuppressWarnings("finally")
    private static String finallyWithReturn() {
        try {
            return "tu try";
        } finally {
            System.out.println("  finally chay truoc khi method thuc su tra ve");
        }
    }

    // Ngoại lệ lan từ level3 → level2 → level1 cho tới khi có catch
    private static void level3() throws InvalidScoreException {
        validateScore(99);
    }

    private static void level2() throws InvalidScoreException {
        level3();                                  // không bắt, ném tiếp lên trên
    }

    private static void propagationDemo() {
        System.out.println("-- Lan truyen ngoai le --");
        try {
            level2();
        } catch (InvalidScoreException e) {
            System.out.println("  Bat tai tang ngoai cung: " + e.getMessage());
            StackTraceElement top = e.getStackTrace()[0];
            System.out.println("  Noi phat sinh: " + top.getMethodName() + "()");
        }
    }
}
