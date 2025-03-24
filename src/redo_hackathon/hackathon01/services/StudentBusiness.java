package redo_hackathon.hackathon01.services;

import redo_hackathon.hackathon01.entity.Student;
import redo_hackathon.myHackathon.entity.Customer;
import redo_hackathon.myHackathon.services.CustomerValidator;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class StudentBusiness {
    public static Set<Student> students = new HashSet<>();

    public static void printMainMenu (){
        System.out.println("----------------------------Student Menu----------------------------");
        System.out.println("1. Hiển thị danh sách sinh viên");
        System.out.println("2. Thêm mới sinh viên");
        System.out.println("3. Chỉnh sửa thông tin sinh viên");
        System.out.println("4. Xóa sinh viên");
        System.out.println("5. Tìm kiếm sinh viên");
        System.out.println("6. Sắp xếp");
        System.out.println("0. Thoát chương trình");
        System.out.println("--------------------------------------------------------------------------");
    }

    public static void displayStudent() {
        if (students.size() == 0) {
            System.out.println("Danh sách trống");
        }else {
            for (Student student : students) {
                System.out.println("----------------");
                student.displayData();
                System.out.println("---------------------");
            }
        }
    }

    public static void addStudent(Scanner sc) {

        System.out.println("Nhập số student cần thêm:");
        int nums = Integer.parseInt(sc.nextLine());

        if(nums <= 0){
            System.out.println("Số lượng không hợp lệ!");
        }else{
            for (int i = 0; i < nums; i++) {

                System.out.println("Nhập mã:");
                String id = Validator.validateId(sc);

                String name = Validator.validateInputString(sc, "Nhập tên:", 1, 50,"Tên không hợp lệ");

                System.out.println("Nhập ngày sinh (dd/MM/yyyy):");
                String dateOfBirth =Validator.validateDate(sc);

                System.out.println("Nhập giới tính (true - Nam| false - Nữ):");
                boolean gender = Validator.validateGender(sc);

                String major = Validator.validateInputString(sc, "Nhập ngành:", 1, 50, "ngành không hợp lệ");

                System.out.println("Nhập email:");
                String email = Validator.validateEmail(sc);

                System.out.println("Nhập số điện thoại:");
                String phone = Validator.validatePhoneNumber(sc);

                String className = Validator.validateInputString(sc, "Nhập classname:", 1, 50, "classname không hợp lệ.");

                System.out.println("nhập gpa: ");
                float gpa = Validator.validateGPA(sc);

                System.out.println("nhập status: ");
                byte status = Validator.validateStatus(sc);

                Student newStudent = new Student(id,name,dateOfBirth,gender,phone,email,major,className,gpa,status);
                StudentBusiness.students.add(newStudent);
            }
            System.out.println("Thêm thành công!");
        }
    }


    public static void updateStudent(Scanner sc) {
        if (StudentBusiness.students.size() == 0) {
            System.out.println("Danh sách khách hàng trống");
            return;
        }

        String id = sc.nextLine();

        for (Student student : StudentBusiness.students) {
            if (student.getStudentId().equals(id)) {
                while (true) {
                    System.out.println("\nChỉnh sửa thông tin sinh viên -----");
                    System.out.println("1. Tên: " + student.getStudentName());
                    System.out.println("2. Ngày sinh: " + student.getBirthday());
                    System.out.println("3. Giới tính: " + (student.isGender() ? "Nam" : "Nữ"));
                    System.out.println("4. Điện thoại: " + student.getPhoneNumber());
                    System.out.println("5. Email: " + student.getEmail());
                    System.out.println("6. Chuyên ngành: " + student.getMajor());
                    System.out.println("7. Lớp: " + student.getClassName());
                    System.out.println("8. GPA: " + student.getGpa());
                    System.out.println("9. Trạng thái: " + (student.getStatus() == 1 ? "Active" : "Inactive"));
                    System.out.println("0. Quay lại menu chính ");
                    System.out.print("Chọn thông tin cần sửa: ");

                    int choice = Integer.parseInt(sc.nextLine());

                    switch (choice) {
                        case 1:
                            String name = Validator.validateInputString(sc, "Nhập tên:", 1, 50,"Tên không hợp lệ");
                            student.setStudentName(name);
                            break;
                        case 2:
                            System.out.println("Nhập ngày sinh (dd/MM/yyyy):");
                            String dateOfBirth = Validator.validateDate(sc);
                            student.setBirthday(dateOfBirth);
                            break;
                        case 3:
                            System.out.println("Nhập giới tính (true - Nam| false - Nữ):");
                            boolean gender = Validator.validateGender(sc);
                            student.setGender(gender);
                            break;
                        case 4:
                            System.out.println("Nhập số điện thoại:");
                            String phone = Validator.validatePhoneNumber(sc);
                            student.setPhoneNumber(phone);
                            break;
                        case 5:
                            System.out.println("Nhập email:");
                            String email = Validator.validateEmail(sc);
                            student.setEmail(email);
                            break;
                        case 6:
                            String major = Validator.validateInputString(sc, "Nhập ngành:", 1, 50, "ngành không hợp lệ");
                            student.setMajor(major);
                            break;
                        case 7:
                            String className = Validator.validateInputString(sc, "Nhập classname:", 1, 50, "classname không hợp lệ.");
                            student.setClassName(className);
                            break;
                        case 8:
                            System.out.println("nhập gpa: ");
                            float gpa = Validator.validateGPA(sc);
                            student.setGpa(gpa);
                            break;
                        case 9:
                            System.out.println("nhập status: ");
                            byte status = Validator.validateStatus(sc);
                            student.setStatus(status);
                            break;
                        case 0:
                            System.out.println("Quay lại.");
                            return;
                        default:
                            System.out.println("Lựa chọn không hợp lệ");
                    }

                }
            }
        }
        System.out.println("Không tìm thấy khách hàng!");
    }


    public static void deleteStudentById(Scanner sc) {
        String id = sc.nextLine();
        Iterator<Student> it = StudentBusiness.students.iterator();
        while (it.hasNext()) {
            Student student = it.next();

            if (student.getStudentId().equals(id)) {
                student.displayData();

                System.out.print("Bạn có chắc chắn muốn xóa? (Y/N): ");
                String confirm = sc.nextLine().trim().toUpperCase();

                if (confirm.equals("Y")) {
                    it.remove();
                    System.out.println("Xóa thành công!");
                } else {
                    System.out.println("Đã hủy xóa sinh viên.");
                }
                return;
            }
        }

        System.out.println("Không tìm thấy sinh viên với ID: " + id);
    }



}
