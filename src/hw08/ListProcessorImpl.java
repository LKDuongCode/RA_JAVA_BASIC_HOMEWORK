package hw08;

import java.util.List;

public class ListProcessorImpl implements ListProcessor{
    @Override
    public int sumOddNumbers(List<Integer> nums){
        int sum = 0;
        for(int num : nums){
            if(num % 2 != 0){
                sum += num;
            }
        }
        return sum;
    }



}
