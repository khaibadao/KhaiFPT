package lesson11_project.model;

import java.util.Objects;

/**
 * =====================================================================
 * LESSON 11 - Student extends Person implements Comparable<Student>
 * =====================================================================
 * CHỨC NĂNG:
 *   Sinh viên có GPA; chuyển qua lại với 1 dòng CSV để lưu file.
 *
 * KÍCH THƯỚC:
 *   Person (~24) + double gpa (8) → ~32 byte.
 *
 * THUỘC TÍNH:
 *   - private double gpa                  : [0, 10]
 *   - public static final String SEPARATOR: ký tự ngăn cách trong file
 *   - equals/hashCode theo id             : để dùng làm phần tử HashSet / so trùng
 *   - compareTo theo id                   : thứ tự tự nhiên
 * =====================================================================
 */
public class Student extends Person implements Comparable<Student> {

    public static final String SEPARATOR = ",";

    private double gpa;

    public Student(String id, String name, double gpa) {
        super(id, name);
        setGpa(gpa);
    }

    public double getGpa() {
        return gpa;
    }

    public final void setGpa(double gpa) {
        if (gpa < 0 || gpa > 10) {
            throw new IllegalArgumentException("GPA phai trong [0, 10]: " + gpa);
        }
        this.gpa = gpa;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getRole() {
        return "Student";
    }

    public String toCsv() {
        return id + SEPARATOR + name + SEPARATOR + gpa;
    }

    // static factory: tạo Student từ 1 dòng file, sai định dạng → IllegalArgumentException
    public static Student fromCsv(String line) {
        String[] p = line.split(SEPARATOR);
        if (p.length != 3) {
            throw new IllegalArgumentException("Dong sai dinh dang: " + line);
        }
        return new Student(p[0].trim(), p[1].trim(), Double.parseDouble(p[2].trim()));
    }

    @Override
    public int compareTo(Student o) {
        return id.compareTo(o.id);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        return id.equals(((Student) o).id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return String.format("%-10s %-20s %5.2f", id, name, gpa);
    }
}
