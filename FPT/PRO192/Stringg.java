import java.util.ArrayList;
import java.util.Scanner; 

public class Stringg
{
	public static void main(String[] args){
		ArrayList <Integer> khai = new ArrayList <>();
		Scanner sc = new Scanner(System.in);
		int gt;
		do{
			gt = sc.nextInt();
			khai.add(gt);
		}while(gt != 0);


		for(int i = 0 ; i < khai.size() ; ++i){
			System.out.println(khai.get(i));
		}

		sc.close();
	}
}