# Java Lessons – PRO192

Tổng hợp kiến thức Java từ cơ bản đến Collections. Mỗi bài học là một package. Đầu mỗi file có khối chú thích gồm **CHỨC NĂNG**, **KÍCH THƯỚC** và **THUỘC TÍNH**.

## Cấu trúc

```
pom.xml                               Cấu hình Maven: NetBeans nhận diện project nhờ file này
src/main/java/
├── Main.java                         Menu chọn bài
├── lesson01_datatypes/               8 kiểu nguyên thủy, kích thước, casting, wrapper, overflow
├── lesson02_controlflow/             if/switch/vòng lặp, mảng 1 và 2 chiều
├── lesson03_methods_strings/         overloading, varargs, pass-by-value, String, StringBuilder
├── lesson04_class_object/            class, constructor, this, static, final, getter/setter, equals/hashCode
├── lesson05_access_modifiers/        public / protected / default / private
│   └── other/                        package khác: class con và class lạ
├── lesson06_inheritance/             extends, super, abstract, override, đa hình, instanceof
├── lesson07_interface/               interface, default/static/private method, nhiều interface, lambda
├── lesson08_exception/               try/catch/finally, throw/throws, checked/unchecked, custom exception
├── lesson09_fileio/                  đọc/ghi text, ghi nối, file nhị phân, try-with-resources
├── lesson10_collections/             List, Set, Hash, Map, Queue, Stack, Deque, PriorityQueue
└── lesson11_project/                 Mini project quản lý sinh viên (dùng tất cả bài trên)
    ├── model/                        Person (abstract), Student
    ├── exception/                    DuplicateIdException, StudentNotFoundException
    └── service/                      StudentRepository (interface), HashMapStudentRepository
```

## Chạy

Cần JDK 17 trở lên (có dùng `switch ->` và `instanceof` pattern).

| Hệ điều hành | Lệnh |
|---|---|
| Windows | `run.bat` / `run.bat all` / `run.bat 10` |
| Linux / WSL / macOS | `./run.sh` / `./run.sh all` / `./run.sh 10` |

**NetBeans:** giải nén → File → Open Project → chọn thư mục `JavaLessons` (biểu tượng có chữ "m") → Open Project → bấm Run (F6). Lần đầu NetBeans cần mạng để tải plugin Maven. Bài 11 có menu nhập liệu, gõ ở cửa sổ Output.

**IntelliJ:** File → Open → chọn `pom.xml` → Open as Project.

## Cách học gợi ý

1. Đọc khối chú thích ở đầu file trước, rồi mới đọc code.
2. Chạy riêng từng bài (`run.bat 5`) và đối chiếu output với code.
3. Mở các dòng có chú thích `// LỖI` (trong lesson04, 05, 06) để tự thấy trình biên dịch báo lỗi gì.
4. Lesson 11 có menu tương tác, chọn 11 trong menu chính để thử thêm/xóa/lưu file.
