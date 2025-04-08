package business;

import entity.ClassRoom;
import entity.Course;
import entity.Student;
import entity.Teacher;
import entity.enums.ClassStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ClassroomBusiness {
    public static final List<ClassRoom> CLASSROOMS = new ArrayList<>();

    public void addNewClassroom(Scanner sc) {
        ClassRoom classRoom = new ClassRoom();
        classRoom.inputData(sc);
        CLASSROOMS.add(classRoom);
        System.out.println("Đã thêm lớp học.");
    }

    public void displayClassroomsSortedByCreatedDate() {
        if (CLASSROOMS.isEmpty()) {
            System.out.println("Không có lớp học nào.");
            return;
        }

        CLASSROOMS.stream()
                .sorted(Comparator.comparing(ClassRoom::getCreated).reversed())
                .forEach(System.out::println);
    }

    public void updateClassroom(Scanner sc) {
        System.out.print("Nhập ID lớp cần cập nhật: ");
        int id = Integer.parseInt(sc.nextLine());

        ClassRoom found = findById(id);
        if (found == null) {
            System.out.println("Không tìm thấy lớp.");
            return;
        }

        if (found.getStatus() == ClassStatus.CLOSE) {
            System.out.println("Không thể cập nhật lớp đã đóng.");
            return;
        }

        System.out.println("Nhập thông tin mới:");
        found.inputData(sc);
        System.out.println("Cập nhật thành công.");
    }

    public void deleteClassroom(Scanner sc) {
        System.out.print("Nhập ID lớp cần xóa: ");
        int id = Integer.parseInt(sc.nextLine());

        ClassRoom found = findById(id);
        if (found == null) {
            System.out.println("Không tìm thấy lớp.");
            return;
        }

        if (found.getTeacherId() != 0 || !found.getStudentOfClass().isEmpty()) {
            System.out.println("Lớp đã có giảng viên hoặc sinh viên, không thể xóa.");
            return;
        }

        CLASSROOMS.remove(found);
        System.out.println("Đã xóa lớp.");
    }

    public void assignTeacherToClassroom(Scanner sc) {
        System.out.print("Nhập ID lớp: ");
        int id = Integer.parseInt(sc.nextLine());

        ClassRoom found = findById(id);
        if (found == null) {
            System.out.println("Không tìm thấy lớp.");
            return;
        }

        System.out.print("Nhập ID giảng viên: ");
        int teacherId = Integer.parseInt(sc.nextLine());

        Teacher teacher = TeacherBusiness.TEACHERS.stream()
                .filter(t -> t.getTeacherId() == teacherId)
                .findFirst().orElse(null);

        if (teacher == null) {
            System.out.println("Không tìm thấy giảng viên.");
            return;
        }

        found.setTeacherId(teacherId);
        System.out.println("Đã phân công giảng viên.");
    }

    public void addStudentToClassroom(Scanner sc) {
        System.out.print("Nhập ID lớp: ");
        int id = Integer.parseInt(sc.nextLine());

        ClassRoom found = findById(id);
        if (found == null) {
            System.out.println("Không tìm thấy lớp.");
            return;
        }

        System.out.print("Nhập mã sinh viên: ");
        String studentId = sc.nextLine();

        Student student = StudentBusiness.STUDENTS.stream()
                .filter(s -> s.getStudentId().equalsIgnoreCase(studentId))
                .findFirst().orElse(null);

        if (student == null) {
            System.out.println("Không tìm thấy sinh viên.");
            return;
        }

        if (found.getStudentOfClass().stream().anyMatch(s -> s.getStudentId().equalsIgnoreCase(studentId))) {
            System.out.println("Sinh viên đã có trong lớp.");
            return;
        }

        found.getStudentOfClass().add(student);
        System.out.println("Đã thêm sinh viên vào lớp.");
    }

    public void changeClassroomStatus(Scanner sc) {
        System.out.print("Nhập ID lớp: ");
        int id = Integer.parseInt(sc.nextLine());

        ClassRoom found = findById(id);
        if (found == null) {
            System.out.println("Không tìm thấy lớp.");
            return;
        }

        switch (found.getStatus()) {
            case PENDING -> found.setStatus(ClassStatus.PROGRESS);
            case PROGRESS -> found.setStatus(ClassStatus.CLOSE);
            case CLOSE -> {
                System.out.println("Lớp đã CLOSE, không thể cập nhật.");
                return;
            }
        }

        System.out.println("Trạng thái lớp đã được cập nhật: " + found.getStatus());
    }

    public ClassRoom findById(int id) {
        return CLASSROOMS.stream()
                .filter(c -> c.getClassroomId() == id)
                .findFirst().orElse(null);
    }
}