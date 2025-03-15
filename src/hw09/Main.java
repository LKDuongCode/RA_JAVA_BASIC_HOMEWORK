package hw09;

public class Main {
    public static void main(String[] args) {
        Bank myBank = new Bank();

        SavingAccount savingAcc = new SavingAccount("12345", 500);
        CheckingAccount checkingAcc = new CheckingAccount("67890", 1000);

        myBank.addAccount(savingAcc);
        myBank.addAccount(checkingAcc);

        savingAcc.deposit(200);
        savingAcc.withdraw(800);
        savingAcc.withdraw(400);

        checkingAcc.withdraw(1500);
        checkingAcc.deposit(500);

        myBank.displayBalance();
    }
}
