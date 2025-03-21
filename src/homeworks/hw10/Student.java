package homeworks.hw10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Student {
    private String id;
    private String name;
    private double gpa;

    public Student(String id, String name, double gpa) {
        setId(id);
        setName(name);
        setGpa(gpa);
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public static List<Student> inputData(Scanner sc, int n) {
        List<Student> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            System.out.printf("\nstudents[%d]\n", i);

            System.out.print("Mã sinh viên: ");
            String id = sc.nextLine();

            System.out.print("Họ và tên: ");
            String name = sc.nextLine();

            System.out.print("Điểm gpa: ");
            double gpa = Double.parseDouble(sc.nextLine());

            Student st = new Student(id, name, gpa);
            students.add(st);
        }

        return students;
    }


    public String classifyingGpa() {
        if (gpa >= 8.5) return "Xuất sắc";
        else if (gpa >= 7.0) return "Giỏi";
        else if (gpa >= 5.5) return "Khá";
        else return "Trung bình/Yếu";
    }
}
