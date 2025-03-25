import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class Hw05 {
    public static void main(String[] args) {
        Map<String,Double> products = new HashMap<>();
        products.put("orange",200.0);
        products.put("grapefruit",1000.0);
        products.put("gg",500.0);
        products.put("cafe",400.0);

        Hw03.displayAll(products);

        Map<String,Double> filteredProducts = new TreeMap<>();
        for (Map.Entry<String,Double> entry : products.entrySet()){
            if(entry.getValue() >= 500.0 && entry.getValue() <=1500.0){
                filteredProducts.put(entry.getKey(),entry.getValue());
            }
        }
        System.out.println("mảng sau khi lọc và xếp");
        Hw03.displayAll(filteredProducts);
    }
}
