import java.util.Scanner;

public class Homework02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        // kt số nhập vào
        if(n<2){
            System.out.println("Không phải số nguyên tố");
        }else{
            // đặt flag
            boolean checkingNumber = true;
            for(int i = 2; i <= Math.sqrt(n); i++){
                if(n % i == 0){
                    checkingNumber = false;
                    break;
                }
            }

            if (checkingNumber){
                System.out.println("n là số nguyên tố.");
            }else{
                System.out.println("n không phải số nguyên tố");
            }
        }
        sc.close();
    }
}
