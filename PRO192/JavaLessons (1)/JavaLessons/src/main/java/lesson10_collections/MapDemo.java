package lesson10_collections;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * =====================================================================
 * LESSON 10.3 - MAP: HashMap, LinkedHashMap, TreeMap
 * =====================================================================
 * CHỨC NĂNG:
 *   Lưu cặp KHÓA → GIÁ TRỊ (key → value). Key không trùng, value được trùng.
 *   Dùng để tra cứu theo mã, đếm tần suất, gom nhóm.
 *
 * KÍCH THƯỚC:
 *   - Bucket mặc định 16, load factor 0.75 → rehash khi > 12 cặp.
 *   - Mỗi cặp là 1 Node ≈ 32 byte + object key + object value.
 *   - Từ Java 8: 1 bucket có > 8 phần tử va chạm sẽ chuyển từ danh sách
 *     liên kết sang cây đỏ-đen để giữ tốc độ O(log n).
 *
 * THUỘC TÍNH:
 *   - Map KHÔNG kế thừa Collection.
 *   - put(key trùng) → GHI ĐÈ value cũ và trả về value cũ.
 *   - get(key không có) → null; dùng getOrDefault để tránh NullPointerException.
 *   - HashMap cho phép 1 key null; TreeMap thì không.
 *   - Thứ tự: HashMap không đảm bảo, LinkedHashMap theo thứ tự thêm,
 *     TreeMap sắp xếp theo key.
 * =====================================================================
 */
public class MapDemo {

    public static void run() {
        System.out.println("-- 10.3 MAP --");

        Map<String, Double> gpa = new HashMap<>();
        gpa.put("DE210098", 8.5);
        gpa.put("DE210099", 7.0);
        gpa.put("DE210100", 9.1);
        Double old = gpa.put("DE210098", 8.8);           // ghi đè, trả value cũ
        System.out.println("  put trung key -> value cu = " + old + ", moi = " + gpa.get("DE210098"));
        System.out.println("  get(khong co)          = " + gpa.get("XXX"));
        System.out.println("  getOrDefault(khong co) = " + gpa.getOrDefault("XXX", 0.0));
        System.out.println("  containsKey / containsValue: " + gpa.containsKey("DE210099")
                + " / " + gpa.containsValue(9.1));

        // 3 cách duyệt
        System.out.println("  Duyet entrySet (nen dung):");
        for (Map.Entry<String, Double> e : new TreeMap<>(gpa).entrySet()) {
            System.out.println("    " + e.getKey() + " -> " + e.getValue());
        }
        System.out.println("  keySet = " + new TreeMap<>(gpa).keySet() + ", values (TreeMap) = "
                + new TreeMap<>(gpa).values());

        // Mẫu kinh điển: đếm tần suất từ
        String sentence = "java hay java kho nhung java vui hay";
        Map<String, Integer> freq = new LinkedHashMap<>();
        for (String w : sentence.split("\\s+")) {
            freq.put(w, freq.getOrDefault(w, 0) + 1);
            // Cách viết khác: freq.merge(w, 1, Integer::sum);
        }
        System.out.println("  Dem tu (LinkedHashMap) = " + freq);

        String top = null;
        int max = 0;
        for (Map.Entry<String, Integer> e : freq.entrySet()) {
            if (e.getValue() > max) {
                max = e.getValue();
                top = e.getKey();
            }
        }
        System.out.println("  Tu xuat hien nhieu nhat: " + top + " (" + max + " lan)");

        // TreeMap: sắp theo key + các method điều hướng
        TreeMap<Integer, String> grade = new TreeMap<>();
        grade.put(0, "F");
        grade.put(5, "D");
        grade.put(7, "B");
        grade.put(9, "A");
        System.out.println("  TreeMap xep loai: 8 diem -> " + grade.floorEntry(8).getValue()
                + ", 6 diem -> " + grade.floorEntry(6).getValue());

        // computeIfAbsent: gom nhóm
        Map<Character, StringBuilder> group = new TreeMap<>();
        for (String name : new String[]{"An", "Anh", "Binh", "Bao", "Chi"}) {
            group.computeIfAbsent(name.charAt(0), k -> new StringBuilder()).append(name).append(' ');
        }
        System.out.println("  Gom theo chu cai dau: " + group);
    }
}
