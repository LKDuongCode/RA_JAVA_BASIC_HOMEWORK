package hw01;

public class Main {
    public static void main(String[] args) {
        MyThread t01 = new MyThread();
        t01.start();

        MyThread t02 = new MyThread();
        t02.start();
    }
}
