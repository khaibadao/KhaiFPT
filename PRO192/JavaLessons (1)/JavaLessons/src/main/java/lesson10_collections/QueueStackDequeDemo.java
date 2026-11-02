package lesson10_collections;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * =====================================================================
 * LESSON 10.4 - QUEUE, STACK, DEQUE, PRIORITYQUEUE
 * =====================================================================
 * CHỨC NĂNG:
 *   - Queue : hàng đợi FIFO (vào trước ra trước) - xếp hàng, BFS
 *   - Stack : ngăn xếp LIFO (vào sau ra trước) - undo, kiểm tra ngoặc, đệ quy
 *   - Deque : hàng đợi 2 đầu, dùng được như cả Queue lẫn Stack
 *   - PriorityQueue: lấy ra phần tử NHỎ NHẤT trước (theo thứ tự ưu tiên)
 *
 * KÍCH THƯỚC:
 *   - ArrayDeque: mảng vòng (circular array), capacity mặc định 16,
 *     đầy thì nhân đôi. Không có Node riêng → nhẹ và nhanh hơn LinkedList.
 *   - Stack: kế thừa Vector, capacity mặc định 10, mọi method đều
 *     synchronized → chậm hơn. Java khuyên dùng ArrayDeque thay thế.
 *   - PriorityQueue: heap trên mảng, capacity mặc định 11.
 *
 * HAI BỘ METHOD CỦA QUEUE:
 *   +-----------+----------------------+----------------------+
 *   | Thao tác  | Ném exception khi lỗi | Trả về đặc biệt      |
 *   +-----------+----------------------+----------------------+
 *   | Thêm      | add(e)               | offer(e) → false     |
 *   | Lấy + xóa | remove()             | poll()   → null      |
 *   | Xem đầu   | element()            | peek()   → null      |
 *   +-----------+----------------------+----------------------+
 *
 * THUỘC TÍNH:
 *   - ArrayDeque KHÔNG cho phép null; LinkedList thì cho.
 *   - Dùng Deque làm stack: push / pop / peek thao tác ở ĐẦU.
 * =====================================================================
 */
public class QueueStackDequeDemo {

    public static void run() {
        System.out.println("-- 10.4 QUEUE / STACK / DEQUE --");
        queueDemo();
        stackDemo();
        dequeDemo();
        priorityDemo();
        System.out.println("  Kiem tra ngoac:");
        for (String s : new String[]{"{[()]}", "([)]", "(())[]", "(("}) {
            System.out.println("    " + s + " -> " + (isBalanced(s) ? "hop le" : "sai"));
        }
    }

    private static void queueDemo() {
        Queue<String> line = new LinkedList<>();
        line.offer("Khach 1");
        line.offer("Khach 2");
        line.offer("Khach 3");
        System.out.println("  Queue = " + line + ", peek = " + line.peek());
        System.out.println("  poll  = " + line.poll() + " -> con " + line);
        line.clear();
        System.out.println("  poll khi rong = " + line.poll() + " (khong nem loi)");
    }

    private static void stackDemo() {
        Stack<Integer> st = new Stack<>();          // class cũ, chỉ để biết
        st.push(1);
        st.push(2);
        st.push(3);
        System.out.println("  Stack = " + st + ", peek = " + st.peek() + ", pop = " + st.pop()
                + " -> " + st);
    }

    private static void dequeDemo() {
        Deque<Integer> asStack = new ArrayDeque<>();
        asStack.push(1);
        asStack.push(2);
        asStack.push(3);
        System.out.println("  Deque lam Stack = " + asStack + ", pop = " + asStack.pop());

        Deque<Integer> dq = new ArrayDeque<>();
        dq.offerLast(2);
        dq.offerLast(3);
        dq.offerFirst(1);
        dq.offerFirst(0);
        System.out.println("  Deque 2 dau = " + dq + ", pollFirst=" + dq.pollFirst()
                + ", pollLast=" + dq.pollLast() + " -> " + dq);

        // Đảo chuỗi bằng stack
        Deque<Character> chars = new ArrayDeque<>();
        for (char c : "KHAI".toCharArray()) chars.push(c);
        StringBuilder sb = new StringBuilder();
        while (!chars.isEmpty()) sb.append(chars.pop());
        System.out.println("  Dao \"KHAI\" bang stack = " + sb);
    }

    private static void priorityDemo() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();      // min-heap
        for (int x : new int[]{5, 1, 8, 3}) pq.offer(x);
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) sb.append(pq.poll()).append(' ');
        System.out.println("  PriorityQueue poll lan luot: " + sb + "(nho nhat truoc)");
    }

    // Bài tập kinh điển: kiểm tra ngoặc cân bằng
    public static boolean isBalanced(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else if (c == ')' || c == ']' || c == '}') {
                if (stack.isEmpty()) return false;
                char open = stack.pop();
                if ((c == ')' && open != '(') || (c == ']' && open != '[') || (c == '}' && open != '{')) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
