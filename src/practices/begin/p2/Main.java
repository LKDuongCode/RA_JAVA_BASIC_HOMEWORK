package practices.begin.p2;

public class Main {
    public static void main(String[] args) {
        MyRunnable task = new MyRunnable();
        Thread t = new Thread(task);
        t.start();
    }
}
