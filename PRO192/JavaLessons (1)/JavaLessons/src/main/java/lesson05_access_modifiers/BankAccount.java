package lesson05_access_modifiers;

/**
 * =====================================================================
 * LESSON 05 - PHẠM VI TRUY CẬP (ACCESS MODIFIERS)
 * =====================================================================
 * CHỨC NĂNG:
 *   Một tài khoản ngân hàng có đủ 4 mức truy cập để so sánh xem
 *   ai được nhìn thấy cái gì.
 *
 * BẢNG PHẠM VI (✔ = truy cập được):
 *   +-------------------+-------+---------+-----------------+-----------+
 *   | Modifier          | Class | Package | Subclass (khác  | Mọi nơi   |
 *   |                   |       |         | package)        |           |
 *   +-------------------+-------+---------+-----------------+-----------+
 *   | public            |   ✔   |    ✔    |        ✔        |     ✔     |
 *   | protected         |   ✔   |    ✔    |        ✔        |     ✘     |
 *   | (default/package) |   ✔   |    ✔    |        ✘        |     ✘     |
 *   | private           |   ✔   |    ✘    |        ✘        |     ✘     |
 *   +-------------------+-------+---------+-----------------+-----------+
 *   Quy tắc dễ nhớ: public > protected > default > private
 *
 * KÍCH THƯỚC:
 *   Modifier KHÔNG ảnh hưởng kích thước object; chỉ trình biên dịch kiểm tra.
 *   Object này ≈ 12 (header) + 4 + 4 + 8 + 4 + 1 → làm tròn ~40 byte.
 *
 * THUỘC TÍNH:
 *   - public    String bankName  : ai cũng đọc được
 *   - protected String ownerName : class con (kể cả khác package) dùng được
 *   - (default) double interest  : chỉ class cùng package
 *   - private   double balance   : chỉ chính class này, thay đổi qua method
 *   - private   int pin          : bí mật tuyệt đối, không có getter
 *
 *   Áp dụng cho class:
 *   - top-level class chỉ có thể là public hoặc default.
 *   - Mỗi file .java chỉ có tối đa 1 public class, trùng tên file.
 * =====================================================================
 */
public class BankAccount {

    public String bankName;
    protected String ownerName;
    double interestRate;            // default: không ghi modifier
    private double balance;
    private int pin;
    private boolean locked;

    public BankAccount(String bankName, String ownerName, double balance, int pin) {
        this.bankName = bankName;
        this.ownerName = ownerName;
        this.interestRate = 0.05;
        this.balance = balance;
        this.pin = pin;
    }

    // public: API cho bên ngoài dùng
    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount, int enteredPin) {
        if (locked || !checkPin(enteredPin) || amount <= 0 || amount > balance) {
            return false;
        }
        balance -= amount;
        return true;
    }

    public void deposit(double amount) {
        if (amount > 0) balance += amount;
    }

    // protected: class con có thể dùng/ghi đè
    protected void applyMonthlyFee(double fee) {
        balance -= fee;
    }

    // default: chỉ class trong lesson05_access_modifiers gọi được
    void addInterest() {
        balance += balance * interestRate;
    }

    // private: logic nội bộ, giấu khỏi bên ngoài
    private boolean checkPin(int enteredPin) {
        return pin == enteredPin;
    }

    public void lock() {
        locked = true;
    }

    @Override
    public String toString() {
        return String.format("%s | %s | balance=%.2f", bankName, ownerName, balance);
    }
}
