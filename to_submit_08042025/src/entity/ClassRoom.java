package entity;

import entity.enums.ClassStatus;
import utils.InputUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class ClassRoom implements IApp{
    private static final AtomicInteger AUTO_CLASSROOM_ID = new AtomicInteger(1);


    private int classroomId;
    private String classroomName;
    private String courseId;
    private int teacherId;
    private List<Student> studentOfClass;
    private LocalDate created;
    private ClassStatus status;

    public ClassRoom() {
    }

    public ClassRoom(int classroomId, String classroomName, String courseId, int teacherId, List<Student> studentOfClass, LocalDate created, ClassStatus status) {
        this.classroomId = classroomId;
        this.classroomName = classroomName;
        this.courseId = courseId;
        this.teacherId = teacherId;
        this.studentOfClass = studentOfClass;
        this.created = created;
        this.status = status;
    }


    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public void setClassroomName(String classroomName) {
        this.classroomName = classroomName;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public List<Student> getStudentOfClass() {
        return studentOfClass;
    }

    public void setStudentOfClass(List<Student> studentOfClass) {
        this.studentOfClass = studentOfClass;
    }

    public LocalDate getCreated() {
        return created;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public ClassStatus getStatus() {
        return status;
    }

    public void setStatus(ClassStatus status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner sc) {
        setClassroomId(AUTO_CLASSROOM_ID.getAndIncrement());

        System.out.println("nhập tên lớp:");
        setClassroomName(sc.nextLine());

        System.out.println("nhập mã khóa học:");
        setCourseId(sc.nextLine());

        setStudentOfClass(new ArrayList<>());
        setCreated(LocalDate.now());

        System.out.println("nhập mã giảng viên: ");
        setTeacherId(Integer.parseInt(sc.nextLine()));

        setStudentOfClass(new ArrayList<>());
        setCreated(LocalDate.now());

        System.out.println("nhập trạng thái lớp:");
        setStatus(InputUtils.validateEnum(sc,"trạng thái lớp.",ClassStatus.class));
    }

    @Override
    public String toString() {
        return " |classroomId: " + this.classroomId + " |name: " +this.classroomName + " |courseId: " +this.courseId + " |teacherId: " +this.teacherId + " |numOfStd: " +this.studentOfClass.size() + " |created: " +this.created +" |status: " + this.status;
    }
}
