import java.util.Scanner;

public class Hw07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("str = ");
        String str = sc.nextLine();

        if (str.isEmpty()) {
            System.out.println(str);
            System.exit(0);
        }

        if (str.contains("_")) {
            System.out.println(str);
            System.exit(0);
        }

        StringBuilder snakeCase = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);

            if (Character.isUpperCase(c)) {
                if (i > 0) {
                    snakeCase.append("_");
                }
                snakeCase.append(Character.toLowerCase(c));
            } else {
                snakeCase.append(c);
            }
        }

        System.out.println("str = : " + snakeCase);
    }
}
