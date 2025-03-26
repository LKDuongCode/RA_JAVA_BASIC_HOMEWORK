package hw03;

public class MathOperations {
    static int add (int a, int b) {
        return a + b;
    };

    static int subtract(int a, int b){
        return a-b;
    }

    static int multiply (int a,  int b){
        return a*b;
    }

    static double divide (int a, int b){
        if(b == 0){
            System.out.println("không thể chia cho 0");
            return 0;
        }
        return  (double) a/b;
    }

}
