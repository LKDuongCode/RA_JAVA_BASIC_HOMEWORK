import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Hw02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Set<String> langs = new HashSet<>(Arrays.asList("Java", "Python", "C++", "JavaScript"));

        System.out.print("chuỗi kiểm tra: ");
        String containString = sc.nextLine();

        if(langs.contains(containString)){
            System.out.println("already exist");
        }else {
            System.out.println("not exist");
        }
    }
}
