package homeworks.hw10;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        StudentManager manager = new StudentManager();
        String filePath = "src/homeworks/hw10/students.dat";

        manager.addStudent(new Student(1, "Lê Khánh Dương", "CNTT", 3.8));
        manager.addStudent(new Student(2, "Nguyễn Văn A", "Marketing", 3.2));
        manager.addStudent(new Student(3, "Trần Thị B", "CNTT", 3.5));
        manager.addStudent(new Student(4, "Phạm Văn C", "Kinh tế", 2.8));

        manager.saveToFile(filePath);
        manager.loadFromFile(filePath);
        System.out.println("Danh sách sinh viên:");
        manager.displayAll();

        Student top = manager.findTopStudent();
        System.out.println("Sinh viên GPA cao nhất:");
        System.out.println(top);

        String majorSearch = "CNTT";
        List<Student> cnttList = manager.searchByMajor(majorSearch);
        System.out.println(" Danh sách theo chuyên ngành: " + majorSearch);
        cnttList.forEach(System.out::println);

        double avg = manager.calculateAverageGpa();
        System.out.printf("GPA trung bình: %.2f", avg);
    }
}
