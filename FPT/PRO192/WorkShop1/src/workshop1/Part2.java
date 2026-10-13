
package workshop1;

import java.util.Scanner;
import java.util.ArrayList;


public class Part2 {

    
    public static boolean operator(char c){
        return (c != '+' && c != '-'&& c != '*' && c != '/');
    }
    
    
    public static void main(String[] args) {
        float a, b;
        
        String ope;
        
        Scanner sc = new Scanner (System.in);
        System.out.print("Enter the first number: ");
        a = sc.nextFloat();
        
        System.out.print("Enter the second number: ");
        b = sc.nextFloat();
        
        sc.nextLine();
        
        do
        {
            System.out.print("Enter the operator: ");
            ope = sc.nextLine();
            if(operator(ope.charAt(0)) == true){
                System.out.println("Invailed Operator! Please try again.");
                
            }
        }while(operator(ope.charAt(0)) == true);
        
        if(ope.charAt(0) == '/'){
            if(b == 0){
                System.out.println("Math Error!");
            }else System.out.println("The result of " + a + " " + ope + " " + b + " = " + (a/b));
        }
        
        else if(ope.charAt(0) == '+'){
            System.out.println("The result of " + a + " " + ope + " " + b + " = " + (a+b));
        }
        else if(ope.charAt(0) == '-'){
            System.out.println("The result of " + a + " " + ope + " " + b + " = " + (a-b));
        }
        else if(ope.charAt(0) == '*'){
            System.out.println("The result of " + a + " " + ope + " " + b + " = " + (a*b));
        }
        
        
        
        
    }
    
}
