package hw08;

public class Electronic extends Product{
    public Electronic (String name, double price){
        super(name, price);
    }

    @Override
    public double getDiscount (){
        return 10;
    }
}
