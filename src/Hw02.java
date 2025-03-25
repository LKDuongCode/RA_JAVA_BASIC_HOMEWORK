import java.util.HashMap;
import java.util.Map;

public class Hw02 {
    public static void main(String[] args) {
        Map<String,Double> products = new HashMap<>() {{
            put("laptop",200.0);
            put("phone",1000.0);
            put("pc",200.0);
        }};

        if(products.containsKey("laptop")){
            System.out.println("tồn tại");
        }else {
            System.out.println("không thấy laptop");
        }

        boolean found = false;

        for (String key : products.keySet()){
            if(products.get(key) == 1000.0){
                System.out.println(key + " - " + products.get(key));
                found = true;
            }
        }

        if(!found){
            System.out.println("không thấy sản phẩm giá 1000");
        }
        
    }
}
