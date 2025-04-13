package presentaition;

import utils.ConsoleUtils;
import utils.DepartmentUtils;
import utils.ValidateInput;

import java.util.Scanner;

public class DepartmentUI {
    private final DepartmentUtils du = new DepartmentUtils();

    public void handle (Scanner sc){
        boolean back = false;

        while (!back){
            ConsoleUtils.printDepartmentMenu();
            int choice = ValidateInput.validateInt(sc);

            switch (choice){
                case 1:
                    du.printAllDepartment(sc);
                    break;
                case 2:
                    du.insertDepartment(sc);
                    break;
                case 3:
                    du.updateDepartment(sc);
                    break;
                case 4:
                    du.deleteDepartment(sc);
                    break;
                case 5:
                    du.findDepartmentByName(sc);
                    break;
                case 0:
                    back = true;
                    break;
                default:
                    System.err.println("lựa chọn không hợp lệ.");
                    break;

            }
        }
    }
}
