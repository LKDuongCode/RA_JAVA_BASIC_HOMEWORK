import java.util.Scanner;
// todo:  thực hành trên lớp mảng 1 chiều
public class Practice01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        /*
            Xây dung ung dung java console
            1. Khai báo và khởi tạo mảng số nguyên 1 chieu gom 100 phan tu
            2. In menu và thực hiện chức năng theom menu
            ----------------------MENU------------------------
            1.Nhap các giá trị mảng
            2. In các giá trị phần tử mảng
            3. Tính tổng các phần tử mảng
            4. In ra các phần tử chia hết cho 3 và tính tổng
            5. In ra các phần tu là số nguyên tố và tính tổng
            6. Thoát
            // Datatype[] arrName = new Datatype[size]
        */

        // Khai báo và khởi tao mảng 1 chiều
        int[] numbers = new int[100];
        int currentIndex = 0;
        do {
            System.out.println("--------------------MENU------------------");
            System.out.println("1. Nhập các giá trị mảng");
            System.out.println("2. In các giá trị phần tu mảng");
            System.out.println("3. Tính tong cac phan tu mang");
            System.out.println("4. In ra các phần tử chia hết cho 3 và tính tổng");
            System.out.println("5. In ra các phần tu là số nguyên tố và tính tổng");
            System.out.println("6. Thoát");
            System.out.print("Lựa chọn của bạn: ");

            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Nhập số phần tử của mảng: ");
                    int n = sc.nextInt();

                    for (int i = 0; i < n; i++) {
                        System.out.printf("number[%d] = ", currentIndex);
                        numbers[currentIndex++] = sc.nextInt();
                    }
                    break;
                case 2:
                    System.out.println("Giá trị các phần tử trong mảng la:");
                    for (int i = 0; i < currentIndex; i++) {
                        System.out.printf("number[%d] = %d\n", i, numbers[i]);
                    }
                    break;
                case 3:
                    int sum = 0;
                    for (int i = 0; i < currentIndex; i++) {
                        sum += numbers[i];
                    }
                    System.out.println("Tổng các phần tử của mảng: " + sum);
                    break;
                case 4:
                    int sum4 = 0;
                    System.out.println("Các phần từ chia hết cho 3:");
                    for (int i : numbers) {
                        if(i % 3 == 0 && i !=0){
                            System.out.printf(" %d ", i);
                            sum4 += i;
                        }
                    }
                    System.out.println("Tổng các phần tử của mảng: " + sum4);
                    break;
                case 5:
                    int sum5 = 0;
                    for(int i = 0 ; i < currentIndex; i++){
                        boolean isPrime = true;
                        if(numbers[i] >= 2){

                            for(int j = 2; j <= Math.sqrt(numbers[i]); j++){
                                if(numbers[i] % j == 0){
                                    isPrime = false;
                                    break;
                                }
                            }

                            if(isPrime){
                                sum5 += numbers[i];
                                System.out.println( numbers[i]);
                            }
                        }
                    }

                    if(sum5 != 0){
                        System.out.println("Tổng các số nguyên tố là: " + sum5);
                    }else {
                        System.out.println("Không có số nguyên tố ");
                    }
                    break;
                case 6:
                    sc.close();
                    System.exit(0);
                default:
                    System.err.println("Vui lòng nhập từ 1 đến 6");
            }
        }while (true);


    }
}