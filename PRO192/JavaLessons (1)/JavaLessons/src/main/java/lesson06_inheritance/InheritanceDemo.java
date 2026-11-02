package lesson06_inheritance;

/**
 * =====================================================================
 * LESSON 06 - DEMO KẾ THỪA (INHERITANCE) & ĐA HÌNH (POLYMORPHISM)
 * =====================================================================
 * CHỨC NĂNG:
 *   - Mảng kiểu cha chứa object con (upcasting tự động)
 *   - Gọi calculateSalary(): Java chọn phiên bản của class con lúc chạy
 *     (dynamic binding / late binding)
 *   - instanceof + downcasting để gọi method riêng của class con
 *
 * PHÂN BIỆT:
 *   - Overloading: cùng tên, KHÁC tham số, quyết định lúc BIÊN DỊCH
 *   - Overriding : cùng tên, CÙNG tham số, ở class con, quyết định lúc CHẠY
 * =====================================================================
 */
public class InheritanceDemo {

    public static void run() {
        System.out.println("===== LESSON 06: INHERITANCE & POLYMORPHISM =====");

        // Employee e = new Employee(...);   // LỖI: abstract class không new được

        Employee[] staff = {
            new Developer("D01", "An", 15_000_000, 10),
            new Manager("M01", "Binh", 20_000_000, 5),
            new Developer("D02", "Chi", 12_000_000, 0)
        };

        double total = 0;
        for (Employee e : staff) {
            System.out.println("  " + e);           // toString() gọi getRole() đã override
            total += e.calculateSalary();            // đa hình
        }
        System.out.printf("  Tong quy luong = %,.0f%n", total);

        System.out.println("-- instanceof & downcasting --");
        for (Employee e : staff) {
            if (e instanceof Developer d) {          // pattern matching (Java 16+)
                d.code();
            } else if (e instanceof Manager) {
                Manager m = (Manager) e;             // ép kiểu xuống kiểu cũ
                System.out.println("  " + m.getName() + " quan ly " + m.getTeamSize() + " nguoi");
            }
        }
    }
}
