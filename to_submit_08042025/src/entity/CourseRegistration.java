package entity;

import entity.enums.RegistrationStatus;
import utils.InputUtils;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class CourseRegistration implements IApp{
    public static final AtomicInteger AUTO_COURSE_REGISTRATION_ID = new AtomicInteger(1);

    private int crId;
    private String studentId;
    private String courseId;
    private LocalDate crDate;
    RegistrationStatus crStatus;

    public CourseRegistration() {
    }

    public CourseRegistration(int crId, String studentId, String courseId, LocalDate crDate, RegistrationStatus crStatus) {
        this.crId = crId;
        this.studentId = studentId;
        this.courseId = courseId;
        this.crDate = crDate;
        this.crStatus = crStatus;
    }

    public int getCrId() {
        return crId;
    }

    public void setCrId(int crId) {
        this.crId = crId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public LocalDate getCrDate() {
        return crDate;
    }

    public void setCrDate(LocalDate crDate) {
        this.crDate = crDate;
    }

    public RegistrationStatus getCrStatus() {
        return crStatus;
    }

    public void setCrStatus(RegistrationStatus crStatus) {
        this.crStatus = crStatus;
    }

    @Override
    public void inputData(Scanner sc) {

        System.out.println("nhập mã sinh viên:");
        setStudentId(sc.nextLine());

        System.out.println("nhập mã khóa học:");
        setCourseId(sc.nextLine());

        System.out.println("nhập trạng thái:");
        setCrStatus(InputUtils.validateEnum(sc,"trạng thái đăng kí.",RegistrationStatus.class));

        setCrId(AUTO_COURSE_REGISTRATION_ID.getAndIncrement());
        setCrDate(LocalDate.now());

    }

    @Override
    public String toString() {
        return " |ID: " + this.crId + " |studentId: " + this.studentId + " |courseId: " + this.courseId + " |date: " + this.crDate + " |status:" + this.crStatus;
    }
}
