package hw08;

public class Dog extends Animals {
    private String breed;

    public Dog(String name, int age, String breed) {
        super(name, age);

        if (breed == null || breed.trim().isEmpty()) {
            System.out.println(" Giống chó không được để trống! Đặt thành 'Unknown'.");
            this.breed = "Unknown";
        } else {
            this.breed = breed;
        }
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        if (breed == null || breed.trim().isEmpty()) {
            System.out.println(" Giống chó không được để trống!");
        } else {
            this.breed = breed;
        }
    }

    @Override
    public void displayInfo() {
        System.out.println("Tên: " + name + " | Tuổi: " + age + " | Giống: " + breed);
    }

    @Override
    public String makeSound() {
        return "Woof Woof";
    }
}
