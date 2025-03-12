package hw08;

public class Main {
    public static void main(String[] args) {
        BankAccount accSt = new BankAccount("123","John Cena",100);
        BankAccount accNd = new BankAccount("456","Duong",3000);

        // nạp tiền
        accSt.deposit(200);
        accSt.display();

        // rút tiền
        accNd.withdraw(500);
        accNd.display();

        //chuyển tiền
        accNd.transfer(accSt,1000);
        accNd.display();
        accSt.display();


    }
}
