package lesson06_inheritance;

/**
 * =====================================================================
 * LESSON 06 - CLASS CON: Manager
 * =====================================================================
 * CHỨC NĂNG:
 *   Quản lý: lương = lương cơ bản × 1.5 + phụ cấp theo số nhân viên.
 *   Minh họa super.method() để gọi lại phiên bản của lớp cha.
 *
 * KÍCH THƯỚC:
 *   Employee (~32) + int teamSize (4) → ~40 byte.
 *
 * THUỘC TÍNH:
 *   - private int teamSize
 * =====================================================================
 */
public class Manager extends Employee {

    private int teamSize;

    public Manager(String id, String name, double baseSalary, int teamSize) {
        super(id, name, baseSalary);
        this.teamSize = teamSize;
    }

    @Override
    public double calculateSalary() {
        return baseSalary * 1.5 + teamSize * 500_000;
    }

    @Override
    public String getRole() {
        // Không override thì sẽ trả "Employee" như lớp cha
        return "Manager";
    }

    // super.method(): gọi lại phiên bản của lớp cha rồi bổ sung thêm
    @Override
    public String toString() {
        return super.toString() + "  team=" + teamSize;
    }

    public int getTeamSize() {
        return teamSize;
    }
}
