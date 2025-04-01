package hw02;

public class Main {
    public static void main(String[] args) {
        MyRun task = new MyRun();
        Thread t01 = new Thread(task);

        t01.start();
    }
}
