package business.model.account;

import utils.ValidateInput;

import java.util.Scanner;

public class Account{
    private String username;
    private String password;
    private boolean status;

    public Account() {
    }

    public Account(String username, String password, boolean status) {
        this.username = username;
        this.password = password;
        this.status = status;
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void inputAcocunt(Scanner sc) {
        System.out.print("nhập username: ");
        String username = ValidateInput.validateString(sc,"username",3,50);
        setUsername(username);

        System.out.print("nhập password: ");
        String password = ValidateInput.validateString(sc,"password",1,50);
        setPassword(password);
    }

    public void inputForCreateAccount (Scanner sc, boolean defaultStatus){
        inputAcocunt(sc);
        setStatus(defaultStatus);
    }
}
