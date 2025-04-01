package hw05;

public class SharedData {
    private String message;
    private boolean hasMessage = false;

    public synchronized void write(String msg) {
        while (hasMessage) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        message = msg;
        hasMessage = true;
        System.out.println("Writer đã gửi: " + msg);
        notify();
    }

    public synchronized String read() {
        while (!hasMessage) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        hasMessage = false;
        notify();
        return message;
    }
}
