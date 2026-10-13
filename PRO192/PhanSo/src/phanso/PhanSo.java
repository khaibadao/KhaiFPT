package phanso;

import java.util.Scanner;

public class PhanSo {
    
    int tu, mau;
    
    PhanSo(int tu, int mau){
        this.tu = tu;
        this.mau = mau;
    }
    
    int UCLN(int a, int b){
        return (b == 0) ? a : UCLN(b, a%b);
    }
    
    PhanSo cong(PhanSo orther){
        int tu = this.tu * orther.mau + this.mau * orther.tu;
        int mau = this.mau * orther.mau;
        
        int uc = UCLN(tu, mau);
        PhanSo ans = new PhanSo(tu/uc, mau/uc);
        if(ans.mau < 0){
            ans.tu *= -1;
            ans.mau *= -1;
        }
        return ans;
    }
    
    PhanSo tru(PhanSo orther){
        int tu = this.tu * orther.mau - this.mau * orther.tu;
        int mau = this.mau * orther.mau;
        
        
        int uc = UCLN(tu, mau);
        PhanSo ans = new PhanSo(tu/uc, mau/uc);
        if(ans.mau < 0){
            ans.tu *= -1;
            ans.mau *= -1;
        }
        return ans;
    }
    
    PhanSo nhan(PhanSo orther){
        int tu = this.tu * orther.tu;
        int mau = this.mau * orther.mau;
        
        int uc = UCLN(tu, mau);
        PhanSo ans = new PhanSo(tu/uc, mau/uc);
        if(ans.mau < 0){
            ans.tu *= -1;
            ans.mau *= -1;
        }
        return ans;
    }
    
    PhanSo chia(PhanSo orther){
        int tu = this.tu * orther.mau;
        int mau = this.mau * orther.tu;
        
        int uc = UCLN(tu, mau);
        PhanSo ans = new PhanSo(tu/uc, mau/uc);
        if(ans.mau < 0){
            ans.tu *= -1;
            ans.mau *= -1;
        }
        return ans;
    }
    
    
    
    static PhanSo nhapPS(Scanner sc, String ten){
        System.out.print("Nhap tu cua " + ten);
        int a = sc.nextInt();
        int b;
        do
        {
            System.out.print("Nhap mau (khac 0) cua " + ten);
            b = sc.nextInt();
            if(b == 0) System.out.println("Mau khong hop le. Vui long nhap lai!!");
        }while(b == 0);
        return new PhanSo(a, b);
    }
    
    static void in(PhanSo ps1, PhanSo ps2, PhanSo ans, char op){
        System.out.println("=== Ket qua ===");
        if(ans.tu == 0) System.out.printf("%d/%d %c %d/%d = %d", ps1.tu, ps1.mau, op, ps2.tu, ps2.mau, 0);
        else System.out.printf("%d/%d %c %d/%d = %d/%d", ps1.tu, ps1.mau, op, ps2.tu, ps2.mau, ans.tu, ans.mau);
    }
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=== Phep tinh giua hai phan so ===");
        PhanSo ps1 = nhapPS(sc, "phan so dau tien: ");
        System.out.println("---------------------------------");
        PhanSo ps2 = nhapPS(sc, "phan so thu hai: ");
        
        System.out.println("---------------------------------");
        System.out.print("Nhap toan tu: ");
        char op = sc.next().charAt(0);
        
        if(op == '+'){
            PhanSo ans = ps1.cong(ps2);
            in(ps1, ps2, ans, op);
        }
        else if(op == '-'){
            PhanSo ans = ps1.tru(ps2);
            in(ps1, ps2, ans, op);
        } else if(op == '*'){
            PhanSo ans = ps1.nhan(ps2);
            in(ps1, ps2, ans, op);
        }
        else if(op == '/'){
            if(ps2.tu == 0){
                System.out.println("Math Error!");
            }else
            {
                PhanSo ans = ps1.chia(ps2);
                in(ps1, ps2, ans, op);
            }
            
        }
        
    }
    
}
