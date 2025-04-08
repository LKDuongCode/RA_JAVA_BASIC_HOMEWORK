package business;

import entity.ClassRoom;
import entity.CourseRegistration;
import entity.Student;
import entity.Teacher;

import java.util.*;
import java.util.stream.Collectors;

public class DashboardBusiness {
    public void showOverallStats() {
        System.out.println("Tổng số thống kê:");
        System.out.println(" - Số sinh viên: " + StudentBusiness.STUDENTS.size());
        System.out.println(" - Số giảng viên: " + TeacherBusiness.TEACHERS.size());
        System.out.println(" - Số khóa học: " + CourseBusiness.COURSES.size());
        System.out.println(" - Số lớp học: " + ClassroomBusiness.CLASSROOMS.size());
    }

    public void showTopCoursesByRegistration() {
        System.out.println("Top 3 khóa học có nhiều sinh viên đăng ký nhất:");

        Map<String, Long> countMap = CourseRegistrationBusiness.REGISTRATIONS.stream()
                .collect(Collectors.groupingBy(CourseRegistration::getCourseId, Collectors.counting()));

        countMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .forEach(entry -> {
                    System.out.println(" - Mã khóa: " + entry.getKey() + " | Lượt đăng ký: " + entry.getValue());
                });
    }

    public void showTopClassroomsByStudents() {
        System.out.println("Top 3 lớp học có nhiều sinh viên nhất:");

        ClassroomBusiness.CLASSROOMS.stream()
                .sorted(Comparator.comparingInt(c -> -c.getStudentOfClass().size()))
                .limit(3)
                .forEach(c -> {
                    System.out.println(" - Mã lớp: " + c.getClassroomId() +
                            " | Tên: " + c.getClassroomName() +
                            " | Số SV: " + c.getStudentOfClass().size());
                });
    }

    public void showTopTeachersByStudents() {
        System.out.println("Top 3 giảng viên dạy nhiều sinh viên nhất:");

        // Map<teacherId, tổng số sinh viên dạy>
        Map<Integer, Integer> teacherStudentCount = new HashMap<>();

        for (ClassRoom cr : ClassroomBusiness.CLASSROOMS) {
            int teacherId = cr.getTeacherId();
            int numStudents = cr.getStudentOfClass().size();

            teacherStudentCount.put(teacherId,
                    teacherStudentCount.getOrDefault(teacherId, 0) + numStudents);
        }

        teacherStudentCount.entrySet().stream()
                .sorted(Map.Entry.<Integer, Integer>comparingByValue().reversed())
                .limit(3)
                .forEach(entry -> {
                    Teacher t = TeacherBusiness.TEACHERS.stream()
                            .filter(te -> te.getTeacherId() == entry.getKey())
                            .findFirst().orElse(null);

                    String name = t != null ? t.getName() : "(Không tìm thấy)";
                    System.out.println(" - " + name + " (ID: " + entry.getKey() + ") dạy " + entry.getValue() + " sinh viên.");
                });
    }

    public void showTopStudentsByCourses() {
        System.out.println("Top 3 sinh viên đăng ký nhiều khóa học nhất:");

        Map<String, Long> countMap = CourseRegistrationBusiness.REGISTRATIONS.stream()
                .collect(Collectors.groupingBy(CourseRegistration::getStudentId, Collectors.counting()));

        countMap.entrySet().stream()
                .sorted(Map.Entry.<String, Long>comparingByValue().reversed())
                .limit(3)
                .forEach(entry -> {
                    Student s = StudentBusiness.STUDENTS.stream()
                            .filter(st -> st.getStudentId().equalsIgnoreCase(entry.getKey()))
                            .findFirst().orElse(null);

                    String name = s != null ? s.getName() : "(Không tìm thấy)";
                    System.out.println(" - " + name + " (ID: " + entry.getKey() + ") đăng ký " + entry.getValue() + " khóa.");
                });
    }
}