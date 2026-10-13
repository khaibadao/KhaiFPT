package danhsachten;
 
import java.util.Scanner;
import java.util.ArrayList;
 
public class DanhSachTen {
 
    static class DanhSach{
        String name;
        String ID;
        int yoB;
        double gr1, gr2;
 
        DanhSach(String name, String ID, int yoB, double gr1, double gr2){
            this.name = name;
            this.ID = ID;
            this.yoB = yoB;
            this.gr1 = gr1;
            this.gr2 = gr2;
        }
    }
 
    public static void main(String[] args) {
 
        System.out.println("=== Danh sach sinh vien cua lop ===");
        int sl;
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap so luong sinh vien: ");
        sl = sc.nextInt();
        sc.nextLine();
        ArrayList <DanhSach> List = new ArrayList(sl);
        ArrayList <Double> Point = new ArrayList(sl);
 
        for(int i = 1 ; i <= sl ; ++i){
            System.out.print("\n --------------------------\n");
            System.out.print("Hay nhap thong tin cua sinh vien thu: " + i + '\n');
 
            DanhSach Inf = Func.Nhap(List, sc);
            List.add(Inf);
            
            Double p1 = List.get(i - 1).gr1;
            Double p2 = List.get(i - 1).gr2;
            Double avr = (p1 + p2)/2;
            Point.add(avr);
        }
        
        System.out.println("\n ======================================================================");
        
 
        int cmd = 1;
        while(cmd > 0){
            do{
                Func.meunu();
                System.out.print("--> Type here: ");
                cmd = sc.nextInt();
                if(0 >= cmd || cmd > 4){
                    System.out.println("Invailed value. Please try again!");
                }
            }while(0 >= cmd || cmd > 4);
 
            System.out.println("");
 
            if(cmd == 1){
                Func.ShowList(List);
            }
            else if(cmd == 2){
                Func.FindStu(List, Point, sc, cmd);
            }else if(cmd == 3){
                Func.FindStu(List, Point, sc, cmd);
            }else if(cmd == 4){
                System.out.println("=== Exit ===");
                cmd = 0;
            }
        }
        return;
    }
}