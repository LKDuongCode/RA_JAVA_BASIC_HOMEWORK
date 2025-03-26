package hw09;

import java.util.List;

public interface ProductProcessor {
    double  calculateTotalValue(List<Product> products);
    static void printProductList(List<Product> products){
        products.forEach(p -> System.out.println(p));
    }

    default boolean hasExpensiveProduct(List<Product> products){
        for (Product p : products){
            if(p.getPrice() > 100){
                return true;
            }
        }

        return false;
    }
}
