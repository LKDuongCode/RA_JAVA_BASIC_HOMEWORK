package hw10;

public class CreditCard extends PaymentMethod{
    public CreditCard (double amount){
        super(amount);
    }

    @Override
    public double processPayment(){
        return this.amount + calculateFee();
    };

    @Override
    public double calculateFee(){
        return this.amount*(2/100);
    };

    public String processPayment(String currency){
        return  String.format("%.2f %s", this.amount, currency);

    };
}
