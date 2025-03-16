package hw10;

public class Company {
     Employee[] employees;
     int count;

    public Company(int capacity) {
        employees = new Employee[capacity];
        count = 0;
    }

    public void addEmployee(Employee e) {
        if (count < employees.length) {
            employees[count] = e;
            count++;
            System.out.println("Đã thêm nhân viên: " + e.name);
        } else {
            System.out.println("full.");
        }
    }

    public void startMeeting() {
        System.out.println("\ntổ chức cuộc họp");
        for (int i = 0; i < count; i++) {
            if (employees[i] instanceof AttendMeeting) {
                ((AttendMeeting) employees[i]).attendMeeting();
            }
        }
    }
}
