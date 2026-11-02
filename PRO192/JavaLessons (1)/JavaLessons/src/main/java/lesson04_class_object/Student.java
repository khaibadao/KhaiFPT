package lesson04_class_object;

import java.util.Objects;

/**
 * =====================================================================
 * LESSON 04 - LỚP (CLASS), ĐỐI TƯỢNG (OBJECT), ĐÓNG GÓI (ENCAPSULATION)
 * =====================================================================
 * CHỨC NĂNG:
 *   Mô tả một sinh viên: thuộc tính, constructor, getter/setter có kiểm
 *   tra dữ liệu, thành viên static, hằng final, toString/equals/hashCode.
 *
 * KÍCH THƯỚC (ước lượng trên JVM 64-bit, compressed oops):
 *   - Object header             : 12 byte
 *   - String id   (tham chiếu)  :  4 byte
 *   - String name (tham chiếu)  :  4 byte
 *   - double gpa                :  8 byte
 *   - int age                   :  4 byte
 *   → ~32 byte (làm tròn bội số 8), CHƯA tính 2 object String bên trong.
 *   - Field static (count) KHÔNG nằm trong từng object, chỉ có 1 bản cho cả class.
 *
 * THUỘC TÍNH:
 *   - private  id, name, gpa, age : chỉ truy cập qua getter/setter (đóng gói)
 *   - private static int count    : đếm số object đã tạo, dùng chung
 *   - public static final MAX_GPA : hằng số, không đổi được
 *   - final id                    : gán 1 lần trong constructor, không có setter
 * =====================================================================
 */
public class Student {

    // ---------- HẰNG SỐ ----------
    public static final double MAX_GPA = 10.0;
    public static final double MIN_GPA = 0.0;

    // ---------- STATIC: thuộc về class ----------
    private static int count = 0;

    // ---------- INSTANCE FIELD: thuộc về từng object ----------
    private final String id;     // final: không đổi sau khi tạo
    private String name;
    private double gpa;
    private int age;

    // ---------- CONSTRUCTOR ----------
    // Constructor mặc định (không tham số) gọi constructor khác bằng this(...)
    public Student() {
        this("UNKNOWN", "No name", 0.0, 18);
    }

    // Constructor có tham số: this.x phân biệt field với tham số cùng tên
    public Student(String id, String name, double gpa, int age) {
        this.id = id;
        setName(name);      // tái sử dụng logic kiểm tra trong setter
        setGpa(gpa);
        setAge(age);
        count++;
    }

    // Copy constructor: tạo bản sao từ object khác
    public Student(Student other) {
        this(other.id, other.name, other.gpa, other.age);
    }

    // ---------- GETTER ----------
    public String getId() { return id; }
    public String getName() { return name; }
    public double getGpa() { return gpa; }
    public int getAge() { return age; }

    public static int getCount() { return count; }

    // ---------- SETTER: kiểm tra dữ liệu trước khi gán ----------
    // final: constructor gọi các setter này, nên cấm class con override
    // (tránh class con chạy code khi object chưa khởi tạo xong)
    public final void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Ten khong duoc rong");
        }
        this.name = name.trim();
    }

    public final void setGpa(double gpa) {
        if (gpa < MIN_GPA || gpa > MAX_GPA) {
            throw new IllegalArgumentException("GPA phai trong [0, 10]: " + gpa);
        }
        this.gpa = gpa;
    }

    public final void setAge(int age) {
        if (age < 15 || age > 100) {
            throw new IllegalArgumentException("Tuoi khong hop le: " + age);
        }
        this.age = age;
    }

    // ---------- METHOD NGHIỆP VỤ ----------
    public String getRank() {
        if (gpa >= 9) return "Xuat sac";
        if (gpa >= 8) return "Gioi";
        if (gpa >= 6.5) return "Kha";
        return "Trung binh";
    }

    // ---------- OVERRIDE TỪ Object ----------
    @Override
    public String toString() {
        return String.format("Student{id=%s, name=%s, gpa=%.2f, age=%d, rank=%s}",
                id, name, gpa, age, getRank());
    }

    // Hai sinh viên bằng nhau khi trùng id
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student other = (Student) o;
        return Objects.equals(id, other.id);
    }

    // equals dùng trường nào thì hashCode phải dùng đúng trường đó
    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
