import java.util.Scanner;

public class Practice02 {
    // todo: thực hành trên lớp mảng nhiều chiều 
    public static void main(String[] args) {
        /*
        1. khai báo mảng số nguyên 2 chiều n,m được nhập 
        2. in menu và thực hiện chức năng theo menu
            1. nhập giá trị các phần tử của mảng
            2. in giá trị các phần tử trong mảng
            3. kiểm tra sự tồn tại của một giá trị trong mảng  
        */
        Scanner sc = new Scanner(System.in);
        System.out.println("n = ");
        int n = Integer.parseInt(sc.nextLine());
        System.out.println("m = ");
        int m = Integer.parseInt(sc.nextLine());
        
        int[][] arr = new int[n][m];
        do {
            System.out.println("----------------------MENU----------------------");
            System.out.println("1. Nhập giá trị các phần tử của mảng");
            System.out.println("2. In giá trị các phần tử của mảng theo ma trận");
            System.out.println("3. Kiem tra sự tồn tại của 1 giá tri trong mảng");
            System.out.println("4. Thoát");
            System.out.println("Lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());
            
            switch (choice){
                case 1:
                    for (int i = 0; i < arr.length; i++) {
                        for (int j = 0; j < arr[i].length; j++) {
                            System.out.printf("number[%d][%d] = ", i, j);
                            arr[i][j] = sc.nextInt();
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < arr.length; i++) {
                        for (int j = 0; j < arr[i].length; j++) {
                            System.out.printf("%5d", arr[i][j]);
                        }
                        System.out.println();
                    }
                    break;
                case 3:
                    boolean found = false;
                    System.out.println("số cần tìm = ");
                    int searchValue = Integer.parseInt(sc.nextLine());
                    
                    for(int i = 0; i < arr.length; i++) {
                        
                    }
                    
                    if(!found){
                        System.out.println("không thấy");
                    }
                case 4:
                    System.out.println("thoát chương trình.");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("không hợp lệ");
                    break;
            }
        }while(true);
    }
}
