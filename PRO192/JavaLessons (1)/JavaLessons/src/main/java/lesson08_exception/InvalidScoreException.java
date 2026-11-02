package lesson08_exception;

/**
 * =====================================================================
 * LESSON 08 - NGOẠI LỆ TỰ ĐỊNH NGHĨA (CUSTOM CHECKED EXCEPTION)
 * =====================================================================
 * CHỨC NĂNG:
 *   Báo điểm nằm ngoài [0, 10]. Kế thừa Exception → là CHECKED:
 *   method ném nó phải khai báo "throws", nơi gọi phải try-catch.
 *
 * THUỘC TÍNH:
 *   - private final double invalidScore : giá trị sai, để nơi bắt lỗi xem lại
 * =====================================================================
 */
public class InvalidScoreException extends Exception {

    // Exception có thể tuần tự hóa (Serializable) → nên khai báo mã phiên bản
    private static final long serialVersionUID = 1L;

    private final double invalidScore;

    public InvalidScoreException(String message, double invalidScore) {
        super(message);            // message lấy ra bằng getMessage()
        this.invalidScore = invalidScore;
    }

    public double getInvalidScore() {
        return invalidScore;
    }
}
