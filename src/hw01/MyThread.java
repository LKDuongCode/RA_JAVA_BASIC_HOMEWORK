package hw01;

public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.printf("thread đang chạy : [%s]",Thread.currentThread().getName());
    }
}
