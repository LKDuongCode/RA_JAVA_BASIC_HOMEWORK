package hw07;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(Arrays.asList(5, -2, 10, 0, -7, 3));

        ListProcessor runing = new ListProcessorImpl();
        if(runing.containsNegative(numbers)){
            System.out.println("có số âm");
        }else {
            System.out.println("không có số âm");
        }

        ListProcessor.printList(numbers);
    }
}
