package homeworks.hw10;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class StudentManager {
    private List<Student> students = new ArrayList<>();

    public void addStudent(Student student) {
        students.add(student);
        System.out.println("Đã thêm sinh viên: " + student.getName());
    }

    public void saveToFile(String filename) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(filename))) {
            oos.writeObject(students);
            System.out.println("Đã lưu vào file " + filename);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void loadFromFile(String filename) {
        File file = new File(filename);
        if (!file.exists()) {
            System.out.println("File không tồn tại!");
            return;
        }

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(filename))) {
            students = (List<Student>) ois.readObject();
            System.out.println("Đã nạp danh sách từ file " + filename);
        } catch (IOException | ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
    }

    public Student findTopStudent() {
        return students.stream()
                .max(Comparator.comparingDouble(Student::getGpa))
                .orElse(null);
    }

    public List<Student> searchByMajor(String major) {
        return students.stream()
                .filter(s -> s.getMajor().equalsIgnoreCase(major))
                .collect(Collectors.toList());
    }

    public double calculateAverageGpa() {
        return students.stream()
                .mapToDouble(Student::getGpa)
                .average()
                .orElse(0.0);
    }

    public void displayAll() {
        if (students.isEmpty()) {
            System.out.println("trống.");
        } else {
            students.forEach(System.out::println);
        }
    }
}
