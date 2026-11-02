package lesson01_datatypes;

/**
 * =====================================================================
 * LESSON 01 - KIỂU DỮ LIỆU (DATA TYPES)
 * =====================================================================
 * CHỨC NĂNG:
 *   Giới thiệu 8 kiểu nguyên thủy (primitive types), kiểu tham chiếu
 *   (reference types), lớp bao (wrapper class) và ép kiểu (casting).
 *
 * KÍCH THƯỚC 8 KIỂU NGUYÊN THỦY:
 *   +---------+----------+--------------------------------------------+---------------+
 *   | Kiểu    | Kích thước| Phạm vi giá trị                           | Mặc định      |
 *   +---------+----------+--------------------------------------------+---------------+
 *   | byte    | 1 byte   | -128 .. 127                                | 0             |
 *   | short   | 2 byte   | -32,768 .. 32,767                          | 0             |
 *   | int     | 4 byte   | -2,147,483,648 .. 2,147,483,647 (~2.1 tỷ)  | 0             |
 *   | long    | 8 byte   | -9.22e18 .. 9.22e18   (viết hậu tố L)      | 0L            |
 *   | float   | 4 byte   | ~6-7 chữ số thập phân (viết hậu tố f)      | 0.0f          |
 *   | double  | 8 byte   | ~15-16 chữ số thập phân                    | 0.0d          |
 *   | char    | 2 byte   | 0 .. 65,535 (ký tự Unicode UTF-16)         | '\u0000'      |
 *   | boolean | JVM quyết| true / false (thường 1 byte trong mảng)    | false         |
 *   +---------+----------+--------------------------------------------+---------------+
 *
 * THUỘC TÍNH:
 *   - Kiểu nguyên thủy lưu GIÁ TRỊ trực tiếp, không thể là null.
 *   - Kiểu tham chiếu (String, mảng, object) lưu ĐỊA CHỈ tới object
 *     trên heap; có thể là null. Biến tham chiếu chiếm 4 hoặc 8 byte
 *     tùy JVM (thường 4 byte khi bật compressed oops).
 *   - Giá trị mặc định ở bảng trên chỉ áp dụng cho THUỘC TÍNH (field);
 *     biến cục bộ (local variable) PHẢI gán trước khi dùng.
 *   - Ép kiểu mở rộng (widening) tự động: byte→short→int→long→float→double
 *   - Ép kiểu thu hẹp (narrowing) phải viết rõ: (int) 3.9 → 3 (mất phần lẻ)
 * =====================================================================
 */
public class DataTypes {

    // Field static: có giá trị mặc định, dùng để minh họa mặc định
    private static int defaultInt;
    private static boolean defaultBoolean;
    private static String defaultString;   // kiểu tham chiếu → null

    // Hằng số: static final, viết HOA theo quy ước
    public static final double VAT_RATE = 0.1;

    public static void run() {
        System.out.println("===== LESSON 01: DATA TYPES =====");
        printSizes();
        printDefaults();
        castingDemo();
        wrapperDemo();
        overflowDemo();
    }

    // private: chỉ dùng nội bộ trong class này
    private static void printSizes() {
        System.out.println("-- Kich thuoc (bit) va pham vi --");
        System.out.printf("byte   : %2d bit  [%d .. %d]%n", Byte.SIZE, Byte.MIN_VALUE, Byte.MAX_VALUE);
        System.out.printf("short  : %2d bit  [%d .. %d]%n", Short.SIZE, Short.MIN_VALUE, Short.MAX_VALUE);
        System.out.printf("int    : %2d bit  [%d .. %d]%n", Integer.SIZE, Integer.MIN_VALUE, Integer.MAX_VALUE);
        System.out.printf("long   : %2d bit  [%d .. %d]%n", Long.SIZE, Long.MIN_VALUE, Long.MAX_VALUE);
        System.out.printf("float  : %2d bit  [%e .. %e]%n", Float.SIZE, Float.MIN_VALUE, Float.MAX_VALUE);
        System.out.printf("double : %2d bit  [%e .. %e]%n", Double.SIZE, Double.MIN_VALUE, Double.MAX_VALUE);
        System.out.printf("char   : %2d bit  [%d .. %d]%n", Character.SIZE,
                (int) Character.MIN_VALUE, (int) Character.MAX_VALUE);
        System.out.println("boolean: kich thuoc do JVM quyet dinh (true/false)");
    }

    private static void printDefaults() {
        System.out.println("-- Gia tri mac dinh cua field --");
        System.out.println("int     = " + defaultInt);
        System.out.println("boolean = " + defaultBoolean);
        System.out.println("String  = " + defaultString);
    }

    private static void castingDemo() {
        System.out.println("-- Ep kieu (casting) --");
        int i = 100;
        long l = i;              // widening: tự động
        double d = l;            // widening: tự động
        System.out.println("int -> long -> double: " + d);

        double pi = 3.99;
        int truncated = (int) pi;   // narrowing: bắt buộc viết (int), cắt bỏ phần lẻ
        System.out.println("(int) 3.99 = " + truncated);

        char c = 'A';
        int code = c;               // char → int: lấy mã Unicode
        System.out.println("'A' co ma = " + code + ", (char)(code+1) = " + (char) (code + 1));

        // Chia số nguyên: kết quả cắt phần lẻ
        System.out.println("7 / 2 = " + (7 / 2) + " | 7 / 2.0 = " + (7 / 2.0));
    }

    private static void wrapperDemo() {
        System.out.println("-- Wrapper class & autoboxing --");
        // Mỗi kiểu nguyên thủy có 1 lớp bao: int→Integer, double→Double, char→Character...
        Integer boxed = 42;                 // autoboxing: int → Integer
        int unboxed = boxed;                // unboxing: Integer → int
        Integer nullable = null;            // wrapper có thể null, primitive thì không
        int parsed = Integer.parseInt("123");   // chuyển String → int
        System.out.println("boxed=" + boxed + ", unboxed=" + unboxed
                + ", nullable=" + nullable + ", parsed=" + parsed);

        // Bẫy hay gặp: so sánh Integer bằng == chỉ đúng trong cache -128..127
        Integer a = 127, b = 127, x = 128, y = 128;
        System.out.println("127==127: " + (a == b) + " | 128==128: " + (x == y)
                + " | 128.equals(128): " + x.equals(y));
    }

    private static void overflowDemo() {
        System.out.println("-- Tran so (overflow) --");
        int max = Integer.MAX_VALUE;
        System.out.println("Integer.MAX_VALUE + 1 = " + (max + 1));   // quay vòng về số âm
        long safe = (long) max + 1;
        System.out.println("(long) MAX + 1        = " + safe);
        System.out.println("0.1 + 0.2 = " + (0.1 + 0.2) + "  (sai so dau cham dong)");
    }
}
