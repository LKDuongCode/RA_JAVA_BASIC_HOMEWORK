import java.util.*;
import java.util.stream.Stream;

public class Hw08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập mảng số nguyên cách nahu bởi dấu cách:");
        String inputNumbers = sc.nextLine();
        inputNumbers.trim();



        ArrayList<Integer> numbers = toIntegerArray(inputNumbers);
        System.out.println(numbers);
        System.out.println("tổng cần tìm k = ");
        int k = Integer.parseInt(sc.nextLine());

        System.out.println("các cặp số");
        System.out.println(calNumCouple(numbers,k));

    }

    static ArrayList<Integer> toIntegerArray (String str) {
        String[] strArray = str.split("\\W+");
        ArrayList<Integer> result = new ArrayList<>();
        for (String element : strArray){
            result.add(Integer.parseInt(element));
        }
        return result;

    }

    // method tính các tổng khớp và trả về
    static ArrayList<String> calNumCouple (ArrayList<Integer> numbers, int k){
        ArrayList<String> result = new ArrayList<>();

        for (int i = 0; i < numbers.size() - 1; i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (numbers.get(i) + numbers.get(j) == k) {
                    String couple = "(" + numbers.get(i) + "," + numbers.get(j) + ")";
                    result.add(couple);
                }
            }
        }


        return result;
    }
}
