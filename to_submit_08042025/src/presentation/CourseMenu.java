package presentation;

import business.CourseBusiness;
import utils.ConsoleUtils;
import utils.InputUtils;

import java.util.Scanner;

public class CourseMenu {
    private final CourseBusiness courseBusiness = new CourseBusiness();

    public void handle(Scanner sc) {
        boolean back = false;

        while (!back) {
            ConsoleUtils.printCourseMenu();
            System.out.print("Chọn chức năng: ");
            int choice = InputUtils.validateInt(sc);

            switch (choice) {
                case 1:
                    courseBusiness.displayCoursesSortedByName();
                    break;
                case 2:
                    courseBusiness.addNewCourse(sc);
                    break;
                case 3:
                    courseBusiness.updateCourse(sc);
                    break;
                case 4:
                    courseBusiness.deleteCourseById(sc);
                    break;
                case 5:
                    back = true;
                    System.out.println(" Quay lại menu chính.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
            }
        }
    }
}
