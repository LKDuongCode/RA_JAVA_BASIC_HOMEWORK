package java_oop_practice;

import java.util.Scanner;

public class Book {
    private String bookId;
    private String bookName;
    private double importPrice;
    private double exportPrice;
    private String title;
    private String author;
    private double interest;
    private int year;

    public Book() {
        this.bookId = "B_default";
        this.bookName = "default";
        this.importPrice = 1;
        this.exportPrice = 1.1;
        this.title = "default";
        this.author = "default";
        this.interest = 0;
        this.year = 1970;
    }

    public Book(String bookId, String bookName, double importPrice, double exportPrice, String title, String author, int year) {
        setBookId(bookId);
        setBookName(bookName);
        setImportPrice(importPrice);
        setExportPrice(exportPrice);
        setTitle(title);
        setAuthor(author);
        setYear(year);
        calInterest();
    }


    public String getBookId() {
        return bookId;
    }

    public void setBookId(String bookId) {
        if (bookId == null || bookId.trim().isEmpty() || bookId.length() != 5 || !bookId.startsWith("B")) {
            throw new IllegalArgumentException("Mã sách là chuỗi gồm 5 kí tự bắt đầu từ B");
        }
        this.bookId = bookId;
    }


    public String getBookName() {
        return bookName;
    }

    public void setBookName(String bookName) {
        if (bookName.length() < 6 || bookName.length() > 100) {
            throw new IllegalArgumentException("Tên sách phải từ 6-100 ký tự.");
        }
        this.bookName = bookName;
    }

    public double getImportPrice() {
        return importPrice;
    }

    public void setImportPrice(double importPrice) {
        if (importPrice <= 0) {
            throw new IllegalArgumentException("Giá nhập phải lớn hơn 0.");
        }
        this.importPrice = importPrice;
        calInterest();
    }

    public double getExportPrice() {
        return exportPrice;
    }

    public void setExportPrice(double exportPrice) {
        if (exportPrice < importPrice * 1.1) {
            throw new IllegalArgumentException("Giá bán phải cao hơn giá nhập ít nhất 10%.");
        }
        this.exportPrice = exportPrice;
        calInterest();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title == null || title.trim().isEmpty()) {
            throw new IllegalArgumentException("Tiêu đề sách không được để trống.");
        }
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author == null || author.trim().isEmpty()) {
            throw new IllegalArgumentException("Tác giả không được để trống.");
        }
        this.author = author;
    }

    public double getInterest() {
        return interest;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        if (year < 1970) {
            throw new IllegalArgumentException("Năm xuất bản phải từ năm 1970 trở đi.");
        }
        this.year = year;
    }


    public void calInterest() {
        this.interest = exportPrice - importPrice;
    }

    public void inputData(Scanner scanner) {
        System.out.print("Nhập mã sách: ");
        setBookId(scanner.nextLine());

        System.out.print("Nhập tên sách (6-100 ký tự): ");
        setBookName(scanner.nextLine());

        System.out.print("Nhập giá nhập: ");
        setImportPrice(Double.parseDouble(scanner.nextLine()));

        System.out.print("Nhập giá bán (phải cao hơn 10% so với giá nhập): ");
        setExportPrice(Double.parseDouble(scanner.nextLine()));

        System.out.print("Nhập tiêu đề sách: ");
        setTitle(scanner.nextLine());

        System.out.print("Nhập tác giả sách: ");
        setAuthor(scanner.nextLine());

        System.out.print("Nhập năm xuất bản (>= 1970): ");
        setYear(Integer.parseInt(scanner.nextLine()));

        calInterest();
    }


    public void displayData() {
        System.out.println("Thông tin sách:");
        System.out.println("Mã sách: " + bookId);
        System.out.println("Tên sách: " + bookName);
        System.out.println("Giá nhập: " + importPrice);
        System.out.println("Giá bán: " + exportPrice);
        System.out.println("Tiêu đề: " + title);
        System.out.println("Tác giả: " + author);
        System.out.println("Năm xuất bản: " + year);
        System.out.println("Lợi nhuận: " + interest);
    }
}
