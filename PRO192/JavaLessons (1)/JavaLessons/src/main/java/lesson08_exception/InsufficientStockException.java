package lesson08_exception;

/**
 * =====================================================================
 * LESSON 08 - NGOẠI LỆ TỰ ĐỊNH NGHĨA (CUSTOM UNCHECKED EXCEPTION)
 * =====================================================================
 * CHỨC NĂNG:
 *   Báo kho không đủ hàng. Kế thừa RuntimeException → là UNCHECKED:
 *   không bắt buộc khai báo throws hay try-catch.
 *
 * KHI NÀO DÙNG LOẠI NÀO:
 *   - Checked   : lỗi bên ngoài có thể lường trước và nên xử lý (file, mạng, dữ liệu nhập)
 *   - Unchecked : lỗi lập trình / vi phạm điều kiện (null, index sai, tham số sai)
 * =====================================================================
 */
public class InsufficientStockException extends RuntimeException {

    // Exception có thể tuần tự hóa (Serializable) → nên khai báo mã phiên bản
    private static final long serialVersionUID = 1L;

    public InsufficientStockException(String message) {
        super(message);
    }
}
