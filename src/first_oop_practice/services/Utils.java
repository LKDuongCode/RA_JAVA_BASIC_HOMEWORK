package first_oop_practice.services;

import first_oop_practice.entity.Book;
import first_oop_practice.entity.GlobalData;

import java.util.*;

public class Utils {
    public static void printMenu (){
        System.out.println("*********************MENU******************");
        System.out.println("1. Nhập thông tin n sách (n nhập từ bàn phím)");
        System.out.println("2. Tính lợi nhuận các sách");
        System.out.println("3. Hiển thị thông tin sách");
        System.out.println("4. Sắp xếp sách theo giá bán tăng dần");
        System.out.println("5. Sắp xếp sách theo lợi nhuận giảm dần");
        System.out.println("6. Tìm sách theo tên sách (tên sách nhập từ bàn phím)");
        System.out.println("7. Thống kê số lượng sách theo năm xuất bản");
        System.out.println("8. Thống kê số lượng sách theo tác giả");
        System.out.println("9. Thoát");
        System.out.println("Lựa chọn của bạn: ");
        System.out.println("*******************************************");
    }

    public static void addBook (Scanner sc){
        System.out.print("nhập id: ");
        String id = Validator.validateId(sc);

        System.out.print("nhập name: ");
        String name = Validator.validateName(sc);

        System.out.print("nhập giá nhập: ");
        float iPrice = Validator.validatePrice(sc);


        System.out.print("nhập giá xuất: ");
        float ePrice = Validator.validatePrice(sc,iPrice);


        System.out.println("nhập tác giả: ");
        String author = Validator.validateAuthor(sc);

        System.out.println("nhâp năm xuất bản:");
        int year = Validator.validateYear(sc);

        float interest = ePrice - iPrice;

        GlobalData.books.add(new Book(id,name,iPrice,ePrice,author,interest,year));
        System.out.println("thêm thành công");
    }

    public static void printAllBook (){
        System.out.println("danh sách sách hiện có:");
        for (Book book : GlobalData.books){
            System.out.println("id: " + book.getBookId() + " | " +
                    "name: " + book.getBookName() + " | " +
                    "giá nhập: " + book.getImportPrice() + " | " +
                    "giá xuất: " + book.getExportPrice() + " | " +
                    "tác giả: " + book.getAuthor() + " | " +
                    "lãi suất: " + book.getInterest() + " | " +
                    "năm: " + book.getYear());
        }
    }

    public static void sortBook (String mes){
        if(mes.equals("eprice_asc")){
            List<Book> sortedBooks = new ArrayList<>(GlobalData.books);
            sortedBooks.sort(Comparator.comparing(Book::getExportPrice));
            return;
        }

        if(mes.equals("interest_desc")){
            List<Book> sortedBooks = new ArrayList<>(GlobalData.books);
            sortedBooks.sort(Comparator.comparing(Book::getInterest).reversed());
            return;
        }

    }

    public static void searchBook (String mes,Scanner sc){
        if(mes.equals("name")){
            System.out.println("nhập tên cần tìm.");
            String name = sc.nextLine();
            boolean found = false;
            for (Book book : GlobalData.books){
                if(book.getBookName().equals(name)){
                    System.out.println("id: " + book.getBookId() + " | " +
                            "name: " + book.getBookName() + " | " +
                            "giá nhập: " + book.getImportPrice() + " | " +
                            "giá xuất: " + book.getExportPrice() + " | " +
                            "tác giả: " + book.getAuthor() + " | " +
                            "lãi suất: " + book.getInterest() + " | " +
                            "năm: " + book.getYear());
                    found = true;
                    break;
                }
            }

            if(!found) System.out.println("không tìm thấy");
        }
    }

    public static void countBooksByYear() {
        List<Integer> years = new ArrayList<>();

        for (Book book : GlobalData.books) {
            int year = book.getYear();
            if (!years.contains(year)) {
                years.add(year);
            }
        }

        for (int year : years) {
            int count = 0;
            for (Book book : GlobalData.books) {
                if (book.getYear() == year) {
                    count++;
                }
            }
            System.out.println("năm " + year + ": " + count + " quyển");
        }
    }

    public static void countBooksByAuthor() {
        List<String> authors = new ArrayList<>();

        for (Book book : GlobalData.books) {
            String author = book.getAuthor();
            if (!authors.contains(author)) {
                authors.add(author);
            }
        }

        for (String author : authors) {
            int count = 0;
            for (Book book : GlobalData.books) {
                if (book.getAuthor().equals(author)) {
                    count++;
                }
            }
            System.out.println("author " + author + ": " + count + " quyển");
        }
    }

}
