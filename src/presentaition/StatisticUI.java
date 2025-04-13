package presentaition;

import utils.StatisticUtils;
import utils.ValidateInput;

import java.util.Scanner;

public class StatisticUI {
    private final StatisticUtils statisticUtils = new StatisticUtils();

    public void handle(Scanner sc) {
        boolean back = false;
        while (!back) {
            printMenu();
            int choice = ValidateInput.validateInt(sc);

            switch (choice) {
                case 1:
                    statisticUtils.printTotalEmployee();
                    break;
                case 2:
                    statisticUtils.printEmployeeCountPerDepartment();
                    break;
                case 3:
                    statisticUtils.printDepartmentWithMostEmployees();
                    break;
                case 4:
                    statisticUtils.printDepartmentWithHighestAvgSalary();
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.err.println("Lựa chọn không hợp lệ.");
                    break;
            }
        }
    }

    private void printMenu() {
        System.out.println("\n========== MENU THỐNG KÊ ==========");
        System.out.println("1. Tổng số nhân viên toàn hệ thống");
        System.out.println("2. Số lượng nhân viên theo từng phòng ban");
        System.out.println("3. Phòng ban có nhiều nhân viên nhất");
        System.out.println("4. Phòng ban có lương trung bình cao nhất");
        System.out.println("0. Quay lại");
        System.out.print("Chọn chức năng: ");
    }
}
