package lesson07_interface;

/**
 * =====================================================================
 * LESSON 07 - Rectangle implements Shape, Drawable
 * =====================================================================
 * CHỨC NĂNG:
 *   Hình chữ nhật. Override luôn default method describe() để thấy
 *   class implement có thể thay hành vi mặc định.
 *
 * KÍCH THƯỚC:
 *   ~12 header + 8 (width) + 8 (height) → ~32 byte.
 *
 * THUỘC TÍNH:
 *   - private final double width, height : > 0
 * =====================================================================
 */
public class Rectangle implements Shape, Drawable {

    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        if (width <= 0 || height <= 0) {
            throw new IllegalArgumentException("Canh phai > 0");
        }
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }

    @Override
    public double getPerimeter() {
        return 2 * (width + height);
    }

    @Override
    public void draw() {
        System.out.println("  [#####] Rectangle " + width + "x" + height);
    }

    // Override default method của Shape
    @Override
    public String describe() {
        return "Rectangle " + width + "x" + height + " -> area=" + getArea() + " " + UNIT;
    }
}
