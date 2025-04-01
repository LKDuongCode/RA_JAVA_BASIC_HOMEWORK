package practices.begin.p1;

public class MyThread extends Thread{
    @Override
    public void run (){
        System.out.println("xin chào từ luồng " + Thread.currentThread().getName());
    }
}
