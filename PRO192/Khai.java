public class Khai {
    public static void main(String[] args) {
        
        int sum1 = 0;
        for(int i = 10 ; i <= 20 ; ++i){
            sum1 += i;
        }
        System.out.println("Sum (10 -> 20): " + sum1);
        
        int muti = 1;
        for(int i = 3 ; i <= 7 ; ++i){
            muti *= i;
        }
        System.out.println("\nMuti (3 -> 7): " + muti);

        int sl_boi = 0;
        for(int i = 33 ; i <= 99 ; ++i){
            if(i%7 == 0) System.out.println(i);
        }
        System.out.println("\nSo luong boi so cua 7 (33 -> 97): " + sl_boi);

        int n = 10;
        for(int i = 0 ; i < n ; ++i){
            System.out.println("\nHello world!");
        }
    }
    
}


