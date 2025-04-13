package presentaition;

import utils.ConsoleUtils;
import utils.EmployeeUtils;
import utils.ValidateInput;

import java.util.Scanner;

public class EmployeeUI {
    private final EmployeeUtils eu = new EmployeeUtils();

    public void handle(Scanner sc) {
        boolean back = false;

        while (!back) {
            ConsoleUtils.printEmployeeMenu();

            int choice = ValidateInput.validateInt(sc);

            switch (choice) {
                case 1:
                    eu.printAllEmployees(sc);
                    break;
                case 2:
                    eu.insertEmployee(sc);
                    break;
                case 3:
                    eu.updateEmployee(sc);
                    break;
                case 4:
                    eu.deleteEmployee(sc);
                    break;
                case 5:
                    eu.findEmployeeByNameAndAge(sc);
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
}
