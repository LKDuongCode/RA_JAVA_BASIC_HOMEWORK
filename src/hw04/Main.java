package hw04;

public class Main {
    public static void main(String[] args) {
        Book b1 = new Book("the lord of the rings",300,"duong");

        System.out.println("car1 :");
        System.out.println(b1.getAuthor());
        System.out.println(b1.getPrice());
        System.out.println(b1.getTitle());

        b1.setAuthor("gg");
        b1.setPrice(-20);
        b1.setTitle("FF");
    }
}
