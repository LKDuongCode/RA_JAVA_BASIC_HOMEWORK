package presentation;

import business.TeacherBusiness;
import utils.ConsoleUtils;
import utils.InputUtils;

import java.util.Scanner;

public class TeacherMenu {
    private final TeacherBusiness teacherBusiness = new TeacherBusiness();

    public void handle(Scanner sc) {
        boolean back = false;

        while (!back) {
            ConsoleUtils.printTeacherMenu();
            System.out.print("Chọn chức năng: ");
            int choice = InputUtils.validateInt(sc);

            switch (choice) {
                case 1:
                    teacherBusiness.displayTeachersSortedByIdDesc();
                    break;
                case 2:
                    teacherBusiness.addNewTeacher(sc);
                    break;
                case 3:
                    teacherBusiness.updateTeacher(sc);
                    break;
                case 4:
                    teacherBusiness.deleteTeacher(sc);
                    break;
                case 5:
                    back = true;
                    System.out.println("Quay lại menu chính.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
            }
        }
    }
}