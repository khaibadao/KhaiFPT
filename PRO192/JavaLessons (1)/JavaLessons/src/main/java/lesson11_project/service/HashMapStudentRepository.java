package lesson11_project.service;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import lesson11_project.exception.DuplicateIdException;
import lesson11_project.exception.StudentNotFoundException;
import lesson11_project.model.Student;

/**
 * =====================================================================
 * LESSON 11 - HashMapStudentRepository implements StudentRepository
 * =====================================================================
 * CHỨC NĂNG:
 *   Lưu sinh viên trong LinkedHashMap<id, Student> (tra cứu O(1), giữ thứ
 *   tự thêm), xuất/nhập file CSV.
 *
 * KÍCH THƯỚC:
 *   Mỗi sinh viên ≈ 32 byte (Student) + 2 String + ~40 byte (Node của map).
 *   1000 sinh viên → khoảng 150-200 KB.
 *
 * THUỘC TÍNH:
 *   - private final Map<String, Student> data : giấu kín, bên ngoài chỉ
 *     nhận BẢN SAO danh sách qua findAll() để không sửa trực tiếp được.
 * =====================================================================
 */
public class HashMapStudentRepository implements StudentRepository {

    private final Map<String, Student> data = new LinkedHashMap<>();

    @Override
    public void add(Student s) throws DuplicateIdException {
        if (data.containsKey(s.getId())) {
            throw new DuplicateIdException(s.getId());
        }
        data.put(s.getId(), s);
    }

    @Override
    public Student findById(String id) throws StudentNotFoundException {
        Student s = data.get(id);
        if (s == null) {
            throw new StudentNotFoundException(id);
        }
        return s;
    }

    @Override
    public void remove(String id) throws StudentNotFoundException {
        if (data.remove(id) == null) {
            throw new StudentNotFoundException(id);
        }
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(data.values());     // trả bản sao
    }

    @Override
    public List<Student> sortedByGpaDesc() {
        List<Student> list = findAll();
        list.sort(Comparator.comparingDouble(Student::getGpa).reversed()
                .thenComparing(Student::getId));
        return list;
    }

    @Override
    public int size() {
        return data.size();
    }

    @Override
    public void saveToFile(String path) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(path))) {
            for (Student s : data.values()) {
                pw.println(s.toCsv());
            }
        }
    }

    // Trả về số dòng nạp được; dòng lỗi bị bỏ qua nhưng không làm hỏng cả file
    @Override
    public int loadFromFile(String path) throws IOException {
        int loaded = 0;
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.isBlank()) continue;
                try {
                    add(Student.fromCsv(line));
                    loaded++;
                } catch (IllegalArgumentException | DuplicateIdException e) {
                    System.out.println("  Bo qua: " + e.getMessage());
                }
            }
        }
        return loaded;
    }
}
