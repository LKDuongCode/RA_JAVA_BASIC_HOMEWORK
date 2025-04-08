package presentation;

import business.ClassroomBusiness;
import business.ScheduleBusiness;
import utils.ConsoleUtils;
import utils.InputUtils;

import java.util.Scanner;

public class ClassroomMenu {
    private final ClassroomBusiness classroomBusiness = new ClassroomBusiness();

    public void handle(Scanner sc) {
        boolean back = false;

        while (!back) {
            ConsoleUtils.printClassroomMenu();
            System.out.print("Chọn chức năng: ");
            int choice = InputUtils.validateInt(sc);

            switch (choice) {
                case 1:
                    classroomBusiness.displayClassroomsSortedByCreatedDate();
                    break;
                case 2:
                    classroomBusiness.addNewClassroom(sc);
                    break;
                case 3:
                    classroomBusiness.updateClassroom(sc);
                    break;
                case 4:
                    classroomBusiness.deleteClassroom(sc);
                    break;
                case 5:
                    classroomBusiness.assignTeacherToClassroom(sc);
                    break;
                case 6:
                    classroomBusiness.addStudentToClassroom(sc);
                    break;
                case 7:
                    new ScheduleBusiness().addSchedule(sc);
                    break;
                case 8:
                    classroomBusiness.changeClassroomStatus(sc);
                    break;
                case 9:
                    back = true;
                    System.out.println("Quay lại menu chính.");
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng nhập lại.");
            }
        }
    }
}