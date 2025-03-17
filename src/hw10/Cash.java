package hw10;

public class Cash extends PaymentMethod{
    public Cash (double amount){
        super(amount);
    }

    @Override
    public double processPayment(){
        return this.amount + calculateFee();
    };

    @Override
    public double calculateFee(){
        return 0;
    };

    public String processPayment(String currency){
        return  String.format("%.2f %s", this.amount, currency);
    };
}
