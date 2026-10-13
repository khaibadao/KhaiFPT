package danhsachten;
 
import java.util.Scanner;
import java.util.ArrayList;
 
class Func
{
    
    // Func check ID
    
    static boolean checkID(String s){
        s = s.trim();
        if(s.isEmpty()) return false;
        if(s.length() < 8 || s.length() > 8) return false;
        if(s.charAt(0) != 'D' || s.charAt(1) != 'E') return false;
        for(int i = 2 ; i < s.length(); ++i){
            char kt = s.charAt(i);
            if('0' <= kt && kt <= '9') continue;
            else return false;
        }
        return true;
    }
    
    static boolean checkValidID(ArrayList <DanhSachTen.DanhSach> a, String ID){
        for(int i = 0 ; i < a.size() ; ++i){
            DanhSachTen.DanhSach t = a.get(i);
            if(t.ID.equals(ID)) return false;
        }
        return true;
    }
    
    static int SearchInf(ArrayList <DanhSachTen.DanhSach> a, String ID){
        for(int i = 0 ; i < a.size() ; ++i){
            DanhSachTen.DanhSach t = a.get(i);
            if(t.ID.equals(ID)) return i;
        }
        return -1;
    }
    
 
//    ------------------------------------------------------------------------------------ //
    
    // Func Check Name
    
    static boolean checkName(String s){
        s = s.trim();
        if(s.isEmpty()) return false;
        for(int i = 0 ; i < s.length(); ++i){
            char kt = s.charAt(i);
            if(('a' <= kt && kt <= 'z') || ('A' <= kt && kt <= 'Z') || kt == ' ') continue;
            else return false;
        }
        return true;
    }
 
    static boolean checkGr(double x){
        if(0.0 <= x && x <= 10) return true;
        return false;
    }
 
    static DanhSachTen.DanhSach Nhap(ArrayList <DanhSachTen.DanhSach> a, Scanner sc){
        String nae;
        String ID;
        int yoB;
        double gr1, gr2;
 
        do{
            System.out.print("Name: ");
            nae = sc.nextLine();
            if(checkName(nae) == false){
                System.out.println("Invalid ID. Please try again!");
            }
        }while(checkName(nae) == false);
 
        do{
            System.out.print("ID: ");
            ID = sc.next();
            if(checkID(ID) == false){
                System.out.println("Invalid ID. Please try again!");
            }
            else if(checkValidID(a, ID) == false){
                System.out.println("This ID has already exists in the system. Please try again!");
            }
        }while(checkID(ID) == false || checkValidID(a, ID) == false);
 
        System.out.print("Year of Birth: ");
        yoB = sc.nextInt();
 
        do{
            System.out.print("Diem mon thu nhat: ");
            gr1 = sc.nextDouble();
            sc.nextLine();
            if(checkGr(gr1) == false){
                System.out.println("Invalid ID. Please try again!");
            }
        }while(checkGr(gr1) == false);
 
        do{
            System.out.print("Diem mon thu hai: ");
            gr2 = sc.nextDouble();
            sc.nextLine();
            if(checkGr(gr2) == false){
                System.out.println("Invalid ID. Please try again!");
            }
        }while(checkGr(gr2) == false);
 
        DanhSachTen.DanhSach ans = new DanhSachTen.DanhSach(nae, ID, yoB, gr1, gr2);
        return ans;
    }
 
    // Type 1
 
    static void ShowList(ArrayList <DanhSachTen.DanhSach> a){
//        System.out.printf("| %-3d | %-20s | %-3s | %3d | %3.2f | %3.2f\n", 
//                i + 1, a.name, a.ID, a.yoB, a.gr1, a.gr2);
        System.out.printf("| %-3s | %-30s | %-10s | %-15s | %8s | %8s\n", 
                "STT", "Name", "ID", "Year of Birth", "Grade1", "Grade2");
        System.out.println("----------------------------------------------------------------------------------------------");
        for(int i = 0 ; i < a.size() ; ++i){
            DanhSachTen.DanhSach t = a.get(i);
            System.out.printf("| %-3d | %-30s | %-10s | %-15d | %8.2f | %8.2f\n", 
                i + 1, t.name, t.ID, t.yoB, t.gr1, t.gr2);
            System.out.println("----------------------------------------------------------------------------------------------");
        }
    }
    
    // Type 2
    
    static void FindStu(ArrayList <DanhSachTen.DanhSach> a, ArrayList <Double> b, Scanner sc, int cmd){
        String FID;
        do{
            System.out.print("Type the ID of the student: ");
            FID = sc.next();
            if(checkID(FID) == false){
                System.out.println("Invalid ID. Please try again!");
            }
        }while(checkID(FID) == false);
        
        FID = FID.trim();
        System.out.println("");
        
        for(int i = 0 ; i < a.size() ; ++i){
            DanhSachTen.DanhSach t = a.get(i);
            if(t.ID.equals(FID)){
                if(cmd == 2){
                    System.out.printf("| %-3s | %-30s | %-10s | %-15s | %8s | %8s\n", 
                    "STT", "Name", "ID", "Year of Birth", "Grade1", "Grade2");
                    System.out.println("----------------------------------------------------------------------------------------------");
                    System.out.printf("| %-3d | %-30s | %-10s | %-15d | %8.2f | %8.2f\n", 
                                        i + 1, t.name, t.ID, t.yoB, t.gr1, t.gr2);
                    System.out.println("----------------------------------------------------------------------------------------------");
                    return;
                }else if(cmd == 3){
                    System.out.printf("| %-3s | %-30s | %-10s | %-15s | %8s \n", 
                    "STT", "Name", "ID", "Year of Birth", "Average");
                    System.out.println("-----------------------------------------------------------------------------------------");
                    System.out.printf("| %-3d | %-30s | %-10s | %-15d | %8.2f \n", 
                                        i + 1, t.name, t.ID, t.yoB, b.get(i));
                    System.out.println("-----------------------------------------------------------------------------------------");
                    return;
                }
            
            }
        }
        System.out.println("--> There are no valid matches for this ID !");
    }
 
    static void meunu(){
        System.out.println("=== Menu ===");
        System.out.println("1. Show all the students");
        System.out.println("2. Search for student");
        System.out.println("3. Grade Average");
        System.out.println("4. Exit");
        System.out.println("");
    }
}