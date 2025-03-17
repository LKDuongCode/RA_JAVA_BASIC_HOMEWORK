package hw10;

public class DebitCard extends PaymentMethod{
    public DebitCard (double amount){
        super(amount);
    }

    @Override
    public double processPayment(){
        return this.amount + calculateFee();
    };

    @Override
    public double calculateFee(){
        return this.amount*(1/100);

    };

    public String processPayment( String currency){
        return  String.format("%.2f %s", this.amount, currency);
    };
}
