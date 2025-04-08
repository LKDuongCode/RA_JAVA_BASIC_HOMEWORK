package presentation;

import business.StudentBusiness;
import utils.ConsoleUtils;
import utils.InputUtils;

import java.util.Scanner;

public class StudentMenu {
    private final StudentBusiness studentBusiness = new StudentBusiness();

    public void handle(Scanner sc) {
        boolean back = false;

        while (!back) {
            ConsoleUtils.printStudentMenu();
            System.out.print("Chọn chức năng: ");
            int choice = InputUtils.validateInt(sc);

            switch (choice) {
                case 1:
                    studentBusiness.displayStudentsSortedByName();
                    break;
                case 2:
                    studentBusiness.addNewStudent(sc);
                    break;
                case 3:
                    studentBusiness.updateStudent(sc);
                    break;
                case 4:
                    studentBusiness.deleteStudent(sc);
                    break;
                case 5:
                    back = true;
                    System.out.println("Quay lại menu chính.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng thử lại.");
            }
        }
    }
}