package hw08;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, 2, 10, 1, 7, 3));
        List<Integer> odds = new ArrayList<>();
        ListProcessor runing = new ListProcessorImpl();

        for (int num : numbers){
            if(num % 2 != 0){
                odds.add(num);
            }
        }

        if(!runing.checkOdd(numbers)){
            System.out.println("không có phần tử lẻ");
        }else {
            System.out.println("sum = " + runing.sumOddNumbers(numbers));
            ListProcessor.printList(odds);
        }
    }
}
