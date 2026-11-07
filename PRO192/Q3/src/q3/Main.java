package q3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
 
public class Main {
 
    public static void dispList(List<Radio> t) {
        for (Radio x : t) {
            System.out.printf("(%s,%d) ", x.getContent(), x.getRate());
        }
        System.out.printf("\r\n");
    }
 
    public static void addToList(List<Radio> t, String[] a, int[] b) {
        int n = a.length;
        for (int i = 0; i < n; i++) {
            t.add(new Radio(a[i], b[i]));
        }
    }
 
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        List<Radio> h = new ArrayList<>();
        List<Radio> t = new ArrayList<>();
 
        String[] a1 = {"VN1", "VJ", "FR", "PJ1"};
        int[] b1 = {8, 2, 19, 17};
 
        String[] a2 = {"A12", "B1X", "C34", "D2Y", "E67", "1F", "3G1", "2H"};
        int[] b2 = {6, 9, 2, 29, 22, 19, 12, 5};
 
        String[] a3 = {"A2", "B2", "C3", "D6", "E6", "1F", "3G1", "2H"};
        int[] b3 = {10, 56, 10, 47, 56, 15, 18, 25};
 
        System.out.print("Add how many elements: ");
        int count = sc.nextInt();
        sc.nextLine();
 
        String xContent = "";
        int xRate = 0;
 
        for (int i = 0; i < count; i++) {
            System.out.print("Enter content: ");
            xContent = sc.nextLine();
            System.out.print("Enter rate: ");
            xRate = sc.nextInt();
            sc.nextLine();
            t.add(new Radio(xContent, xRate));
            h.add(new Radio(xContent, xRate));
        }
 
        System.out.print("Enter TC(1-f1;2-f2;3-f3): ");
        int tc = sc.nextInt();
        sc.nextLine();
 
        IRadio u = new MyRadio();
 
        switch (tc) {
            case 1:
                addToList(h, a1, b1);
                System.out.println("The list before running f1:");
                dispList(h);
                break;
            case 2:
                addToList(h, a2, b2);
                System.out.println("The list before running f2:");
                dispList(h);
                break;
            case 3:
                addToList(h, a3, b3);
                System.out.println("The list before running f3:");
                dispList(h);
                break;
        }
 
        System.out.printf("OUTPUT:\r\n");
 
        switch (tc) {
            case 1:
                int result = u.f1(h);
                System.out.printf("%d\r\n", result);
                break;
            case 2:
                u.f2(h);
                dispList(h);
                break;
            case 3:
                u.f3(h);
                dispList(h);
                break;
        }
 
        System.out.println();
    }
}