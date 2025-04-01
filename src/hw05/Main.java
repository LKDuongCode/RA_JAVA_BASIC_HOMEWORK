package hw05;

public class Main {
    public static void main(String[] args) {
        SharedData data = new SharedData();

        Thread writer = new Thread(new Running(data, true));
        Thread reader = new Thread(new Running(data, false));

        reader.start();
        writer.start();
    }
}
