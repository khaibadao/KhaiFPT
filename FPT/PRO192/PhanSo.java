import java.util.Scanner;

public class PhanSo {
    /*
     * Thực hiện bài toán cộng trừ hai phân số
     */

    static int[] s = new int[4]; 

    static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    static int[] Rutgon(int x, int y) {
        int uc = gcd(x, y);

        x /= uc;
        y /= uc;

        return new int[]{x, y};
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Nhập phân số 1
        System.out.println("Phan so dau tien: ");
        System.out.print("Tu: ");
        s[0] = sc.nextInt();

        System.out.print("Mau: ");
        s[1] = sc.nextInt();

        System.out.println("-----------\nPhan so thu hai: ");
        System.out.print("Tu: ");
        s[2] = sc.nextInt();

        System.out.print("Mau: ");
        s[3] = sc.nextInt();

        // Rút gọn phân số 1
        int[] ps1 = Rutgon(s[0], s[1]);
        s[0] = ps1[0];
        s[1] = ps1[1];

        // Rút gọn phân số 2
        int[] ps2 = Rutgon(s[2], s[3]);
        s[2] = ps2[0];
        s[3] = ps2[1];

        System.out.print("Nhap phep toan: ");
        char op = sc.next().charAt(0);

        if (op == '+') {
            int tu = s[0] * s[3] + s[1] * s[2];
            int mau = s[1] * s[3];

            int[] ans = Rutgon(tu, mau);

            System.out.printf(
                "%d/%d + %d/%d = %d/%d",
                s[0], s[1],
                s[2], s[3],
                ans[0], ans[1]
            );
        }
    }
}