package homeworks.hw09;

import java.io.*;
import java.util.*;

public class BookManager {
    private List<Book> books;
    private final String FILE_PATH = "src/homeworks/hw09/books.dat";

    public BookManager() {
        books = readFromFile();
    }

    public void addBook(Book book) {
        books.add(book);
        writeToFile();
        System.out.println("Đã thêm sách.");
    }

    public void updateBook(Book updatedBook) {
        for (Book b : books) {
            if (b.getId() == updatedBook.getId()) {
                b.setAuthor(updatedBook.getName());
                b.setPublisher(updatedBook.getPublisher());
                b.setPrice(updatedBook.getPrice());
                writeToFile();
                System.out.println("Đã cập nhật sách.");
                return;
            }
        }
        System.out.println("Không tìm thấy sách để cập nhật.");
    }

    public void deleteBook(String title) {
        boolean removed = books.removeIf(b -> b.getName().equalsIgnoreCase(title));
        if (removed) {
            writeToFile();
            System.out.println("Đã xóa sách có tên: " + title);
        } else {
            System.out.println("Không tìm thấy sách để xóa.");
        }
    }

    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("Không có sách nào trong danh sách.");
        } else {
            System.out.println("Danh sách sách:");
            books.forEach(System.out::println);
        }
    }

    private List<Book> readFromFile() {
        File file = new File(FILE_PATH);
        if (!file.exists()) return new ArrayList<>();

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            return (List<Book>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
            return new ArrayList<>();
        }
    }

    private void writeToFile() {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
            oos.writeObject(books);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
