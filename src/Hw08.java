import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Hw08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập n:");
        int n = validateN(sc);


        Map<Integer, String> romans = new LinkedHashMap<>();
        romans.put(1000, "M");
        romans.put(900,"CM");
        romans.put(500,"D");
        romans.put(400,"CD");
        romans.put(100,"C");
        romans.put(90,"XC");
        romans.put(50,"L");
        romans.put(40,"XL");
        romans.put(10,"X");
        romans.put(9,"IX");
        romans.put(5,"V");
        romans.put(4,"IV");
        romans.put(1,"I");

        toRoman(romans,n);
    }
    
    static int validateN (Scanner sc){
        while (true){
            int n;
            try{
                n = Integer.parseInt(sc.nextLine());
            }catch (NumberFormatException e){
                System.out.println("không phải số nguyên.");
                continue;
            }

            if(n < 1 || n > 3999 ){
                System.out.println("giá trị không hợp lệ.");
                continue;
            }

            return n;
        }
    }

    static void toRoman (Map<Integer,String> romans, int number){
        StringBuilder result = new StringBuilder();
        for (Map.Entry<Integer, String> entry : romans.entrySet()) {
            while (number >= entry.getKey()) {
                result.append(entry.getValue());
                number -= entry.getKey();
            }
        }

        System.out.println(result);
    }
}
