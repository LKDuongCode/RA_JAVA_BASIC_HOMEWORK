package hw09;

import java.util.Objects;

public class Book implements Comparable<Book>{
    private String id;
    private String title;
    private String author;
    private int publicYear;

    public Book(String id, String author, String title, int publicYear) {
        setId(id);
        setTitle(title);
        setAuthor(author);
        setPublicYear(publicYear);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public int getPublicYear() {
        return publicYear;
    }

    public void setPublicYear(int publicYear) {
        this.publicYear = publicYear;
    }

    @Override
    public String toString() {
        return "Id: " + this.id + " | title: " + this.title + " |  author: " + this.author + " | publicYear: " + this.publicYear;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this){
            return true;
        }

        if (obj == null || getClass() != obj.getClass()){
            return false;
        }

        Book book = (Book) obj;
        return Objects.equals(this.id, book.id);
        }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public int compareTo(Book other) {
        return Integer.compare(this.publicYear, other.publicYear);
    }

}
