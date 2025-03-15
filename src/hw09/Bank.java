package hw09;

public class Bank {
    private BankAccount[] accounts;
    private int count;

    public Bank() {
        accounts = new BankAccount[10];
        count = 0;
    }

    public void addAccount(BankAccount account) {
        if (count < accounts.length) {
            accounts[count] = account;
            count++;
            System.out.println("Đã thêm tài khoản: " + account.accountNumber);
        } else {
            System.out.println("Ngân hàng đã đầy");
        }
    }

    public void displayBalance() {
        System.out.println("\ntài khoản");
        for (int i = 0; i < count; i++) {
            accounts[i].displayBalance();
        }
    }
}
