import java.util.Scanner;

public class Homework05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("n = ");
        int n = Integer.parseInt(sc.nextLine());

        if(n < 2){
            System.out.println("Không có số hoàn hảo nhỏ hơn");
            System.exit(0);
        }

        int found = 0;
        // duyệt các số từ 2 đến < n
        for (int i = 2; i<n ; i++){
            // tính tổng ước với mỗi i
            int sum = 1;
            for(int j=2; j<= i/2; j++){
                if(i%j == 0){
                    sum += j;
                }
            }

            if (sum == i) {
                System.out.print(i + " ");
                found = 1;
            }
        }

        if(found == 0){
            System.out.println("không thấy");
        }
        sc.close();
    }
}
