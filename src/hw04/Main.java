package hw04;

public class Main {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new Running(1));
        Thread thread2 = new Thread(new Running(2));
        Thread thread3 = new Thread(new Running(3));

        thread1.start();

        try {
            thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread2.start();
        thread3.start();
    }
}
