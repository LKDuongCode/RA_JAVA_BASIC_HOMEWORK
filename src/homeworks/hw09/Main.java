package homeworks.hw09;


public class Main {
    public static void main(String[] args) {
        BookManager manager = new BookManager();
        manager.addBook(new Book(1, "Lập trình Java", "Nguyễn Văn A", "NXB Trẻ", 120000));
        manager.addBook(new Book(2, "Clean Code", "Robert C. Martin", "NXB Mỹ", 250000));
        manager.addBook(new Book(3, "Dế mèn phiêu lưu ký", "Tô Hoài", "NXB Kim Đồng", 90000));

        manager.displayAllBooks();
        manager.deleteBook("Clean Code");

        System.out.println("Sau khi xóa:");
        manager.displayAllBooks();
    }
}
