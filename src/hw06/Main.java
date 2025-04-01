package hw06;

public class Main {
    public static void main(String[] args) {
        PriorityThread t1 = new PriorityThread(" 1 LOW");
        PriorityThread t2 = new PriorityThread(" 2 NORMAL");
        PriorityThread t3 = new PriorityThread(" 3 HIGH");

        t1.setPriority(1);
        t2.setPriority(5);
        t3.setPriority(10);
        t1.start();
        t2.start();
        t3.start();
    }
}
