import java.util.Scanner;
import lesson01_datatypes.DataTypes;
import lesson02_controlflow.ControlFlow;
import lesson03_methods_strings.MethodsAndStrings;
import lesson04_class_object.ClassObjectDemo;
import lesson05_access_modifiers.AccessModifierDemo;
import lesson06_inheritance.InheritanceDemo;
import lesson07_interface.InterfaceDemo;
import lesson08_exception.ExceptionDemo;
import lesson09_fileio.FileIODemo;
import lesson10_collections.CollectionsDemo;
import lesson11_project.StudentManagerApp;
import lesson11_project.service.HashMapStudentRepository;

/**
 * =====================================================================
 * MAIN - MENU CHỌN BÀI HỌC
 * =====================================================================
 * Chạy: java -cp out Main          → menu
 *       java -cp out Main all      → chạy lần lượt mọi bài (không cần nhập)
 *       java -cp out Main 7        → chạy riêng lesson 07
 * =====================================================================
 */
public class Main {

    public static void main(String[] args) {
        if (args.length > 0) {
            if (args[0].equalsIgnoreCase("all")) {
                for (int i = 1; i <= 11; i++) {
                    runLesson(i, null);
                    System.out.println();
                }
            } else {
                try {
                    runLesson(Integer.parseInt(args[0]), null);
                } catch (NumberFormatException e) {
                    System.out.println("Tham so phai la so bai (1-11) hoac 'all'");
                }
            }
            return;
        }

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println();
            System.out.println("========== JAVA LESSONS - PRO192 ==========");
            System.out.println(" 1. Kieu du lieu           7. Interface");
            System.out.println(" 2. Dieu khien & mang      8. Exception");
            System.out.println(" 3. Method & String        9. File I/O");
            System.out.println(" 4. Class & Object        10. Collections");
            System.out.println(" 5. Access modifiers      11. Mini project (menu)");
            System.out.println(" 6. Ke thua & da hinh      0. Thoat");
            System.out.print("Chon bai: ");
            if (!sc.hasNextLine()) break;
            String line = sc.nextLine().trim();
            int choice;
            try {
                choice = Integer.parseInt(line);
            } catch (NumberFormatException e) {
                System.out.println("Hay nhap so.");
                continue;
            }
            if (choice == 0) break;
            runLesson(choice, sc);
        }
        sc.close();
    }

    // sc == null → chế độ tự động, lesson 11 chạy bản demo
    private static void runLesson(int n, Scanner sc) {
        switch (n) {
            case 1 -> DataTypes.run();
            case 2 -> ControlFlow.run();
            case 3 -> MethodsAndStrings.run();
            case 4 -> ClassObjectDemo.run();
            case 5 -> AccessModifierDemo.run();
            case 6 -> InheritanceDemo.run();
            case 7 -> InterfaceDemo.run();
            case 8 -> ExceptionDemo.run();
            case 9 -> FileIODemo.run();
            case 10 -> CollectionsDemo.run();
            case 11 -> {
                if (sc == null) {
                    StudentManagerApp.runDemo();
                } else {
                    new StudentManagerApp(new HashMapStudentRepository(), sc).runInteractive();
                }
            }
            default -> System.out.println("Khong co bai " + n);
        }
    }
}
