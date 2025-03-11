import java.util.Scanner;

public class Hw08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int n = Integer.parseInt(sc.nextLine());
        if (n < 1 || n > 1000){
            System.out.println("n không hợp lệ ");
        }else{
            StringBuilder randomString = new StringBuilder();
            for (int i = 0; i < n; i++) {
                int ctype = (int) (Math.random() * 3); 

                char rdChar;
                if (ctype == 0) {
                    rdChar = (char) ('A' + (int) (Math.random() * 26)); 
                } else if (ctype == 1) {
                    rdChar = (char) ('a' + (int) (Math.random() * 26)); 
                } else {
                    rdChar = (char) ('0' + (int) (Math.random() * 10)); 
                }

                randomString.append(rdChar);
            }
            
            System.out.println("result : " + randomString);
        }
    }
}
