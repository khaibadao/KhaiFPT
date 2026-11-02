package lesson06_inheritance;

/**
 * =====================================================================
 * LESSON 06 - CLASS CON: Developer
 * =====================================================================
 * CHỨC NĂNG:
 *   Lập trình viên: lương = lương cơ bản + số giờ OT × đơn giá OT.
 *
 * KÍCH THƯỚC:
 *   Employee (~32) + int overtimeHours (4) → ~40 byte.
 *
 * THUỘC TÍNH:
 *   - private int overtimeHours
 *   - private static final double OT_RATE: hằng số dùng chung
 * =====================================================================
 */
public class Developer extends Employee {

    private static final double OT_RATE = 200_000;   // dấu _ giúp đọc số dễ hơn
    private int overtimeHours;

    public Developer(String id, String name, double baseSalary, int overtimeHours) {
        super(id, name, baseSalary);      // super(...) PHẢI là dòng đầu tiên
        this.overtimeHours = overtimeHours;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + overtimeHours * OT_RATE;
    }

    @Override
    public String getRole() {
        return "Developer";
    }

    // Method riêng của Developer, biến kiểu Employee không gọi được
    public void code() {
        System.out.println("  " + name + " dang code...");
    }
}
