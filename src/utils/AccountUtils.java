package utils;

import business.model.account.Account;
import business.service.account.AccountService;
import business.service.account.AccountServiceImpl;

import java.util.Scanner;

public class AccountUtils {
    private final AccountService accountService = new AccountServiceImpl();

    public boolean login (Scanner sc){
        Account a = new Account();
        a.inputAcocunt(sc);

        boolean result = accountService.login(a.getUsername(),a.getPassword());

        if(result) {
            System.out.println("\u001B[32m Đăng nhập thành công! \u001B[0m");
            return true;
        }else{
            System.out.println("\u001B[31m tài khoản hoặc mật khẩu bị sai.\u001B[0m");
            return false;
        }
    }
}
