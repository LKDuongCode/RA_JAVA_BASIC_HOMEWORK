package hw08;

public class Animals {
    protected String name;
    protected int age;

    public Animals(String name, int age) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Tên động vật không được để trống!");
            this.name = "Unknown";
        } else {
            this.name = name;
        }

        if (age < 0) {
            System.out.println("Tuổi không thể là số âm! Đặt lại tuổi thành 0.");
            this.age = 0;
        } else {
            this.age = age;
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            System.out.println("Tên động vật không được để trống!");
        } else {
            this.name = name;
        }
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        if (age < 0) {
            System.out.println("Tuổi không thể là số âm!");
        } else {
            this.age = age;
        }
    }

    public void displayInfo() {
        System.out.println("Tên: " + name + " | Tuổi: " + age);
    }

    public String makeSound() {
        return "Some generic sound";
    }
}
