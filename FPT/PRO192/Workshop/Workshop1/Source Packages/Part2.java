import java.util.Scanner;

public class Part2{
	public static void main(String[] arg){
		
		int a, b;
		Scanner sc = new Scanner(System.in);

		System.out.print("Input the number1: ");
		a = sc.nextInt();
		System.out.print("Input the number2: ");
		b = sc.nextInt();

		char ope;
		do 
		{
			System.out.print("Input the operator (+ | - | * | /): ");
			ope = sc.next().charAt(0);
			if(ope != '+' && ope != '-' && ope != '*' && ope != '/'){
				System.out.println("Please try again!");
			}
		}while(ope != '+' && ope != '-' && ope != '*' && ope != '/');

		if(ope == '/' && b == 0){
			System.out.print("---> Math error!");
			return;
		}
		switch (ope){
			case '+': 
				System.out.print("---> Result: " + a + " " + ope + " " + b + " = " + (a + b));
				break; 
			case '-':
				System.out.print("---> Result: " + a + " " + ope + " " + b + " = " + (a - b));
				break;
			case '*':
				System.out.print("---> Result: " + a + " " + ope + " " + b + " = " + (a * b));
				break;
			case '/':
				System.out.printf("---> Result: %d %c %d = %.1f", a, ope, b, (float)a/b);
				break;
		}
		
	}
}
