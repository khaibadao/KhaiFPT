import java.util.Scanner;

public class Part1{
	public static void main(String[] arg){
		int row, columns; 
		long sum = 0;
		Scanner a = new Scanner(System.in);
		System.out.print("Enter number of rows: ");
		row = a.nextInt();
		System.out.print("Enter number of columns: ");
		columns = a.nextInt();
		int [][] ma = new int[row][columns];
		for(int i = 0 ; i < row ; ++i){
			for(int j = 0 ; j < columns ; ++j){
				System.out.print("ma[" + i + ']' + '[' + j + ']' + " = ");
				ma[i][j] = a.nextInt();
			}
		}

		System.out.println("Matrix inputted: ");
		for(int i = 0 ; i < row ; ++i){
			for(int j = 0 ; j < columns ; ++j){
				sum += ma[i][j];
				System.out.format("%4d", ma[i][j]);
			}
			System.out.println();
		}


		System.out.println("--> Sum: " + sum);
		System.out.printf("--> Average: %.1f\n", (float)sum/(row * columns));

	}
}
