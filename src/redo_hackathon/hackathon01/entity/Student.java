package redo_hackathon.hackathon01.entity;

public class Student implements IApp {
    private String studentId;
    private String studentName;
    private String birthday;
    private boolean gender;
    private String phoneNumber;
    private String email;
    private String major;
    private String className;
    private float gpa;
    private byte status = 1;

    public Student(String studentId, String studentName, String birthday, boolean gender, String phoneNumber, String email, String major, String className, float gpa, byte status) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.birthday = birthday;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.major = major;
        this.className = className;
        this.gpa = gpa;
        this.status = status;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public boolean isGender() {
        return gender;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public float getGpa() {
        return gpa;
    }

    public void setGpa(float gpa) {
        this.gpa = gpa;
    }

    public byte getStatus() {
        return status;
    }

    public void setStatus(byte status) {
        this.status = status;
    }

    @Override
    public void displayData() {
        System.out.println("Student ID: " + this.studentId);
        System.out.println("Name: " + this.studentName);
        System.out.println("Birthday: " + this.birthday);
        System.out.println("Gender: " + (this.gender ? "Nam" : "Nữ"));
        System.out.println("Phone: " + this.phoneNumber);
        System.out.println("Email: " + this.email);
        System.out.println("Major: " + this.major);
        System.out.println("Class Name: " + this.className);
        System.out.println("GPA: " + this.gpa);
        System.out.println("Status: " + (this.status == 1 ? "Active" : "Inactive"));
    }
}
