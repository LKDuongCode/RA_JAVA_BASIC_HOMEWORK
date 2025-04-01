package hw04;

public class Running implements Runnable {
    private int threadId;

    public Running(int threadId) {
        this.threadId = threadId;
    }

    @Override
    public void run() {
        if (threadId == 1) {
            for (int i = 1; i <= 5; i++) {
                System.out.println("Thread 1: " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        } else if (threadId == 2) {
            System.out.println("Thread 2 bắt đầu...");
        } else if (threadId == 3) {
            System.out.println("Thread 3 bắt đầu...");
        }
    }
}
