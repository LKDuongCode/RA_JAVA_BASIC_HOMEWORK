package business;

import entity.Course;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CourseBusiness {
    public static final List<Course> COURSES = new ArrayList<>();

    public void displayCoursesSortedByName() {
        if (COURSES.isEmpty()) {
            System.out.println("Không có khóa học nào.");
            return;
        }

        COURSES.stream()
                .sorted(Comparator.comparing(Course::getCourseName))
                .forEach(System.out::println);
    }

    public void addNewCourse(Scanner sc) {
        Course course = new Course();
        course.inputData(sc);
        COURSES.add(course);
        System.out.println("Đã thêm khóa học thành công.");
    }

    public void updateCourse(Scanner sc) {
        System.out.print("Nhập ID khóa học cần cập nhật: ");
        String id = sc.nextLine();

        Course found = findById(id);
        if (found == null) {
            System.out.println("Không tìm thấy khóa học với ID: " + id);
            return;
        }

        System.out.println("Nhập thông tin mới cho khóa học:");
        found.inputData(sc);
        System.out.println("Cập nhật thành công.");
    }

    public void deleteCourseById(Scanner sc) {
        System.out.print("Nhập ID khóa học cần xóa: ");
        String id = sc.nextLine();

        Course found = findById(id);
        if (found == null) {
            System.out.println("Không tìm thấy khóa học.");
            return;
        }

        COURSES.remove(found);
        System.out.println("Đã xóa khóa học.");
    }

    public Course findById(String id) {
        return COURSES.stream()
                .filter(c -> c.getCourseId().equalsIgnoreCase(id))
                .findFirst()
                .orElse(null);
    }
}