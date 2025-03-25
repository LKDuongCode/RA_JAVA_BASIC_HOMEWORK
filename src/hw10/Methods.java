package hw10;

import java.util.Collection;
import java.util.Scanner;

public class Methods {
    public static void printMenu (){
        System.out.println("-----menu-----");
        System.out.println("1. thêm nhân viên");
        System.out.println("2. hiển thị danh sách");
        System.out.println("3. tính tổng lương");
        System.out.println("4. tính lương trung bình ");
        System.out.println("5. tìm nhân viên lương cao nhất");
        System.out.println("6. tìm nhân viên lương thấp nhất");
        System.out.println("0. thoát");
        System.out.println("lựa chọn của bạn: ");
    }

    public static void displayAll (){
        if(GlobalData.employees.size() == 0){
            System.out.println("danh sách trống.");
            return;
        }

        System.out.println("danh sách nhân viên.");
        for (Employee e : GlobalData.employees.values()){
            System.out.println("ID " + e.getId() + " | " + "name: " + e.getName() + " | " + "salary:  " + e.getSalary());
        }
    }

    public static void addEmployee (Scanner sc){
        System.out.println("nhập thông tin nhân viên mới.");

        int id = GlobalData.countID++;
        System.out.println("name: ");
        String name = sc.nextLine();

        System.out.println("salary:");
        double salary = Double.parseDouble(sc.nextLine());

        Employee newEmployee = new Employee(id,name,salary);
        GlobalData.employees.put(id,newEmployee);
    }

    public static double calTotalSalary (){
        double totalSalary = 0;

        for (Employee e : GlobalData.employees.values()){
            totalSalary += e.getSalary();
        }
        return totalSalary;
    }

    public static double calAverageSalary (){
        int count = 0;
        for (int key : GlobalData.employees.keySet()){
            count++;
        }

        return calTotalSalary()/count;
    }

    public static void searchEmployee(String mes) {
        if (GlobalData.employees.isEmpty()) {
            System.out.println("Danh sách nhân viên trống.");
            return;
        }

        Collection<Employee> employeeList = GlobalData.employees.values();
        Employee result = null;

        if (mes.equals("high_salary")) {
            double maxSalary = 0;
            for (Employee e : employeeList) {
                if (e.getSalary() > maxSalary) {
                    maxSalary = e.getSalary();
                    result = e;
                }
            }
            System.out.println(result.getName());
        }

        if (mes.equals("low_salary")) {
            double minSalary = Double.MAX_VALUE;
            for (Employee e : employeeList) {
                if (e.getSalary() < minSalary) {
                    minSalary = e.getSalary();
                    result = e;
                }
            }
            System.out.println("📉 Nhân viên có lương thấp nhất:");
            result.display();
        }
    }

}
