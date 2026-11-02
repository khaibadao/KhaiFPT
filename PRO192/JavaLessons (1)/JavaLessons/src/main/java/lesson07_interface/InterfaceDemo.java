package lesson07_interface;

import java.util.Arrays;

/**
 * =====================================================================
 * LESSON 07 - DEMO INTERFACE
 * =====================================================================
 * CHỨC NĂNG:
 *   - Biến kiểu interface trỏ tới object (đa hình qua interface)
 *   - Gọi default / static method
 *   - Ép sang interface khác bằng instanceof
 *   - Lambda: interface chỉ có 1 method trừu tượng (functional interface)
 *     có thể viết gọn bằng lambda
 * =====================================================================
 */
public class InterfaceDemo {

    public static void run() {
        System.out.println("===== LESSON 07: INTERFACE =====");

        Shape[] shapes = {new Circle(3), new Rectangle(4, 5), new Circle(1)};

        for (Shape s : shapes) {
            System.out.println("  " + s.describe());
            if (s instanceof Drawable d) {        // cùng object, nhìn qua interface khác
                d.draw();
            }
        }

        Arrays.sort(shapes, Shape::compareByArea);   // dùng static method của interface
        System.out.print("  Sap xep theo dien tich: ");
        for (Shape s : shapes) {
            System.out.printf("%.2f ", s.getArea());
        }
        System.out.println();

        // Drawable chỉ có 1 method → viết bằng lambda thay vì tạo class
        Drawable star = () -> System.out.println("  *** lambda Drawable ***");
        star.draw();

        System.out.println("  Hang so trong interface: Shape.UNIT = " + Shape.UNIT);
    }
}
