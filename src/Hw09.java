import java.util.Scanner;

public class Hw09 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("str : ");
        String str = sc.nextLine();

        if (str.isEmpty()) {
            System.out.println("");
            System.exit(0);
        }
        
        StringBuilder result = new StringBuilder();
        int count = 1;

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == str.charAt(i - 1)) {
                count++;
            } else {
                result.append(str.charAt(i - 1)).append(count);
                count = 1;
            }
        }

        result.append(str.charAt(str.length() - 1)).append(count);

        System.out.println("result = " + result);
    }
}
