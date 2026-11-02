package lesson06_inheritance;

/**
 * =====================================================================
 * LESSON 06 - LỚP TRỪU TƯỢNG (ABSTRACT CLASS) - LỚP CHA
 * =====================================================================
 * CHỨC NĂNG:
 *   Lớp cha chung cho mọi nhân viên. Không tạo object trực tiếp được
 *   (abstract), chỉ dùng để class con kế thừa.
 *
 * KÍCH THƯỚC:
 *   ~12 header + 4 (name) + 4 (id) + 8 (baseSalary) → ~32 byte.
 *   Object của class con chứa TOÀN BỘ field của cha + field của con.
 *
 * THUỘC TÍNH:
 *   - private final String id      : chỉ cha truy cập trực tiếp
 *   - protected String name        : class con đọc/ghi trực tiếp
 *   - protected double baseSalary  : class con dùng để tính lương
 *   - abstract calculateSalary()   : KHÔNG có thân, class con BẮT BUỘC override
 *   - final getId()                : class con KHÔNG được override
 *
 * SO SÁNH abstract class vs interface (xem lesson07):
 *   - abstract class: có field, constructor, method thường; extends được 1 class
 *   - interface     : hợp đồng thuần, implements được nhiều interface
 * =====================================================================
 */
public abstract class Employee {

    private final String id;
    protected String name;
    protected double baseSalary;

    // Abstract class VẪN có constructor, được gọi qua super(...) từ class con
    protected Employee(String id, String name, double baseSalary) {
        this.id = id;
        this.name = name;
        this.baseSalary = baseSalary;
    }

    // Phương thức trừu tượng: mỗi loại nhân viên tính lương khác nhau
    public abstract double calculateSalary();

    // final: không cho class con ghi đè
    public final String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // Method thường: class con có thể override hoặc dùng luôn
    public String getRole() {
        return "Employee";
    }

    @Override
    public String toString() {
        return String.format("%-10s %-6s %-12s salary=%,.0f",
                getRole(), id, name, calculateSalary());
    }
}
