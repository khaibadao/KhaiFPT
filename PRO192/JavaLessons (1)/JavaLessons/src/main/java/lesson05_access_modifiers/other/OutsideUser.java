package lesson05_access_modifiers.other;

import lesson05_access_modifiers.BankAccount;

/**
 * =====================================================================
 * LESSON 05 - CLASS KHÁC PACKAGE, KHÔNG KẾ THỪA
 * =====================================================================
 * CHỨC NĂNG:
 *   Class "người lạ": chỉ thấy được thành viên public.
 * =====================================================================
 */
public class OutsideUser {

    public static void test(BankAccount acc) {
        System.out.println("[Khac package, khong ke thua]");
        System.out.println("  public bankName     = " + acc.bankName);
        System.out.println("  public getBalance() = " + acc.getBalance());
        boolean ok = acc.withdraw(50, 1111);
        System.out.println("  withdraw sai PIN    = " + ok);
        ok = acc.withdraw(50, 1234);
        System.out.println("  withdraw dung PIN   = " + ok + ", con " + acc.getBalance());
        // acc.ownerName;            // LỖI: protected, mà OutsideUser không phải class con
        // acc.applyMonthlyFee(1);   // LỖI: protected
        System.out.println("  protected / default / private: deu KHONG thay");
    }
}
