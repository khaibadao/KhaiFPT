package lesson11_project.exception;

/**
 * =====================================================================
 * LESSON 11 - Custom checked exception: không tìm thấy sinh viên
 * =====================================================================
 */
public class StudentNotFoundException extends Exception {

    // Exception có thể tuần tự hóa (Serializable) → nên khai báo mã phiên bản
    private static final long serialVersionUID = 1L;

    public StudentNotFoundException(String id) {
        super("Khong tim thay sinh vien: " + id);
    }
}
