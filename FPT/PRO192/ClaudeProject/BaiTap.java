import java.util.ArrayList;
import java.util.Scanner; 

public class BaiTap
{

	// public static double Ma(double a, double b, double c, double d){
	// 	return (a > b ? a : (b > c ? b : (c > d) ? c : d));
	// }

	// public static void main(String[] args){
	// 	int pt;
	// 	Scanner sc = new Scanner(System.in);
	// 	pt = nextInt();
		

	// }

	public static double Ma(double a, double b, double c, double d){
		return (a > b ? a : (b > c ? b : (c > d) ? c : d));
	}

	public static void main(String[] args){
		double a, b, c, d;
		Scanner sc = new Scanner(System.in);
		a = sc.nextDouble();
		b = sc.nextDouble();
		c = sc.nextDouble();
		d = sc.nextDouble();
		double ans = Ma(a, b, c, d);
		System.out.print(ans);
	}

	// public static double Loopp(int n){
	// 	double sum = 1.00;
	// 	for(int i = 2 ; i <= n ; ++i){
	// 		sum += ((double)1/i);
	// 	}
	// 	return sum;
	// }

	// public static void main(String[] args){
	// 	int a;
	// 	Scanner sc = new Scanner(System.in);
	// 	a = sc.nextInt();
	// 	double ans = Loopp(a);
	// 	System.out.print(ans);
	// }
}