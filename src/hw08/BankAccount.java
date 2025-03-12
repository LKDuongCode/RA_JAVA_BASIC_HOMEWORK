package hw08;

public class BankAccount {
    String accNumber;
    String accHolder;
    double balance;

    public BankAccount (String accNumber, String accHolder, double balance){
        this.accHolder = accHolder;
        this.accNumber = accNumber;
        this.balance = balance;
    }

    public void deposit (double amount){
        if(amount > 0){
            this.balance += amount;
        }
    }

    public boolean isValid (double amount){
        if(amount > this.balance){
            return false;
        }else if (amount <= 0){
            return false;
        }else return true;
    }

    public void withdraw (double amount){
            if (isValid(amount)) {
                this.balance -= amount;
            } else {
                System.out.println("số dư không đủ hoặc số tiền nhập vào không hopej lệ ");
            }
    }

    public void transfer (BankAccount recipinent, double amount){
        if (isValid(amount)){
            // trừ tiền tài khoản
            this.balance -= amount;
            // thêm tiền
            recipinent.balance += amount;
        }else {
            System.out.println("số dư không đủ hoặc số tiền nhập vào không hopej lệ ");
        }
    }

    public  void display (){
        System.out.println("thông tin tài khoản:");
        System.out.println("accNumber: " + this.accNumber);
        System.out.println("accHolder: " + this.accHolder);
        System.out.println("balance: " + this.balance);
    }
}
