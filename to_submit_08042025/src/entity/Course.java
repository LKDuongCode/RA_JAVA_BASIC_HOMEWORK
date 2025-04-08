package entity;

import utils.InputUtils;
import utils.ValidateCourseUtils;

import java.util.Scanner;

public class Course implements  IApp{
    private String courseId;
    private String courseName;
    private boolean status;

    public Course() {
    }

    public Course(String courseId, String courseName, boolean status) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.status = status;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner sc) {
        System.out.println("nhập mã khóa học: (Cxxxx)");
        setCourseId(ValidateCourseUtils.validateCourseId(sc));
        System.out.println("nhập tên khóa học :");
        setCourseName(ValidateCourseUtils.validateCourseName(sc));
        System.out.println("nhập trạng thái khóa học (true/false)");
        setStatus(InputUtils.validateBoolean(sc,"trạng thái khóa học."));
    }

    @Override
    public String toString() {
        return " |ID: " + courseId + " |courseName: " + this.courseName + " |status: " + (this.status ? "mở |" : "đóng |" );
    }
}
