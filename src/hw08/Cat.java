package hw08;

public class Cat extends Animals {
    private String furColor;

    public Cat(String name, int age, String furColor) {
        super(name, age);

        if (furColor == null || furColor.trim().isEmpty()) {
            System.out.println(" Màu lông không được để trống! Đặt thành 'Unknown'.");
            this.furColor = "Unknown";
        } else {
            this.furColor = furColor;
        }
    }

    public String getFurColor() {
        return furColor;
    }

    public void setFurColor(String furColor) {
        if (furColor == null || furColor.trim().isEmpty()) {
            System.out.println(" Màu lông không được để trống!");
        } else {
            this.furColor = furColor;
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Tên: " + name + " | Tuổi: " + age + " | Màu lông: " + furColor);
    }

    @Override
    public String makeSound() {
        return "Meow Meow";
    }
}
