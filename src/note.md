- String Immutable - không thay đổi được giá trị (literal)
- Có 2 cách khai báo String:
  - 1. literal -> primitive -> Immutable
    ``` java
    String str = "Hello";
    ```
  - 2. constructor của class String -> object -> references -> mutable
    ``` java
    String str = new String("Hello");
    ```
- So sánh chuỗi:
  - So sánh tuyệt đối : `==`
  - So sánh tương đối `equals()`
  - So sánh hai chuỗi mà không phân biệt chữ hoa, chữ thường : `equalsIgnoreCase`

- Regex:

| Ký hiệu | Ý nghĩa | Ví dụ |
|---------|--------|------|
| `.` | Bất kỳ ký tự nào ngoại trừ ký tự xuống dòng | `a.b` khớp với `acb`, `a1b` |
| `*` | Lặp lại 0 hoặc nhiều lần ký tự trước đó | `a*` khớp với `aaa`, `a`, `""` |
| `+` | Lặp lại 1 hoặc nhiều lần ký tự trước đó | `a+` khớp với `aaa`, `a` |
| `?` | Ký tự trước đó xuất hiện 0 hoặc 1 lần | `a?` khớp với `a` hoặc `""` |
| `[]` | Một tập hợp ký tự | `[abc]` khớp với `a`, `b`, `c` |
| `^` | Bắt đầu chuỗi hoặc phủ định trong tập hợp | `^a` khớp với chuỗi bắt đầu bằng `a` |
| `$` | Kết thúc chuỗi | `a$` khớp với chuỗi kết thúc bằng `a` |
| `\d` | Một chữ số | `\d+` khớp với `123`, `456` |
| `\w` | Một ký tự chữ hoặc số | `\w+` khớp với `abc123` |


