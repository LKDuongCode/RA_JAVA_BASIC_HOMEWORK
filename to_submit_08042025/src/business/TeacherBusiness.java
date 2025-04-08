package business;

import entity.Teacher;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TeacherBusiness {
    public static final List<Teacher> TEACHERS = new ArrayList<>();

    public void displayTeachersSortedByIdDesc() {
        if (TEACHERS.isEmpty()) {
            System.out.println("Không có giảng viên nào.");
            return;
        }

        TEACHERS.stream()
                .sorted(Comparator.comparing(Teacher::getTeacherId).reversed())
                .forEach(System.out::println);
    }

    public void addNewTeacher(Scanner sc) {
        Teacher teacher = new Teacher();
        teacher.inputData(sc);
        TEACHERS.add(teacher);
        System.out.println("Đã thêm giảng viên thành công.");
    }

    public void updateTeacher(Scanner sc) {
        System.out.print("Nhập mã giảng viên cần cập nhật: ");
        int id = Integer.parseInt(sc.nextLine());

        Teacher found = findById(id);
        if (found == null) {
            System.out.println("Không tìm thấy giảng viên với ID: " + id);
            return;
        }

        System.out.println("Nhập thông tin mới cho giảng viên:");
        found.inputData(sc);
        System.out.println("Cập nhật thành công.");
    }

    public void deleteTeacher(Scanner sc) {
        System.out.print("Nhập mã giảng viên cần xóa: ");
        int id = Integer.parseInt(sc.nextLine());

        Teacher found = findById(id);
        if (found == null) {
            System.out.println("Không tìm thấy giảng viên.");
            return;
        }

        TEACHERS.remove(found);
        System.out.println("Đã xóa giảng viên.");
    }

    public Teacher findById(int id) {
        return TEACHERS.stream()
                .filter(t -> t.getTeacherId() == id)
                .findFirst()
                .orElse(null);
    }
}