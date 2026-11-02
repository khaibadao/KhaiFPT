package lesson04_class_object;

/**
 * =====================================================================
 * LESSON 04 - DEMO CLASS & OBJECT
 * =====================================================================
 * CHỨC NĂNG:
 *   Tạo object bằng các constructor khác nhau, gọi getter/setter,
 *   minh họa static vs instance, equals vs ==, tham chiếu dùng chung.
 *
 * KÍCH THƯỚC:
 *   Mỗi lần "new Student(...)" cấp phát ~32 byte trên HEAP.
 *   Biến s1, s2... nằm trên STACK, mỗi biến chỉ giữ 1 tham chiếu (4-8 byte).
 *
 * THUỘC TÍNH:
 *   Class này chỉ có method static nên không cần tạo object của nó.
 * =====================================================================
 */
public class ClassObjectDemo {

    public static void run() {
        System.out.println("===== LESSON 04: CLASS, OBJECT, ENCAPSULATION =====");

        Student s1 = new Student("DE210098", "Le Khai", 8.5, 20);
        Student s2 = new Student();                 // constructor mặc định
        Student s3 = new Student(s1);               // copy constructor
        Student s4 = s1;                            // KHÔNG tạo object mới

        System.out.println(s1);
        System.out.println(s2);
        System.out.println("So object Student da tao (static count) = " + Student.getCount());

        System.out.println("s1 == s3      : " + (s1 == s3) + "  (khac object)");
        System.out.println("s1.equals(s3) : " + s1.equals(s3) + "  (cung id)");
        System.out.println("s1 == s4      : " + (s1 == s4) + "  (cung tham chieu)");

        s4.setGpa(9.2);                             // sửa qua s4 → s1 cũng đổi
        System.out.println("Sau s4.setGpa(9.2): s1.gpa = " + s1.getGpa() + ", rank = " + s1.getRank());

        // Đóng gói: setter chặn dữ liệu sai
        try {
            s1.setGpa(11);
        } catch (IllegalArgumentException e) {
            System.out.println("Setter chan du lieu sai: " + e.getMessage());
        }

        // s1.gpa = 11;      // LỖI BIÊN DỊCH: gpa là private
        // s1.id = "X";      // LỖI BIÊN DỊCH: id là private final
        System.out.println("Hang so MAX_GPA = " + Student.MAX_GPA);
    }
}
