package homeworks_28_3_exceptions.Hw09;

import java.util.Optional;

public class BankAccount {
    private String accountID;
    private double balance;

    public BankAccount() {
    }

    public BankAccount(String accountID, double balance) {
        this.accountID = accountID;
        this.balance = balance;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public String getAccountID() {
        return accountID;
    }

    public void setAccountID(String accountID) {
        this.accountID = accountID;
    }

     void deposit (double amount){
        Optional<String> isInValid = Methods.isValidMoney(Main.accounts,this,this, amount);
        if(isInValid.isPresent()){
            throw new IllegalArgumentException(isInValid.get());
        }

        this.setBalance((this.balance)+ amount);
    }

     void withDraw (double amount){
        Optional<String> isInValid = Methods.isValidMoney(Main.accounts,this,this, amount);
        if(isInValid.isPresent()){
            throw new IllegalArgumentException(isInValid.get());
        }

        this.setBalance((this.balance) - amount);
    }

     void transfer (BankAccount receive, double amount){
        Optional<String> isInValid = Methods.isValidMoney(Main.accounts,this,receive, amount);
        if(isInValid.isPresent()){
            throw new IllegalArgumentException(isInValid.get());
        }

        this.setBalance(this.balance - amount);
        receive.setBalance(receive.getBalance() + amount);

    }
}