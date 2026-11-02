package lesson10_collections;

/**
 * =====================================================================
 * LESSON 10 - COLLECTIONS FRAMEWORK (TỔNG HỢP)
 * =====================================================================
 * SƠ ĐỒ:
 *   Iterable
 *   └── Collection
 *       ├── List   (có thứ tự, cho trùng)     → ArrayList, LinkedList
 *       ├── Set    (không trùng)              → HashSet, LinkedHashSet, TreeSet
 *       └── Queue  (hàng đợi)                 → PriorityQueue, LinkedList
 *           └── Deque (2 đầu)                 → ArrayDeque, LinkedList
 *   Map (riêng, cặp key-value)                → HashMap, LinkedHashMap, TreeMap
 *
 * CHỌN NHANH:
 *   - Cần truy cập theo index             → ArrayList
 *   - Cần lọc trùng / kiểm tra tồn tại    → HashSet
 *   - Cần tra cứu theo mã / đếm           → HashMap
 *   - Cần tự sắp xếp                      → TreeSet / TreeMap
 *   - Xử lý theo thứ tự đến (FIFO)        → ArrayDeque dùng như Queue
 *   - Đảo ngược / undo / ngoặc (LIFO)     → ArrayDeque dùng như Stack
 *
 * LƯU Ý CHUNG:
 *   - Collections chỉ chứa OBJECT, kiểu nguyên thủy tự boxing (int → Integer).
 *   - Khai báo theo interface: List<String> x = new ArrayList<>();
 *   - Generic <T> kiểm tra kiểu lúc biên dịch, tránh ép kiểu thủ công.
 * =====================================================================
 */
public class CollectionsDemo {

    public static void run() {
        System.out.println("===== LESSON 10: COLLECTIONS =====");
        ListDemo.run();
        SetHashDemo.run();
        MapDemo.run();
        QueueStackDequeDemo.run();
    }
}
