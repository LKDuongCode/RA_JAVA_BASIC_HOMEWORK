package practices.begin.p3;

public class Main {
    public static void main(String[] args) {
        MyRunnable r = new MyRunnable();
        new Thread(r).start();
    }
}
