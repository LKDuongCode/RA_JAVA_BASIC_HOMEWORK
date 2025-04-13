package business.model.employee;

import java.time.LocalDate;

public class Employee {
    private String employeeId;
    private String employeeName;
    private String email;
    private String phone;
    private Gender gender;
    private int levelSalary;
    private double salary;
    private LocalDate dob;
    private String address;
    private int departmentId;
    private EmployeeStatus status;

    public Employee() {
    }

    public Employee(String employeeId, String employeeName, String email, String phone, int levelSalary, Gender gender, double salary, String address, LocalDate dob, int departmentId, EmployeeStatus status) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.email = email;
        this.phone = phone;
        this.levelSalary = levelSalary;
        this.gender = gender;
        this.salary = salary;
        this.address = address;
        this.dob = dob;
        this.departmentId = departmentId;
        this.status = status;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getLevelSalary() {
        return levelSalary;
    }

    public void setLevelSalary(int levelSalary) {
        this.levelSalary = levelSalary;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public int getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }

    public EmployeeStatus getStatus() {
        return status;
    }

    public void setStatus(EmployeeStatus status) {
        this.status = status;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
