package hw04;

public class Main {
    public static void main(String[] args) {
        // tạo mảng thiết bị
        Electronic[] devices  = new Electronic[10];
        int curIdx = 0;

        devices[curIdx++] = new TV();
        devices[curIdx++] = new Radio();

        // duyệt và gọi method
        for(int i = 0; i < curIdx; i++) {
            devices[i].turnOn();
            devices[i].turnOff();
        }
    }
}
