package entity;


import business.StudentBusiness;
import business.TeacherBusiness;
import entity.enums.Sex;
import utils.InputUtils;
import utils.ValidatePersonUtils;

import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Teacher extends  Person implements IApp{
    private static final AtomicInteger AUTO_TEACHER_ID = new AtomicInteger(1);
    private int teacherId;
    private String subject;

    public Teacher() {
    }

    public Teacher(String name, int age, String address, String phone, String email, Sex sex, int teacherId, String subject) {
        super(name, age, address, phone, email, sex);
        this.teacherId = teacherId;
        this.subject = subject;
    }

    public int getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(int teacherId) {
        this.teacherId = teacherId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    @Override
    public void inputData(Scanner sc) {
        setTeacherId(AUTO_TEACHER_ID.getAndIncrement());
        super.inputData(sc);

        System.out.println("nhập số điện thoại:");
        setPhone(ValidatePersonUtils.validatePhone(sc, TeacherBusiness.TEACHERS));

        System.out.println("nhập email:");
        setEmail(ValidatePersonUtils.validateEmail(sc,TeacherBusiness.TEACHERS));

        System.out.println("nhập chuyên môn giảng viên:");
        setSubject(InputUtils.validateString(sc,"chuyên môn giảng viên.",1,30));
    }

    @Override
    public String toString() {
        return  " |teacherId: " + this.teacherId + " |subject: " + this.subject + super.toString();
    }
}
