package presentaition;

import utils.AccountUtils;
import utils.ConsoleUtils;
import utils.ValidateInput;

import java.util.Scanner;

public class AccountUI {
    private final AccountUtils accountUtils = new AccountUtils();

    public boolean handle (Scanner sc){
        boolean back = false;
        while (!back){
            ConsoleUtils.printLoginMenu();

            int choice = ValidateInput.validateInt(sc);

            switch (choice){
                case 1:
                    back = accountUtils.login(sc);
                    break;
                case 2:
                    ConsoleUtils.exitProgram(sc);
                    break;
            }
        }

        return back;
    }
}
