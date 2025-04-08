package business;

import entity.Student;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class StudentBusiness {
    public static final List<Student> STUDENTS = new ArrayList<>();

    public void displayStudentsSortedByName() {
        if (STUDENTS.isEmpty()) {
            System.out.println("Không có sinh viên nào.");
            return;
        }

        STUDENTS.stream()
                .sorted(Comparator.comparing(Student::getName))
                .forEach(System.out::println);
    }

    public void addNewStudent(Scanner sc) {
        Student student = new Student();
        student.inputData(sc);
        STUDENTS.add(student);
        System.out.println("Đã thêm sinh viên thành công.");
    }

    public void updateStudent(Scanner sc) {
        System.out.print("Nhập mã sinh viên cần cập nhật: ");
        String id = sc.nextLine().trim();

        Student found = findById(id);
        if (found == null) {
            System.out.println("Không tìm thấy sinh viên với ID: " + id);
            return;
        }

        System.out.println("Nhập thông tin mới cho sinh viên:");
        found.inputData(sc);
        System.out.println("Cập nhật thành công.");
    }

    public void deleteStudent(Scanner sc) {
        System.out.print("Nhập mã sinh viên cần xóa: ");
        String id = sc.nextLine().trim();

        Student found = findById(id);
        if (found == null) {
            System.out.println("Không tìm thấy sinh viên.");
            return;
        }

        STUDENTS.remove(found);
        System.out.println("Đã xóa sinh viên.");
    }

    public Student findById(String id) {
        return STUDENTS.stream()
                .filter(s -> s.getStudentId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }
}