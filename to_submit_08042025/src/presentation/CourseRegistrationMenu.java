package presentation;

import business.CourseRegistrationBusiness;
import utils.ConsoleUtils;
import utils.InputUtils;

import java.util.Scanner;

public class CourseRegistrationMenu {
    private final CourseRegistrationBusiness registrationBusiness = new CourseRegistrationBusiness();

    public void handle(Scanner sc) {
        boolean back = false;

        while (!back) {
            ConsoleUtils.printCourseRegistrationMenu();
            System.out.print("Chọn chức năng: ");
            int choice = InputUtils.validateInt(sc);

            switch (choice) {
                case 1:
                    registrationBusiness.registerCourse(sc);
                    break;
                case 2:
                    registrationBusiness.cancelPendingRegistration(sc);
                    break;
                case 3:
                    registrationBusiness.approveRegistration(sc);
                    break;
                case 4:
                    registrationBusiness.viewRegistrationsByCourse(sc);
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