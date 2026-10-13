import java.util.Scanner;
import java.util.ArrayList;

/*
		
		Structer: 
		Main
		  - Meunu
		  - Funcion

		Inside meunu:
			1. Add student
			2. Display all students
			3. Search student by name
			4. Update student's score
			5. Delete student
			6. Statistics
			0. Exit

		Require: 
			Add student:
				+ ID (Start DE + 6 number)
				+ Name (Check empty, remove the backspace, Cap the first letter)
				+ Score (0 <= score <= 10)
			
			Search: 
				+ Search all the name have the same same with the name we are finding 
				+ If cannot found, print "Cannot found"

			Update: 
				+ Search the id first (valid) ? change : print not found

			Delete: 
				+ Search the id (valid) ? remove : print cannot found

			Statistics:  
		*/

public class Main {

	/* ======= Funcion for check ========== */

	// Check ID
	public static boolean CheckID(String s){
		if(s.length() != 8) return false;
		for(int i = 2 ; i < s.length(); ++i){
			char kt = s.charAt(i);
			if('0' <= kt && kt <= '9') continue;
			else return false;
		}
		if(s.charAt(0) == 'D' && s.charAt(1) == 'E') return true;
		else return false;
	}

	//Check Name
	public static boolean CheckName(String s){
		if(s.trim().isEmpty() == true) return false;
		for (int i = 0; i < s.length(); ++i) {
            char c = s.charAt(i);
            if (('a' <= c && c <= 'z') || ('A' <= c && c <= 'Z') || c == ' ') continue;
            else return false;
        }
        return true;
	}

	// Check Score
	public static boolean CheckScore(float s){
		return (0 <= s && s <= 10);
	}


	// For Add
	static ArrayList <String> Id = new ArrayList <>();
	static ArrayList <String> Name = new ArrayList <>();
	static ArrayList <Float> Score = new ArrayList <>();

	static Scanner sc = new Scanner(System.in);

	// Fill Information
	public static void AddStudentInformation(){
		String Idd, Namee;
		float Scoree;

		// Type the ID
		do
		{
			System.out.print("Enter your ID: ");
			Idd = sc.next();
			if(CheckID(Idd) == false){
				System.out.println("Invalid ID. Please try again!");
			}
			
		}while(CheckID(Idd) == false);

		// Type the full name
		do
		{
			System.out.print("Enter your full name: ");
			Namee = sc.nextLine();
			if(CheckName(Namee) == false){
				System.out.println("Invalid Name. Please try again!");
			}
			
		}while(CheckName(Namee) == false);

		// Type the scroce
		do
		{
			System.out.print("Enter your score: ");
			Scoree = sc.nextFloat();
			if(CheckScore(Scoree) == false){
				System.out.println("Invalid score. Please try again!");
			}
		}while(CheckScore(Scoree) == false);
	}

	public static void Meunu(){
		System.out.println("===== STUDENT MANAGEMENT =====");
		System.out.println("1. Add student");
		System.out.println("2. Display all students");
		System.out.println("3. Search student by name");
		System.out.println("4. Update student's score");
		System.out.println("5. Delete student");
		System.out.println("6. Statistics");
		System.out.println("0. Exit");
		System.out.print("Your choice: ");
	}

	// For Display
	public static void DisplayStudents(){
		System.out.format("%-5s%-12s%-22s%s%n", "No", "ID", "Name", "Score");
		// for(int i = 0 ; i < number ; ++i){

		// }
	}

	



	public static void main(String[] arg){
		
		String a = "Le Khai Dep traii";
		if(CheckName(a) == true) System.out.print("Hop le");
		else System.out.print("Deo");
		// DisplayStudents();

	}
}