package hw09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>(Arrays.asList(
                new Product("laptop",200.0),
                new Product("phone",50),
                new Product("ipad",70.0),
                new Product("iphone",90.0)
        ));
        ProductProcessor running = new ProductProcessorImpl();

        List<Product> expensiveProducts = new ArrayList<>();
        if(!running.hasExpensiveProduct(products)){
            System.out.println("không có sản phẩm đắt tiền");
        }else {
            for (Product p : products){
                if(p.getPrice() > 100){
                    expensiveProducts.add(p);
                }
            }
            System.out.println("các sản phẩm đắt tiền:");
            ProductProcessor.printProductList(expensiveProducts);
        }

        System.out.println("sum = " + running.calculateTotalValue(products));
        ProductProcessor.printProductList(products);
    }
}
