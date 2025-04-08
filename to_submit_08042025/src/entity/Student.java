package entity;

import business.StudentBusiness;
import entity.enums.Sex;
import utils.InputUtils;
import utils.ValidatePersonUtils;
import utils.ValidateStudentUtils;

import java.util.Scanner;

public class Student extends Person implements IApp {
    private String studentId;
    private double gpa;

    public Student(String name, int age, String address, String phone, String email, Sex sex, String studentId, double gpa) {
        super(name, age, address, phone, email, sex);
        this.studentId = studentId;
        this.gpa = gpa;
    }

    public Student() {
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    @Override
    public void inputData(Scanner sc) {
        System.out.println("nhập mã sinh viên: (SVxxx)");
        setStudentId(sc.nextLine());

        super.inputData(sc);

        System.out.println("nhập số điện thoại:");
        setPhone(ValidatePersonUtils.validatePhone(sc, StudentBusiness.STUDENTS));

        System.out.println("nhập email:");
        setEmail(ValidatePersonUtils.validateEmail(sc,StudentBusiness.STUDENTS));

        System.out.println("nhập gpa: ");
        setGpa(InputUtils.validateDouble(sc));
    }

    @Override
    public String toString() {
        return " |studentId: " + this.studentId +
                super.toString() +
                " |gpa: " + this.gpa;
    }
}
