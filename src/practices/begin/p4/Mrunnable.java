package practices.begin.p4;

public class Mrunnable implements Runnable{
    @Override
    public void run() {
        System.out.println("tên luông hiện tại: " + Thread.currentThread().getName());
    }
}
