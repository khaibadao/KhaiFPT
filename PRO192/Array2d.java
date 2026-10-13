import java.util.Scanner;

public class Array2d{
	public static void main(String[] args){
		int n, m;
		Scanner sc = new Scanner(System.in);
		n = sc.nextInt();
		m = sc.nextInt();
		int[][] a = new int[n][m];
		for(int i = 0 ; i < n ; ++i){
			for(int j = 0 ; j < m ; ++j){
				a[i][j] = sc.nextInt();
			}
		}

		for(int i = 0 ; i < n ; ++i){
			System.out.print("Tổng hàng " + (i + 1) + " là: ");
			int sum = 0;
			for(int j = 0 ; j < m ; ++j){
				sum += a[i][j];
			}
			System.out.println(sum);
		}

		int lef = 0, rig = 0, to = 0, bot = 0; 

		for(int i = 0 ; i < n ; ++i){
			for(int j = 0 ; j < m ; ++j){
				if(i == 0) to += a[i][j];
				if(j == 0) lef += a[i][j];
				if(i == n - 1) bot += a[i][j];
				if(j == m - 1) rig += a[i][j];
			}
		}

		System.out.println("\nGiá trị biên trên là: " + to);
		System.out.println("Giá trị biên dưới là: " + bot);
		System.out.println("Giá trị biên phải là: " + rig);
		System.out.println("Giá trị biên trái là: " + lef);

		for(int i = 0 ; i < n ; ++i){
			for(int j = 0 ; j < m ; ++j){
				if(i == 0) a[i][j] = 1;
				if(j == 0) a[i][j] = 1;
				if(i == n - 1) a[i][j] = 1;
				if(j == m - 1) a[i][j] = 1;
			}
		}

		System.out.print('\n');

		for(int i = 0 ; i < n ; ++i){
			for(int j = 0 ; j < m ; ++j){
				System.out.print(a[i][j] + " ");
			}
			System.out.print('\n');
		}

		int[][] b = new int[m][n];

		for(int i = 0 ; i < n ; ++i){
			for(int j = 0 ; j < m ; ++j){
				b[j][i] = a[i][j];
			}
		}

		System.out.print('\n');

		for(int i = 0 ; i < m ; ++i){
			for(int j = 0 ; j < n ; ++j){
				System.out.print(b[i][j] + " ");
			}
			System.out.print('\n');
		}
	}
}