package lesson05_access_modifiers;

import lesson05_access_modifiers.other.OutsideUser;
import lesson05_access_modifiers.other.SavingsAccount;

/**
 * =====================================================================
 * LESSON 05 - DEMO PHẠM VI TRUY CẬP
 * =====================================================================
 * CHỨC NĂNG:
 *   Chạy lần lượt 3 góc nhìn: cùng package, class con khác package,
 *   class lạ khác package. Mở các dòng bị comment "LỖI" trong từng file
 *   để tự thấy trình biên dịch báo lỗi.
 * =====================================================================
 */
public class AccessModifierDemo {

    public static void run() {
        System.out.println("===== LESSON 05: ACCESS MODIFIERS =====");
        BankAccount acc = new BankAccount("VCB", "Le Khai", 1000, 1234);
        SamePackageUser.test(acc);
        OutsideUser.test(acc);

        SavingsAccount sav = new SavingsAccount("TCB", "Le Khai", 30, 9999, 50);
        sav.monthlyProcess();
        System.out.println("  So du sau phi: " + sav.getBalance());
    }
}
