package hw08;

public class Product {
    String name;
    double price;

    public Product (String name, double price){
        this.name = name;
        this.price = price;
    }

    public double getDiscount (){
        return 0;
    }

    public double getFinalPrice (){
        return this.price - (this.price * getDiscount() / 100);
    }

    public double getDiscount (int quantity){
        if (quantity > 100){
            return 5;
        }else if (quantity <= 100 && quantity > 0){
            return 0;
        }else {
            throw new IllegalArgumentException("số lượng không hợp lệ ");
        }
    }

    public double getFinalPrice (int quantity){
        return this.price - (this.price * getDiscount(quantity) / 100);
    }
}
