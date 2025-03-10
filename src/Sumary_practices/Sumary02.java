package Sumary_practices;

import java.util.Arrays;
import java.util.Scanner;

public class Sumary02 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập n (row): ");
        int n = Integer.parseInt(sc.nextLine());
        System.out.println("Nhập m (col): ");
        int m = Integer.parseInt(sc.nextLine());
        if (n <= 0 || m <= 0){
            System.out.println("Hàng hoặc cột không hợp lệ! ");
            System.exit(0);
        }
        int[][] arr = new int[n][m];

        int choice;
        do {
            System.out.println("----- MENU -----");
            System.out.println("1. Nhập giá trị các phần tử của mảng");
            System.out.println("2. In giá trị các phần tử trong mảng theo ma trận");
            System.out.println("3. Tính số lượng các phần tử chia hết cho 2 và 3 trong mảng");
            System.out.println("4. In các phần tử và tổng các phần tử nằm trên đường biên, đường chéo chính và đường chéo phụ");
            System.out.println("5. Sử dụng thuật toán sắp xếp lựa chọn sắp xếp các phần tử tăng dần theo cột của mảng");
            System.out.println("6. In ra các phần tử là số nguyên tố trong mảng");
            System.out.println("7. Sử dụng thuật toán chèn (Insertion sort) sắp xếp các phần tử trên đường chéo chính của mảng giảm dần");
            System.out.println("8. Nhập giá trị một mảng 1 chiều và chỉ số dòng muốn chèn vào mảng");
            System.out.println("9. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            choice = Integer.parseInt(sc.nextLine());

            switch (choice){
                case 1:
                    System.out.println("Nhập các phần tử của mảng: ");
                    for(int i = 0; i < n; i++) {
                        for(int j = 0; j < m; j++) {
                            System.out.printf("arr[%d][%d] = ",i,j);
                            arr[i][j] = Integer.parseInt(sc.nextLine());
                        }
                    }
                    break;
                case 2:
                    if (n <= 0 || m <= 0){
                        System.out.println("Mảng chưa được khởi tạo!");
                        break;
                    }

                    for (int[] row : arr) {
                        System.out.println(Arrays.toString(row));
                    }
                    break;
                case 3:
                    // tạo biến đếm và duyệt mảng để tìm
                    int count = 0;
                    for(int i = 0; i < n; i++) {
                        for(int j = 0; j < m; j++) {
                            if(arr[i][j] % 2 == 0 && arr[i][j] % 3 == 0){
                                count++;
                            }
                        }
                    }
                    if (count==0){
                        System.out.println("Không thấy phần tử chia hết cho cae 2 và 3 trong mảng.");
                    }else{
                        System.out.println("count = "+ count);
                    }
                    break;
                case 4:
                    int sumDiagonal = 0, sumAntiDiagonal = 0, sumBoundary = 0;

                    System.out.print("Các phần tử trên đường chéo chính: ");
                    for (int i = 0; i < n; i++) {
                        System.out.print(arr[i][i] + " ");
                        sumDiagonal += arr[i][i];
                    }
                    System.out.println("| Sum = " + sumDiagonal);

                    System.out.print("Các phần tử trên đường chéo phụ: ");
                    for (int i = 0; i < n; i++) {
                        System.out.print(arr[i][m - 1 - i] + " ");
                        sumAntiDiagonal += arr[i][m - 1 - i];
                    }
                    System.out.println("| Sum = " + sumAntiDiagonal);

                    System.out.print("Các phần tử trên đường biên: ");
                    for (int i = 0; i < n; i++) {
                        for (int j = 0; j < m; j++) {
                            if (i == 0 || i == n - 1 || j == 0 || j == m - 1) {
                                if (i != j && i + j != m - 1) {
                                    System.out.print(arr[i][j] + " ");
                                    sumBoundary += arr[i][j];
                                }
                            }
                        }
                    }
                    System.out.println("| Sum = " + sumBoundary);
                    break;

                case 5:
                    // duyệt từng cột
                    for (int j = 0; j < m; j++) {
                        // duyệt từng hàng trong cột
                        for (int i = 0; i < n - 1; i++) {
                            int minIdx = i;

                            // Tìm phần tử nhỏ nhất trong phần chưa sắp xếp của cột và đẩy nó lên đầu
                            for (int k = i + 1; k < n; k++) {
                                if (arr[k][j] < arr[minIdx][j]) {
                                    minIdx = k;
                                }
                            }

                            if (minIdx != i) {
                                int temp = arr[i][j];
                                arr[i][j] = arr[minIdx][j];
                                arr[minIdx][j] = temp;
                            }
                        }
                    }
                    break;
                case 6:
                    System.out.println("Các số nguyên tố trong mảng: ");
                    for (int[] row : arr) {
                        for (int num : row) {
                            if (num > 1) {
                                boolean isPrime = true;

                                for (int i = 2; i * i <= num; i++) {
                                    if (num % i == 0) {
                                        isPrime = false;
                                        break;
                                    }
                                }
                                if (isPrime) {
                                    System.out.print(num + " ");
                                }
                            }
                        }
                    }
                    break;
                case 7:
                    int size = Math.min(n, m);

                    //tạo mảng lưu giá trị đường chéo chính
                    int[] diagonal = new int[size];
                    for (int i = 0; i < size; i++) {
                        diagonal[i] = arr[i][i];
                    }
                    // sort desc
                    for (int i = 1; i < size; i++) {
                        int key = diagonal[i];
                        int j = i - 1;
                        while (j >= 0 && diagonal[j] < key) {
                            diagonal[j + 1] = diagonal[j];
                            j--;
                        }
                        diagonal[j + 1] = key;
                    }

                    // gán lại vào
                    for (int i = 0; i < size; i++) {
                        arr[i][i] = diagonal[i];
                    }
                    break;
                case 8:
                    System.out.print("Nhập s = ");
                    int s = Integer.parseInt(sc.nextLine());
                    int[] oneDArray = new int[s];

                    for (int i = 0; i < m; i++) {
                        oneDArray[i] = Integer.parseInt(sc.nextLine());
                    }

                    System.out.print("Nhập chỉ số dòng muốn chèn vào: ");
                    int rowIndex = Integer.parseInt(sc.nextLine());

                    // Kiểm tra chỉ số dòng hợp lệ
                    if (rowIndex >= 0 && rowIndex < n) {
                        int maxCols = Math.min(m, m);

                        for (int i = 0; i < maxCols; i++) {
                            arr[rowIndex][i] = oneDArray[i];
                        }
                    } else {
                        System.out.println("Chỉ số dòng không hợp lệ.");
                    }
                    break;
                case 9:
                    System.out.println("Thoát chương trình!");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Không hợp lệ.");
                    break;
            }
        }while(true);
    }
}
