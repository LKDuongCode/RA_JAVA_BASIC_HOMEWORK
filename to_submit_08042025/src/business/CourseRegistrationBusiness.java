package business;

import entity.Course;
import entity.CourseRegistration;
import entity.Student;
import entity.enums.RegistrationStatus;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseRegistrationBusiness {
    public static final List<CourseRegistration> REGISTRATIONS = new ArrayList<>();

    public void registerCourse(Scanner sc) {
        System.out.print("Nhập mã sinh viên: ");
        String studentId = sc.nextLine();

        Student student = StudentBusiness.STUDENTS.stream()
                .filter(s -> s.getStudentId().equalsIgnoreCase(studentId))
                .findFirst().orElse(null);

        if (student == null) {
            System.out.println("Không tìm thấy sinh viên.");
            return;
        }

        System.out.print("Nhập mã khóa học: ");
        String courseId = sc.nextLine();

        Course course = CourseBusiness.COURSES.stream()
                .filter(c -> c.getCourseId().equalsIgnoreCase(courseId))
                .findFirst().orElse(null);

        if (course == null) {
            System.out.println("Không tìm thấy khóa học.");
            return;
        }

        CourseRegistration reg = new CourseRegistration();
        reg.setCrId(CourseRegistration.AUTO_COURSE_REGISTRATION_ID.getAndIncrement());
        reg.setStudentId(studentId);
        reg.setCourseId(courseId);
        reg.setCrDate(LocalDate.now());
        reg.setCrStatus(RegistrationStatus.PENDING);

        REGISTRATIONS.add(reg);
        System.out.println("Đăng ký khóa học thành công (trạng thái: PENDING).");
    }

    public void cancelPendingRegistration(Scanner sc) {
        System.out.print("Nhập mã sinh viên: ");
        String studentId = sc.nextLine();

        List<CourseRegistration> studentRegs = getByStudentId(studentId);

        if (studentRegs.isEmpty()) {
            System.out.println("Sinh viên chưa đăng ký khóa học nào.");
            return;
        }

        boolean foundPending = false;
        for (CourseRegistration reg : studentRegs) {
            if (reg.getCrStatus() == RegistrationStatus.PENDING) {
                REGISTRATIONS.remove(reg);
                System.out.println("Đã hủy đăng ký PENDING.");
                foundPending = true;
                break;
            }
        }

        if (!foundPending) {
            System.out.println("Không có đăng ký nào ở trạng thái PENDING.");
        }
    }

    public void approveRegistration(Scanner sc) {
        System.out.print("Nhập mã sinh viên: ");
        String studentId = sc.nextLine();

        List<CourseRegistration> pendingRegs = getByStudentId(studentId).stream()
                .filter(r -> r.getCrStatus() == RegistrationStatus.PENDING)
                .toList();

        if (pendingRegs.isEmpty()) {
            System.out.println("Không có đăng ký nào ở trạng thái PENDING.");
            return;
        }

        for (CourseRegistration r : pendingRegs) {
            r.setCrStatus(RegistrationStatus.ENROLLED);
        }

        System.out.println("Đã duyệt " + pendingRegs.size() + " đăng ký thành công.");
    }

    public void viewRegistrationsByCourse(Scanner sc) {
        System.out.print("Nhập mã khóa học: ");
        String courseId = sc.nextLine();

        List<CourseRegistration> filtered = REGISTRATIONS.stream()
                .filter(r -> r.getCourseId().equalsIgnoreCase(courseId))
                .toList();

        if (filtered.isEmpty()) {
            System.out.println("Không có sinh viên nào đăng ký khóa học này.");
            return;
        }

        filtered.forEach(System.out::println);
    }

    public List<CourseRegistration> getByStudentId(String studentId) {
        return REGISTRATIONS.stream()
                .filter(r -> r.getStudentId().equalsIgnoreCase(studentId))
                .toList();
    }
}