
package workshop1;

import java.util.Scanner;
import java.util.ArrayList;


public class Part3 {

    public static boolean CheckName(String s){
        if(s.trim().isEmpty()) return false;
        for(int i = 0 ; i < s.length() ; ++i){
            char c = s.charAt(i);
            if(('A' <= c && c <= 'Z') || ('a' <= c && c <= 'z') || c == ' ') continue;
            else return false;
        }
        return true;
    }
    
    public static boolean CheckSl(int a){
        return a <= 0;
    }
    
    public static void main(String[] args) {
        
        int sl;
        
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter the number of the studens: ");
        
        sl = sc.nextInt();
        sc.nextLine();
        
        ArrayList <String> LsName = new ArrayList <>(sl);
        
        
        int t = 1;
        while(sl > 0){
            String name;
            do{
                System.out.print("Enter the name of student " + t + ": ");
                name = sc.nextLine();
                if(CheckName(name) == false){
                    System.out.println("Invailed Name. Please try again!");
                }
            }while(CheckName(name) == false);
            
            ++t;
            LsName.add(name.toUpperCase());
            
            sl--;
        }
        
        System.out.println("\nThe list of name: ");
        for(int i = 0 ; i < LsName.size(); ++i){
            System.out.println(LsName.get(i));
        }
        
    }
    
}
