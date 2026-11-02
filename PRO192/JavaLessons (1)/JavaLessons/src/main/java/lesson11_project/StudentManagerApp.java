package lesson11_project;

import java.io.File;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Scanner;
import lesson11_project.exception.DuplicateIdException;
import lesson11_project.exception.StudentNotFoundException;
import lesson11_project.model.Student;
import lesson11_project.service.HashMapStudentRepository;
import lesson11_project.service.StudentRepository;

/**
 * =====================================================================
 * LESSON 11 - ỨNG DỤNG QUẢN LÝ SINH VIÊN (MENU CONSOLE)
 * =====================================================================
 * CHỨC NĂNG:
 *   Menu thêm / tìm / xóa / liệt kê / sắp xếp / lưu file / đọc file / hoàn tác.
 *
 * KIẾN THỨC SỬ DỤNG:
 *   - lesson02 : switch, vòng lặp menu
 *   - lesson03 : String.split, trim, format
 *   - lesson04 : class, constructor, đóng gói (model.Student)
 *   - lesson05 : private / protected / public trên từng thành viên
 *   - lesson06 : kế thừa Person → Student, abstract getRole()
 *   - lesson07 : interface StudentRepository
 *   - lesson08 : custom exception DuplicateIdException, StudentNotFoundException
 *   - lesson09 : saveToFile / loadFromFile
 *   - lesson10 : LinkedHashMap lưu dữ liệu, ArrayList sắp xếp, Deque làm stack hoàn tác
 *
 * THUỘC TÍNH:
 *   - private final StudentRepository repo : khai báo theo INTERFACE
 *   - private final Deque<Student> undoStack: lưu sinh viên vừa xóa để hoàn tác
 * =====================================================================
 */
public class StudentManagerApp {

    private static final String DATA_FILE = "students.csv";

    private final StudentRepository repo;
    private final Deque<Student> undoStack = new ArrayDeque<>();
    private final Scanner sc;

    public StudentManagerApp(StudentRepository repo, Scanner sc) {
        this.repo = repo;
        this.sc = sc;
    }

    // Chạy tự động không cần nhập, dùng cho chế độ "chạy tất cả bài"
    public static void runDemo() {
        System.out.println("===== LESSON 11: MINI PROJECT (demo tu dong) =====");
        StudentRepository repo = new HashMapStudentRepository();
        try {
            repo.add(new Student("DE210098", "Le Khai", 8.5));
            repo.add(new Student("DE210099", "Nguyen An", 7.2));
            repo.add(new Student("DE210100", "Tran Binh", 9.1));
            repo.add(new Student("DE210098", "Trung Ma", 5.0));
        } catch (DuplicateIdException e) {
            System.out.println("  " + e.getMessage());
        }
        System.out.println("  Sap xep theo GPA giam dan:");
        for (Student s : repo.sortedByGpaDesc()) {
            System.out.println("    " + s);
        }
        try {
            repo.findById("DE999999");
        } catch (StudentNotFoundException e) {
            System.out.println("  " + e.getMessage());
        }
        String tmp = "demo_students.csv";
        try {
            repo.saveToFile(tmp);
            StudentRepository copy = new HashMapStudentRepository();
            System.out.println("  Ghi file roi doc lai: " + copy.loadFromFile(tmp) + " sinh vien");
        } catch (IOException e) {
            System.out.println("  Loi file: " + e.getMessage());
        } finally {
            new File(tmp).delete();
        }
    }

    public void runInteractive() {
        System.out.println("===== LESSON 11: QUAN LY SINH VIEN =====");
        while (true) {
            printMenu();
            String choice = sc.nextLine().trim();
            try {
                switch (choice) {
                    case "1" -> addStudent();
                    case "2" -> findStudent();
                    case "3" -> removeStudent();
                    case "4" -> printList(repo.findAll(), "Danh sach");
                    case "5" -> printList(repo.sortedByGpaDesc(), "Theo GPA giam dan");
                    case "6" -> {
                        repo.saveToFile(DATA_FILE);
                        System.out.println("  Da luu " + repo.size() + " sinh vien vao " + DATA_FILE);
                    }
                    case "7" -> System.out.println("  Da nap " + repo.loadFromFile(DATA_FILE) + " sinh vien");
                    case "8" -> undoRemove();
                    case "0" -> {
                        System.out.println("  Thoat quan ly sinh vien.");
                        return;
                    }
                    default -> System.out.println("  Lua chon khong hop le.");
                }
            } catch (DuplicateIdException | StudentNotFoundException e) {
                System.out.println("  [!] " + e.getMessage());
            } catch (NumberFormatException e) {
                System.out.println("  [!] GPA phai la so.");
            } catch (IllegalArgumentException e) {
                System.out.println("  [!] " + e.getMessage());
            } catch (IOException e) {
                System.out.println("  [!] Loi file: " + e.getMessage());
            }
        }
    }

    private void printMenu() {
        System.out.println();
        System.out.println("  1. Them   2. Tim   3. Xoa   4. Liet ke   5. Sap xep GPA");
        System.out.println("  6. Luu file   7. Doc file   8. Hoan tac xoa   0. Quay lai");
        System.out.print("  Chon: ");
    }

    private void addStudent() throws DuplicateIdException {
        String id = prompt("Ma SV");
        String name = prompt("Ho ten");
        double gpa = Double.parseDouble(prompt("GPA"));
        repo.add(new Student(id, name, gpa));
        System.out.println("  Da them.");
    }

    private void findStudent() throws StudentNotFoundException {
        System.out.println("  " + repo.findById(prompt("Ma SV can tim")));
    }

    private void removeStudent() throws StudentNotFoundException {
        String id = prompt("Ma SV can xoa");
        Student s = repo.findById(id);
        repo.remove(id);
        undoStack.push(s);
        System.out.println("  Da xoa " + s.getName() + " (chon 8 de hoan tac)");
    }

    private void undoRemove() throws DuplicateIdException {
        Student s = undoStack.poll();
        if (s == null) {
            System.out.println("  Khong co gi de hoan tac.");
            return;
        }
        repo.add(s);
        System.out.println("  Da khoi phuc " + s.getName());
    }

    private void printList(List<Student> list, String title) {
        System.out.println("  --- " + title + " (" + list.size() + ") ---");
        if (list.isEmpty()) {
            System.out.println("  (trong)");
        }
        for (Student s : list) {
            System.out.println("  " + s);
        }
    }

    private String prompt(String label) {
        System.out.print("  " + label + ": ");
        String value = sc.nextLine().trim();
        if (value.isEmpty()) {
            throw new IllegalArgumentException(label + " khong duoc rong");
        }
        return value;
    }
}
