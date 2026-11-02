package lesson11_project.model;

/**
 * =====================================================================
 * LESSON 11 - MINI PROJECT: QUẢN LÝ SINH VIÊN (tổng hợp lesson 01-10)
 * Person: lớp cha trừu tượng
 * =====================================================================
 * CHỨC NĂNG:
 *   Thông tin chung của một người. Student kế thừa từ đây.
 *
 * KÍCH THƯỚC:
 *   ~12 header + 4 (id) + 4 (name) → ~24 byte.
 *
 * THUỘC TÍNH:
 *   - protected final String id : class con đọc trực tiếp, không đổi được
 *   - protected String name
 *   - abstract getRole()        : class con tự định nghĩa vai trò
 * =====================================================================
 */
public abstract class Person {

    protected final String id;
    protected String name;

    protected Person(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public abstract String getRole();
}
