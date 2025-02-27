### ĐỀ BÀI
1. JDK, JRE và JVM có vai trò gì trong hệ sinh thái Java? Hãy phân biệt sự khác nhau giữa ba khái niệm này và nêu mối quan hệ giữa chúng
2. Hãy giải thích khái niệm "Write once, run anywhere" trong Java. Cơ chế nào giúp Java có thể chạy trên nhiều nền tảng khác nhau mà không cần biên dịch lại?
3. Quy trình để cài đặt và chạy chương trình Java đầu tiên bằng IntelliJ IDEA như thế nào? Hãy mô tả các bước cần thực hiện để tạo và chạy một dự án Java cơ bản.
4. Java có những phiên bản nào? Hãy phân biệt Java SE, Java EE và Java ME về mục đích sử dụng và đối tượng hướng đến
---
### TRẢ LỜI

1. | Thành phần | Chức năng | Thành phần chính |
   |------------|----------|----------------|
   | JVM (Java Virtual Machine)| Máy ảo Java giúp chạy mã bytecode trên mọi nền tảng | Bộ nạp lớp (Class Loader), Bộ thực thi (Execution Engine), Bộ thu gom rác (Garbage Collector) |
   |JRE (Java Runtime Environment)| Môi trường chạy chương trình Java, chứa JVM và thư viện cần thiết | JVM, Thư viện Java (Java Class Libraries) |
   | JDK (Java Development Kit) | Bộ công cụ phát triển Java, chứa JRE và các công cụ lập trình | JRE, Trình biên dịch `javac`, Debugger, Công cụ phát triển |

- Mối quan hệ giữa JDK, JRE và JVM
  - **JVM** là nền tảng giúp chạy Java.
  - **JRE** cung cấp môi trường chạy ứng dụng Java, trong đó có JVM.
  - **JDK** chứa cả **JRE** và các công cụ lập trình cần thiết để viết, biên dịch và debug chương trình Java.
---
2. Giải thích khái niệm
- "Write once, run anywhere" (Viết một lần, chạy mọi nơi) nghĩa là một chương trình Java chỉ cần viết và biên dịch một lần, nhưng có thể chạy trên mọi hệ điều hành mà không cần biên dịch lại.

- Cơ chế giúp Java đa nền tảng
  - Khi lập trình viên viết mã Java (`.java`), trình biên dịch `javac` chuyển nó thành bytecode (`.class`).
  - Bytecode này không phụ thuộc vào hệ điều hành mà được JVM trên từng nền tảng dịch ra mã máy phù hợp.
  - Nhờ đó, chỉ cần viết một lần, nhưng có thể chạy trên bất kỳ nền tảng nào có JV.

---
3. Các bước cần thực hiện để tạo và chạy một dự án Java cơ bản (ý này bao đã bao gồm cả ý trước đó)

- Bước 1: Cài đặt và mở IntelliJ IDEA

- Bước 2: Tạo dự án mới 
  - Chọn "New Project" 
  - Trong phần Project SDK, chọn JDK đã cài đặt 
  - Chọn "Java" rồi nhấn Next. 
  - Đặt tên cho dự án 
  - Nhấn Finish để hoàn tất.


- Bước 3: Tạo class `Main.java`
  - Vào thư mục `src`, nhấn chuột phải → New → Java Class. 
  - Đặt tên là `Main`. 
  - Viết đoạn mã sau:
   ```java
   public class Main {
       public static void main(String[] args) {
           System.out.println("Hello, Java!");
       }
   }
  
- Bước 4: Bấm nút `▶` ở góc trên bên phải để chạy.
---
4.  Các phiên bản của Java và phân biệt Java SE, Java EE, Java ME

| **Phiên bản**  | **Mục đích sử dụng** | **Đối tượng hướng đến** |
|---------------|----------------------|-------------------------|
| **Java SE** (Standard Edition) | - Cung cấp nền tảng lập trình Java tiêu chuẩn. <br> - Phù hợp với ứng dụng **desktop, console, server-side đơn giản**. | - Lập trình viên Java làm việc với **ứng dụng Desktop, Backend API, Console App**. |
| **Java EE** (Enterprise Edition - Jakarta EE) | - Dành cho **ứng dụng doanh nghiệp** với kiến trúc phân tán. <br> - Hỗ trợ lập trình **web, microservices, cloud-native application**. | - Lập trình viên làm việc với **web application, microservices, cloud-based services**. |
| **Java ME** (Micro Edition) | - Dành cho **thiết bị nhúng, IoT, thiết bị di động cũ**. <br> - Dùng trong **hệ thống nhúng, smart card, thiết bị y tế**. | - Lập trình viên phát triển ứng dụng cho **mobile đời cũ, thiết bị IoT, hệ thống nhúng**. |








