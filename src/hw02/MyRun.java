package hw02;

public class MyRun implements Runnable{
    @Override
    public void run (){
        System.out.println("thread - " + Thread.currentThread().getName());
        for(int i = 0; i < 10; i++) {
            System.out.println(i);
        }
    }
}
