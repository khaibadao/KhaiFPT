package lesson10_collections;

import java.util.Objects;

/**
 * =====================================================================
 * LESSON 10 - Book: object dùng làm phần tử của HashSet / key của HashMap
 * =====================================================================
 * CHỨC NĂNG:
 *   Minh họa vì sao PHẢI override equals() và hashCode() cùng nhau,
 *   và implements Comparable để sắp xếp / dùng trong TreeSet.
 *
 * KÍCH THƯỚC:
 *   ~12 header + 4 (isbn) + 4 (title) + 8 (price) → ~32 byte.
 *
 * THUỘC TÍNH:
 *   - private final String isbn  : khóa định danh, dùng cho equals/hashCode
 *   - private final String title
 *   - private final double price
 *
 * HỢP ĐỒNG equals / hashCode:
 *   - a.equals(b) == true  → a.hashCode() == b.hashCode()  (BẮT BUỘC)
 *   - hashCode bằng nhau   → chưa chắc equals (gọi là va chạm/collision)
 *   - Field dùng trong hashCode không nên thay đổi sau khi đã bỏ vào HashSet.
 * =====================================================================
 */
public class Book implements Comparable<Book> {

    private final String isbn;
    private final String title;
    private final double price;

    public Book(String isbn, String title, double price) {
        this.isbn = isbn;
        this.title = title;
        this.price = price;
    }

    public String getIsbn() { return isbn; }
    public String getTitle() { return title; }
    public double getPrice() { return price; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Book)) return false;
        return isbn.equals(((Book) o).isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }

    // Thứ tự tự nhiên: theo title (A → Z)
    @Override
    public int compareTo(Book other) {
        return this.title.compareTo(other.title);
    }

    @Override
    public String toString() {
        return title + "(" + isbn + ", " + price + ")";
    }
}
