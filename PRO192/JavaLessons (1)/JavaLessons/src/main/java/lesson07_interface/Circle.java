package lesson07_interface;

/**
 * =====================================================================
 * LESSON 07 - Circle implements Shape, Drawable
 * =====================================================================
 * CHỨC NĂNG:
 *   Hình tròn: cài đặt cả 2 interface.
 *
 * KÍCH THƯỚC:
 *   ~12 header + 8 (double radius) → ~24 byte.
 *
 * THUỘC TÍNH:
 *   - private final double radius : bán kính, > 0
 * =====================================================================
 */
public class Circle implements Shape, Drawable {

    private final double radius;

    public Circle(double radius) {
        if (radius <= 0) {
            throw new IllegalArgumentException("Ban kinh phai > 0");
        }
        this.radius = radius;
    }

    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public double getPerimeter() {
        return 2 * Math.PI * radius;
    }

    @Override
    public void draw() {
        System.out.println("  (  O  ) Circle r=" + radius);
    }
}
