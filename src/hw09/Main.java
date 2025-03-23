package hw09;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<Book> books = new HashSet<>();
        addUniqueBook(books,"B123","gg","duong",2025);
        addUniqueBook(books,"B121","ff","linh",2021);
        addUniqueBook(books,"B145","vv","chi",2020);
        System.out.println(books);

        List<Book> result = filterBookByYear(books,2020);
        System.out.println(result);

    }

    public static void addUniqueBook ( Set<Book> books, String id, String title, String author, int publicYear){
        Book newBook = new Book(id,author,title,publicYear);

        Iterator<Book> it = books.iterator();
        while(it.hasNext()){
            Book curBook = it.next();
            boolean checking = curBook.equals(newBook);

            if(checking){
                System.out.println("Sách với id " + newBook.getId() + " đã tồn tại ");
                return;
            }
        }
        books.add(newBook);

    }

    public static List<Book> filterBookByYear (Set<Book> books, int year){
        List<Book> filteredBooks = new ArrayList<>();
        Iterator<Book> it = books.iterator();
        while(it.hasNext()){
            Book currentBook = it.next();
            if(currentBook.getPublicYear() == year){
                filteredBooks.add(currentBook);
            }
        }

        Collections.sort(filteredBooks);

        return filteredBooks;
    }
}
