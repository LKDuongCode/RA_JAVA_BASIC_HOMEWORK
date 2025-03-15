package hw08;

public class GasCar extends Car {
    public GasCar(String model, int year, double price) {
        super(model, year, price);
    }

    @Override
    public void start() {
        System.out.println("Xe chạy xăng " + model + " (Năm SX: " + year + ", Giá: $" + price + ") đã khởi động với tiếng động cơ.");
    }

    @Override
    public void stop() {
        System.out.println("Xe chạy xăng " + model + " (Năm SX: " + year + ", Giá: $" + price + ") đã dừng và động cơ tắt.");
    }

    @Override
    public void refuel() {
        System.out.println("Xe chạy xăng " + model + " (Năm SX: " + year + ", Giá: $" + price + ") đang được đổ xăng...");
    }
}
