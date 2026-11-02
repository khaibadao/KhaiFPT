package lesson10_collections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * =====================================================================
 * LESSON 10.1 - LIST: ArrayList & LinkedList
 * =====================================================================
 * CHỨC NĂNG:
 *   Danh sách CÓ THỨ TỰ, CHO PHÉP TRÙNG, truy cập theo chỉ số.
 *
 * KÍCH THƯỚC:
 *   ArrayList:
 *     - Bên trong là mảng Object[]; capacity mặc định 10 khi thêm phần tử đầu.
 *     - Đầy thì tạo mảng mới lớn gấp ~1.5 lần rồi copy sang.
 *     - size() = số phần tử thật, capacity = sức chứa mảng bên trong.
 *     - Mỗi ô giữ 1 tham chiếu (~4 byte) → Integer phải boxing, tốn hơn int[].
 *   LinkedList:
 *     - Mỗi phần tử là 1 Node (prev, item, next) ≈ 24 byte/node + object.
 *
 * ĐỘ PHỨC TẠP:
 *   +--------------------+------------+------------+
 *   | Thao tác           | ArrayList  | LinkedList |
 *   +--------------------+------------+------------+
 *   | get(i)             | O(1)       | O(n)       |
 *   | add(cuối)          | O(1)*      | O(1)       |
 *   | add/remove(đầu)    | O(n)       | O(1)       |
 *   | contains           | O(n)       | O(n)       |
 *   +--------------------+------------+------------+   (* trung bình)
 *
 * THUỘC TÍNH:
 *   - Chỉ chứa object → int phải dùng Integer (tự boxing).
 *   - Xóa phần tử khi đang duyệt for-each → ConcurrentModificationException;
 *     dùng Iterator.remove() hoặc removeIf().
 *   - remove(int index) khác remove(Object o): với List<Integer> rất dễ nhầm.
 * =====================================================================
 */
public class ListDemo {

    public static void run() {
        System.out.println("-- 10.1 LIST --");

        List<String> names = new ArrayList<>();       // khai báo theo interface List
        names.add("Chi");
        names.add("An");
        names.add("Binh");
        names.add("An");                              // trùng: được phép
        names.add(1, "Dung");                         // chèn vào vị trí 1
        System.out.println("  names        = " + names + ", size=" + names.size());
        System.out.println("  get(2)       = " + names.get(2));
        System.out.println("  indexOf(An)  = " + names.indexOf("An")
                + ", lastIndexOf(An) = " + names.lastIndexOf("An"));
        names.set(0, "Chau");
        System.out.println("  set(0,Chau)  = " + names);

        Collections.sort(names);                      // sắp xếp tăng dần (theo Comparable)
        System.out.println("  sort         = " + names);
        names.sort(Comparator.reverseOrder());
        System.out.println("  sort giam    = " + names);

        // Bẫy remove với List<Integer>
        List<Integer> nums = new ArrayList<>(List.of(10, 20, 30, 40));
        nums.remove(1);                               // xóa VỊ TRÍ 1 → bỏ 20
        nums.remove(Integer.valueOf(40));             // xóa GIÁ TRỊ 40
        System.out.println("  remove(1) & remove(Integer 40) -> " + nums);

        // Xóa an toàn khi duyệt
        List<Integer> data = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        Iterator<Integer> it = data.iterator();
        while (it.hasNext()) {
            if (it.next() % 2 == 0) it.remove();
        }
        System.out.println("  Iterator xoa so chan -> " + data);
        data.removeIf(x -> x > 3);
        System.out.println("  removeIf(x>3)        -> " + data);

        // LinkedList: thêm/xóa đầu cuối nhanh
        LinkedList<String> linked = new LinkedList<>(List.of("B", "C"));
        linked.addFirst("A");
        linked.addLast("D");
        System.out.println("  LinkedList = " + linked + ", first=" + linked.getFirst()
                + ", last=" + linked.getLast());

        // List.of: danh sách BẤT BIẾN
        List<String> fixed = List.of("x", "y");
        try {
            fixed.add("z");
        } catch (UnsupportedOperationException e) {
            System.out.println("  List.of() la bat bien -> UnsupportedOperationException");
        }
    }
}
