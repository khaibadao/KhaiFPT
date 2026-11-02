package lesson03_methods_strings;

/**
 * =====================================================================
 * LESSON 03 - PHƯƠNG THỨC (METHOD) & CHUỖI (STRING)
 * =====================================================================
 * CHỨC NĂNG:
 *   Khai báo method, tham số, giá trị trả về, nạp chồng (overloading),
 *   varargs, truyền tham trị; các thao tác String và StringBuilder.
 *
 * KÍCH THƯỚC:
 *   - String: length() trả về số ký tự (char, mỗi char 2 byte).
 *     Từ Java 9 dùng "compact strings": chuỗi chỉ có Latin-1 lưu 1 byte/ký tự.
 *   - StringBuilder: có capacity (mặc định 16) tự nới rộng khi đầy.
 *
 * THUỘC TÍNH:
 *   - String là BẤT BIẾN (immutable): mọi phép "sửa" đều tạo String mới.
 *   - So sánh nội dung dùng equals(), KHÔNG dùng == (== so địa chỉ).
 *   - StringBuilder là KHẢ BIẾN (mutable): nối chuỗi trong vòng lặp nhanh hơn.
 *   - Java luôn TRUYỀN THAM TRỊ (pass-by-value). Với object, giá trị được
 *     truyền là bản sao địa chỉ → sửa nội dung object thì thấy, gán lại
 *     biến thì không.
 * =====================================================================
 */
public class MethodsAndStrings {

    public static void run() {
        System.out.println("===== LESSON 03: METHODS & STRINGS =====");
        overloadingDemo();
        passByValueDemo();
        stringDemo();
        stringBuilderDemo();
    }

    // ---------- OVERLOADING: cùng tên, khác danh sách tham số ----------
    static int add(int a, int b) {
        return a + b;
    }

    static double add(double a, double b) {
        return a + b;
    }

    static int add(int a, int b, int c) {
        return a + b + c;
    }

    // varargs: nhận số lượng tham số tùy ý, bên trong là mảng
    static int sum(int... nums) {
        int total = 0;
        for (int n : nums) total += n;
        return total;
    }

    private static void overloadingDemo() {
        System.out.println("-- Overloading & varargs --");
        System.out.println("add(1,2)       = " + add(1, 2));
        System.out.println("add(1.5,2.5)   = " + add(1.5, 2.5));
        System.out.println("add(1,2,3)     = " + add(1, 2, 3));
        System.out.println("sum()          = " + sum());
        System.out.println("sum(1,2,3,4,5) = " + sum(1, 2, 3, 4, 5));
    }

    // ---------- PASS-BY-VALUE ----------
    private static void changePrimitive(int x) {
        x = 100;                     // chỉ đổi bản sao
    }

    private static void changeArrayContent(int[] arr) {
        arr[0] = 100;                // sửa nội dung object → bên ngoài thấy
    }

    private static void reassignArray(int[] arr) {
        arr = new int[]{-1};         // gán lại bản sao địa chỉ → bên ngoài KHÔNG thấy
    }

    private static void passByValueDemo() {
        System.out.println("-- Pass-by-value --");
        int a = 5;
        changePrimitive(a);
        int[] arr = {1, 2, 3};
        changeArrayContent(arr);
        int[] arr2 = {1, 2, 3};
        reassignArray(arr2);
        System.out.println("a=" + a + " | arr[0]=" + arr[0] + " | arr2[0]=" + arr2[0]);
    }

    // ---------- STRING ----------
    private static void stringDemo() {
        System.out.println("-- String --");
        String s = "  Le Khai, DE210098, 8.5  ";
        String t = s.trim();
        System.out.println("trim()        : [" + t + "]");
        System.out.println("length()      : " + t.length());
        System.out.println("toUpperCase() : " + t.toUpperCase());
        System.out.println("charAt(0)     : " + t.charAt(0));
        System.out.println("indexOf(\"DE\") : " + t.indexOf("DE"));
        System.out.println("substring(0,7): " + t.substring(0, 7));
        System.out.println("contains(\"Khai\"): " + t.contains("Khai"));
        System.out.println("replace(',',';'): " + t.replace(',', ';'));

        String[] parts = t.split(",\\s*");    // tách theo dấu phẩy + khoảng trắng
        double gpa = Double.parseDouble(parts[2]);
        System.out.println("split -> ten=" + parts[0] + ", mssv=" + parts[1] + ", gpa=" + gpa);

        // == vs equals
        String x = "java";
        String y = "java";                    // cùng nằm trong String pool
        String z = new String("java");        // object mới trên heap
        System.out.println("x==y: " + (x == y) + " | x==z: " + (x == z)
                + " | x.equals(z): " + x.equals(z)
                + " | equalsIgnoreCase(\"JAVA\"): " + x.equalsIgnoreCase("JAVA"));
        System.out.println("compareTo(\"b\"): " + "a".compareTo("b") + " (am = dung truoc)");
        System.out.println("String.format: " + String.format("%-10s|%5.2f", "GPA", gpa));
    }

    private static void stringBuilderDemo() {
        System.out.println("-- StringBuilder --");
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= 5; i++) {
            sb.append(i);
            if (i < 5) sb.append("-");
        }
        System.out.println("append  : " + sb);
        System.out.println("reverse : " + new StringBuilder(sb).reverse());
        sb.insert(0, "[").append("]");
        System.out.println("insert  : " + sb + " (length=" + sb.length() + ")");
    }
}
