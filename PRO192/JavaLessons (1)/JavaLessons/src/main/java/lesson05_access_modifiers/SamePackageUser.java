package lesson05_access_modifiers;

/**
 * =====================================================================
 * LESSON 05 - CLASS CÙNG PACKAGE
 * =====================================================================
 * CHỨC NĂNG:
 *   Chứng minh class cùng package thấy được public, protected và default,
 *   nhưng KHÔNG thấy private.
 *
 * THUỘC TÍNH:
 *   Class không ghi modifier → default: chỉ dùng được trong package này.
 * =====================================================================
 */
class SamePackageUser {

    static void test(BankAccount acc) {
        System.out.println("[Cung package]");
        System.out.println("  public    bankName     = " + acc.bankName);
        System.out.println("  protected ownerName    = " + acc.ownerName);
        System.out.println("  default   interestRate = " + acc.interestRate);
        acc.addInterest();                       // default method: OK
        System.out.printf("  goi addInterest() -> balance = %.2f%n", acc.getBalance());
        // acc.balance;        // LỖI: private
        // acc.checkPin(1234); // LỖI: private
        System.out.println("  private balance/pin: KHONG truy cap duoc, phai qua getBalance()");
    }
}
