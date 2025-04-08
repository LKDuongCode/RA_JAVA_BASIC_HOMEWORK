package presentation;

import business.DashboardBusiness;
import utils.ConsoleUtils;
import utils.InputUtils;

import java.util.Scanner;

public class DashboardMenu {
    private final DashboardBusiness dashboardBusiness = new DashboardBusiness();

    public void handle(Scanner sc) {
        boolean back = false;

        while (!back) {
            ConsoleUtils.printDashboard();
            System.out.print("Chọn chức năng: ");
            int choice = InputUtils.validateInt(sc);

            switch (choice) {
                case 1:
                    dashboardBusiness.showOverallStats();
                    break;
                case 2:
                    dashboardBusiness.showTopCoursesByRegistration();
                    break;
                case 3:
                    dashboardBusiness.showTopClassroomsByStudents();
                    break;
                case 4:
                    dashboardBusiness.showTopTeachersByStudents();
                    break;
                case 5:
                    dashboardBusiness.showTopStudentsByCourses();
                    break;
                case 6:
                    back = true;
                    System.out.println("Quay lại menu chính.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ.");
            }
        }
    }
}