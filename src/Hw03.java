import java.util.LinkedHashMap;
import java.util.Map;

public class Hw03 {
    public static void main(String[] args) {
        Map<String,Double> products = new LinkedHashMap<>();
        products.put("phone",100.0);
        products.put("laptop",500.0);
        products.put("pc",300.0);
        products.put("ipad",100.0);
        products.put("gg",10000.0);

        displayAll(products);
//        products.put("laptop", 800.0); //đè
//        products.replace("laptop",800.0);
        products.replace("laptop",500.0,800.0);

        //có thể dùng iterator khi chuyển nó về dạng set để xóa
        products.remove("pc");
        displayAll(products);
    }

    public static <K,V> void displayAll (Map<K,V> maps){
        for (Map.Entry<K,V> entry : maps.entrySet()){
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
