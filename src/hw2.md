1. Định nghĩa tính trừu tượng: Trừu tượng trong OOP là tiến trình ẩn đi các chi tiết triển khai mà chỉ hiển thị tính năng tới người dùng. Cho phép loại bỏ tính tính phức tạp của đối tượng bằng cách chỉ đưa ra các thuộc tính và các phương thức cần thiết của đối tượng. Giúp tập trung vào các cốt lõi cần thiết của dối tượng trong lập trình
---
2. Tại sao cần tính trừu tượng trong phần mềm phức tạp?
- Trong phần mềm lớn, có nhiều thành phần phức tạp mà lập trình viên không cần quan tâm đến cách hoạt động chi tiết, chỉ cần sử dụng đúng chức năng. Giúp giảm sự phụ thuộc giữa các thành phần, giúp hệ thống dễ bảo trì và mở rộng hơn. Đồng thời giúp định nghĩa giao diện chuẩn, để các lớp khác có thể triển khai mà không ảnh hưởng đến mã nguồn chính.
---
3. Sự khác biệt giữa lớp trừu tượng và giao diện trong Java là gì?

| Tiêu chí   | abstract class| interface|
|------------|-------------------------------|-----------|
| **Mục đích** | Dùng khi có quan hệ kế thừa giữa các lớp | Dùng khi nhiều lớp có thể chia sẻ hành vi chung |
| **Phương thức** | Có cả phương thức `abstract` và phương thức có thân (`default` hoặc `concrete`) | Chỉ có phương thức `abstract` (từ Java 8 trở lên có `default` method) |
| **Biến** | Có thể có biến `protected`, `private` | Mặc định tất cả biến là `public static final` |
| **Kế thừa** | Một lớp chỉ có thể kế thừa một `abstract class` | Một lớp có thể `implement` nhiều `interface` |

---
4. Liên hệ thực tế: Khi sử dụng điều khiển tv, chúng ta chỉ quan tâm đến các nút như bật tắt, chuyển kênh,... Không cần biết bên trong đó hoạt động như thế nào hay theo nguyên lý gì. TV cũng vậy, người dùng quan tâm đến chất lượng hình ảnh, kiểu cách, chức năng chứ không cần biết chúng được cấu thành ra sao.