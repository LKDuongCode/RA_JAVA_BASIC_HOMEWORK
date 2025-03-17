package hw10;

public class Main {
    public static void main(String[] args) {
        CreditCard creditCard = new CreditCard(1020);
        DebitCard debitCard = new DebitCard(1010);
        Cash cash = new Cash(1000);

        System.out.println("total payment: "+ creditCard.processPayment());
        System.out.println("process payment of " + creditCard.processPayment("USD") + " with total " + creditCard.processPayment() + " USD");
        System.out.println();

        System.out.println("total payment: "+ debitCard.processPayment());
        System.out.println("process payment of " + debitCard.processPayment("EUR") + " with total " + debitCard.processPayment() + " EUR");
        System.out.println();

        System.out.println("total payment: "+ cash.processPayment());
        System.out.println("process payment of " + cash.processPayment("JPY") + " with total " + cash.processPayment() + " JPY");
    }
}
