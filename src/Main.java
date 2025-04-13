import presentaition.AccountUI;
import presentaition.DepartmentUI;
import presentaition.EmployeeUI;
import presentaition.StatisticUI;
import utils.ConsoleUtils;
import utils.ValidateInput;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isLogin = false;

       while (true){
           while (!isLogin){
               isLogin = new AccountUI().handle(sc);
           }

           do {
               ConsoleUtils.printMainMenu();
               int choice = ValidateInput.validateInt(sc);

               switch (choice){
                   case 1:
                       new DepartmentUI().handle(sc);
                   case 2:
                       new EmployeeUI().handle(sc);
                       break;
                   case 3:
                       new StatisticUI().handle(sc);
                       break;
                   case 4:
                       isLogin = ConsoleUtils.logout(sc);
                       break;
                   case 0:
                       ConsoleUtils.exitProgram(sc);
                   default:
                       System.out.println("\u001B[31m không hợp lệ, hãy chọn lại. \u001B[0m");
                       break;
               }
           }while (isLogin);
       }
    }
}
