package hw05;

public class Running implements Runnable {
    private SharedData data;
    private boolean isWriter;

    public Running(SharedData data, boolean isWriter) {
        this.data = data;
        this.isWriter = isWriter;
    }

    @Override
    public void run() {
        if (isWriter) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            data.write("Hello từ Writer ");
        } else {
            String msg = data.read();
            System.out.println("Reader nhận được: " + msg);
        }
    }
}
