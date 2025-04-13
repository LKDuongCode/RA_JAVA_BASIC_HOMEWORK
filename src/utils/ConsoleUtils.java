package utils;

import java.util.Scanner;

public class ConsoleUtils {
    public static void exitProgram (Scanner sc){
        System.out.println("\u001B[34m thoát chương trình... \u001B[0m");
        sc.close();
        System.exit(0);
    }

    public static boolean logout (Scanner sc){
        boolean notLogout = true;

        while (true){
            System.out.println("\u001B[31m bạn có chắc muốn đăng xuất? (y/n)\u001B[0m");
            String choice = ValidateInput.validateString(sc,"lựa chọn ", 1,1).toLowerCase();
            if(choice.equals("y")){
                notLogout = false;
                break;
            } else if (choice.equals("n")) {
                notLogout = true;
                break;
            }else{
                System.out.println("\u001B[31m không hợp lệ! \u001B[0m");
            }
        }

        return notLogout;
    }

    public static void printLoginMenu (){
        System.out.println("ỨNG DỤNG QUẢN LÍ THÔNG TIN - chào mừng bạn.");
        System.out.println("1. Đăng nhập");
        System.out.println("0. Thoát.");
        System.out.println("Bạn chọn?");
    }

    public static void printMainMenu (){
        System.out.println("MENU CHÍNH ====");
        System.out.println("1. quản lí phòng ban.");
        System.out.println("2. quản lí nhân viên.");
        System.out.println("3. thống kê số liệu.");
        System.out.println("4. đăng xuất.");
        System.out.println("0. thoát.");
        System.out.println("Bạn chọn?");
    }

    public static void printDepartmentMenu (){
        System.out.println("QUẢN LÍ PHÒNG BAN ==== ");
        System.out.println("1. hiển thị danh sách phòng ban.");
        System.out.println("2. thêm mới phòng ban");
        System.out.println("3. cập nhật phòng ban");
        System.out.println("4. xóa phòng ban.");
        System.out.println("5. tìm kiếm phòng ban theo tên.");
        System.out.println("0. quay lại.");
        System.out.println("bạn chọn?");
    }

    public static void printEmployeeMenu() {
        System.out.println("\n==================== QUẢN LÝ NHÂN VIÊN ====================");
        System.out.println("1. Danh sách nhân viên (phân trang, mỗi trang 10 nhân viên)");
        System.out.println("2. Thêm nhân viên (chỉ thêm vào phòng ban đang hoạt động)");
        System.out.println("3. Cập nhật thông tin nhân viên");
        System.out.println("4. Xoá nhân viên (chuyển trạng thái thành INACTIVE)");
        System.out.println("5. Tìm kiếm nhân viên theo tên và khoảng tuổi");
        System.out.println("0. Quay lại menu chính");
        System.out.print("Chọn chức năng: ");
    }

}
