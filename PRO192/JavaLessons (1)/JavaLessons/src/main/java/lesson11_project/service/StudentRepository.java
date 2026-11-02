package lesson11_project.service;

import java.io.IOException;
import java.util.List;
import lesson11_project.exception.DuplicateIdException;
import lesson11_project.exception.StudentNotFoundException;
import lesson11_project.model.Student;

/**
 * =====================================================================
 * LESSON 11 - INTERFACE StudentRepository
 * =====================================================================
 * CHỨC NĂNG:
 *   Hợp đồng cho mọi cách lưu sinh viên. Phần giao diện chương trình chỉ
 *   biết interface này, nên đổi cách lưu (bộ nhớ, file, database) mà
 *   không phải sửa code menu.
 *
 * THUỘC TÍNH:
 *   - Các method khai báo throws checked exception → nơi gọi bắt buộc xử lý.
 * =====================================================================
 */
public interface StudentRepository {

    void add(Student s) throws DuplicateIdException;

    Student findById(String id) throws StudentNotFoundException;

    void remove(String id) throws StudentNotFoundException;

    List<Student> findAll();

    List<Student> sortedByGpaDesc();

    int size();

    void saveToFile(String path) throws IOException;

    int loadFromFile(String path) throws IOException;
}
