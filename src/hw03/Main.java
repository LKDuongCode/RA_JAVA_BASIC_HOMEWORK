package hw03;

public class Main {
    public static void main(String[] args) {
        SharedResource s = new SharedResource();

        Thread a = new Thread(new Runing(s,"a"));
        Thread b = new Thread(new Runing(s,"b"));

        a.start();
        b.start();
    }
}
