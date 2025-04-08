package presentation;

import utils.ConsoleUtils;
import utils.InputUtils;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            ConsoleUtils.printMainMenu();
            System.out.print("Chọn chức năng: ");
            int choice = InputUtils.validateInt(sc);

            switch (choice) {
                case 1:
                    new CourseMenu().handle(sc);
                    break;
                case 2:
                    new TeacherMenu().handle(sc);
                    break;
                case 3:
                    new StudentMenu().handle(sc);
                    break;
                case 4:
                    new CourseRegistrationMenu().handle(sc);
                    break;
                case 5:
                    new ClassroomMenu().handle(sc);
                    break;
                case 6:
                    new DashboardMenu().handle(sc);
                    break;
                case 7:
                    exit = true;
                    System.out.println("Hẹn gặp lại! Kết thúc chương trình.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
            }

            System.out.println("\n");
        }
    }
}
