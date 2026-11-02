package lesson05_access_modifiers.other;

import lesson05_access_modifiers.BankAccount;

/**
 * =====================================================================
 * LESSON 05 - CLASS CON Ở PACKAGE KHÁC
 * =====================================================================
 * CHỨC NĂNG:
 *   Kế thừa BankAccount từ package khác để chứng minh:
 *   class con thấy public + protected, KHÔNG thấy default + private.
 *
 * KÍCH THƯỚC:
 *   = kích thước BankAccount + 8 byte (double minBalance), làm tròn bội số 8.
 *   Field private của cha VẪN NẰM trong object con, chỉ là không truy cập trực tiếp.
 *
 * THUỘC TÍNH:
 *   - private double minBalance : riêng của class con
 * =====================================================================
 */
public class SavingsAccount extends BankAccount {

    private double minBalance;

    public SavingsAccount(String bankName, String ownerName, double balance, int pin, double minBalance) {
        super(bankName, ownerName, balance, pin);
        this.minBalance = minBalance;
    }

    public void monthlyProcess() {
        System.out.println("[Class con, khac package]");
        System.out.println("  public    bankName  = " + bankName);
        System.out.println("  protected ownerName = " + ownerName);
        if (getBalance() < minBalance) {
            applyMonthlyFee(2.0);                // protected method: OK vì là class con
            System.out.println("  Duoi so du toi thieu -> tru phi qua protected applyMonthlyFee()");
        }
        // interestRate;   // LỖI: default, khác package
        // addInterest();  // LỖI: default, khác package
        // balance;        // LỖI: private
        System.out.println("  default interestRate / addInterest(): KHONG thay (khac package)");
    }
}
