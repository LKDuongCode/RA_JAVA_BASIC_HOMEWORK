package hw10;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Student[] students = new Student[100];
        int count = 0;

        int choice;
        do {
            System.out.println("\n===== MENU QUẢN LÝ SINH VIÊN =====");
            System.out.println("1. Hiển thị danh sách tất cả sinh viên");
            System.out.println("2. Thêm mới sinh viên");
            System.out.println("3. Sửa thông tin sinh viên");
            System.out.println("4. Xóa sinh viên");
            System.out.println("5. Thoát");
            System.out.print("Chọn chức năng: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    if (count == 0) {
                        System.out.println("Danh sách sinh viên trống!");
                    } else {
                        System.out.println("\n===== DANH SÁCH SINH VIÊN =====");
                        for (int i = 0; i < count; i++) {
                            students[i].displayData();
                        }
                    }
                    break;

                case 2:
                    if (count >= students.length) {
                        System.out.println("Danh sách sinh viên đã đầy!");
                    } else {
                        Student newStudent = new Student();
                        newStudent.inputData();
                        students[count++] = newStudent;
                        System.out.println("Thêm sinh viên thành công!");
                    }
                    break;

                case 3:
                    System.out.print("Nhập mã sinh viên cần sửa: ");
                    int idUpdate = Integer.parseInt(sc.nextLine());

                    boolean foundUpdate = false;
                    for (int i = 0; i < count; i++) {
                        if (students[i].id == idUpdate) {
                            foundUpdate = true;
                            System.out.println("Nhập thông tin mới cho sinh viên (Mã SV: " + idUpdate + ")");
                            students[i].inputData();
                            System.out.println("Cập nhật thông tin thành công!");
                            break;
                        }
                    }
                    if (!foundUpdate) {
                        System.out.println("Không tìm thấy sinh viên với mã " + idUpdate);
                    }
                    break;

                case 4:
                    System.out.print("Nhập mã sinh viên cần xóa: ");
                    int idDelete = Integer.parseInt(sc.nextLine());

                    boolean foundDelete = false;
                    for (int i = 0; i < count; i++) {
                        if (students[i].id == idDelete) {
                            foundDelete = true;
                            for (int j = i; j < count - 1; j++) {
                                students[j] = students[j + 1];
                            }
                            students[--count] = null;
                            System.out.println("Xóa sinh viên thành công!");
                            break;
                        }
                    }
                    if (!foundDelete) {
                        System.out.println("Không tìm thấy sinh viên với mã " + idDelete);
                    }
                    break;

                case 5:
                    System.out.println("Thoát chương trình. Tạm biệt!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ, vui lòng chọn lại.");
            }
        } while (choice != 5);

        sc.close();
    }
}
