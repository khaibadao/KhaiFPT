package lesson07_interface;

/**
 * =====================================================================
 * LESSON 07 - GIAO DIỆN (INTERFACE)
 * =====================================================================
 * CHỨC NĂNG:
 *   "Hợp đồng" cho mọi hình học: class nào implements Shape thì BẮT BUỘC
 *   có getArea() và getPerimeter().
 *
 * KÍCH THƯỚC:
 *   Interface không có instance field nên không chiếm bộ nhớ trong object.
 *   Hằng số trong interface là static → chỉ có 1 bản.
 *
 * THUỘC TÍNH (quy tắc ngầm định của interface):
 *   - Field       : luôn là public static final (hằng số), dù không ghi
 *   - Method thường: luôn là public abstract, dù không ghi
 *   - default     : method có thân, class implement có thể dùng luôn hoặc override (Java 8+)
 *   - static      : method gọi qua tên interface: Shape.compare(a, b) (Java 8+)
 *   - private     : method phụ trợ dùng nội bộ cho default/static (Java 9+)
 *   - KHÔNG có constructor, KHÔNG new được
 * =====================================================================
 */
public interface Shape {

    // Ngầm hiểu: public static final
    String UNIT = "cm";

    // Ngầm hiểu: public abstract
    double getArea();

    double getPerimeter();

    // default method: có sẵn thân hàm
    default String describe() {
        return String.format("%s: area=%s, perimeter=%s",
                getClass().getSimpleName(), fmt(getArea()), fmt(getPerimeter()));
    }

    // static method: tiện ích, gọi bằng Shape.compareByArea(...)
    static int compareByArea(Shape a, Shape b) {
        return Double.compare(a.getArea(), b.getArea());
    }

    // private method: chỉ dùng bên trong interface
    private String fmt(double value) {
        return String.format("%.2f %s", value, UNIT);
    }
}
