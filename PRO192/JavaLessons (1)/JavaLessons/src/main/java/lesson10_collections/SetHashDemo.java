package lesson10_collections;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

/**
 * =====================================================================
 * LESSON 10.2 - HASH & SET: HashSet, LinkedHashSet, TreeSet
 * =====================================================================
 * CHỨC NĂNG:
 *   Tập hợp KHÔNG CHO TRÙNG. Dùng để lọc trùng, kiểm tra tồn tại nhanh,
 *   phép hợp / giao / hiệu.
 *
 * CƠ CHẾ BĂM (HASHING):
 *   1. Gọi hashCode() của phần tử → 1 số int
 *   2. Tính chỉ số bucket = hash & (số bucket - 1)
 *   3. Vào bucket đó, dùng equals() so với các phần tử đang có
 *   → Tìm/thêm/xóa trung bình O(1).
 *
 * KÍCH THƯỚC:
 *   - HashSet bên trong thực chất là 1 HashMap (phần tử làm key).
 *   - Số bucket mặc định 16, load factor 0.75: khi số phần tử > 16×0.75 = 12
 *     thì nhân đôi bucket lên 32 và băm lại (rehash).
 *   - Mỗi phần tử tốn 1 Node ≈ 32 byte (hash, key, value, next).
 *
 * SO SÁNH:
 *   +---------------+-----------------------+-------------+-----------+
 *   | Loại          | Thứ tự                | Tốc độ      | null      |
 *   +---------------+-----------------------+-------------+-----------+
 *   | HashSet       | Không đảm bảo         | O(1)        | 1 null    |
 *   | LinkedHashSet | Theo thứ tự thêm vào  | O(1)        | 1 null    |
 *   | TreeSet       | Tăng dần (sắp xếp)    | O(log n)    | Không     |
 *   +---------------+-----------------------+-------------+-----------+
 * =====================================================================
 */
public class SetHashDemo {

    // Class cố tình KHÔNG override equals/hashCode để thấy lỗi
    private static class BadBook {
        private final String isbn;

        BadBook(String isbn) {
            this.isbn = isbn;
        }

        @Override
        public String toString() {
            return isbn;
        }
    }

    public static void run() {
        System.out.println("-- 10.2 HASH & SET --");

        System.out.println("  hashCode(\"Java\") = " + "Java".hashCode()
                + ", hashCode(\"Java\") lan 2 = " + "Java".hashCode() + " (luon giong)");

        List<Integer> raw = List.of(5, 3, 9, 3, 1, 5, 7);
        Set<Integer> hash = new HashSet<>(raw);
        Set<Integer> linked = new LinkedHashSet<>(raw);
        Set<Integer> tree = new TreeSet<>(raw);
        System.out.println("  Goc          : " + raw);
        System.out.println("  HashSet      : " + hash);
        System.out.println("  LinkedHashSet: " + linked + " (giu thu tu them)");
        System.out.println("  TreeSet      : " + tree + " (tu sap xep)");

        boolean added = hash.add(9);
        System.out.println("  add(9) lan nua -> " + added + " (da ton tai)");

        // Phép toán tập hợp
        Set<Integer> a = new TreeSet<>(List.of(1, 2, 3, 4));
        Set<Integer> b = new TreeSet<>(List.of(3, 4, 5));
        Set<Integer> union = new TreeSet<>(a);
        union.addAll(b);
        Set<Integer> inter = new TreeSet<>(a);
        inter.retainAll(b);
        Set<Integer> diff = new TreeSet<>(a);
        diff.removeAll(b);
        System.out.println("  A=" + a + " B=" + b + " | hop=" + union + " giao=" + inter + " hieu=" + diff);

        // equals/hashCode đúng vs sai
        Set<Book> good = new HashSet<>();
        good.add(new Book("111", "Java", 100));
        good.add(new Book("111", "Java ban 2", 120));       // cùng isbn → bị coi là trùng
        Set<BadBook> bad = new HashSet<>();
        bad.add(new BadBook("111"));
        bad.add(new BadBook("111"));                        // không override → 2 object khác nhau
        System.out.println("  Book co equals/hashCode   : size=" + good.size());
        System.out.println("  BadBook khong override    : size=" + bad.size() + " -> TRUNG ma khong phat hien");

        // TreeSet với object: dùng compareTo của Book
        Set<Book> sortedBooks = new TreeSet<>(List.of(
                new Book("3", "Python", 90), new Book("1", "C", 80), new Book("2", "Java", 100)));
        System.out.println("  TreeSet<Book> theo title: " + sortedBooks);
    }
}
