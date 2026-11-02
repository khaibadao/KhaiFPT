package lesson11_project.exception;

/**
 * =====================================================================
 * LESSON 11 - Custom checked exception: trùng mã sinh viên
 * =====================================================================
 */
public class DuplicateIdException extends Exception {

    // Exception có thể tuần tự hóa (Serializable) → nên khai báo mã phiên bản
    private static final long serialVersionUID = 1L;

    public DuplicateIdException(String id) {
        super("Ma sinh vien da ton tai: " + id);
    }
}
