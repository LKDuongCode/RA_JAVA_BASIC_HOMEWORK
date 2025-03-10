package Sumary_practices;

import java.util.Arrays;
import java.util.Scanner;

// todo: folder này chứa các bài tập trong file pdf được thầy Quang gửi trong nhóm.
public class Sumary01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = new int[100];
        // biến index hiện tại của mảng
        int curIdx = 0;

        do {
            System.out.println("----- MENU -----");
            System.out.println("1. Nhập giá trị n phần tử của mảng");
            System.out.println("2. In giá trị các phần tử trong mảng");
            System.out.println("3. Tính trung bình các phần tử dương (>0) trong mảng");
            System.out.println("4. In ra vị trí (chỉ số) các phần tử có giá trị bằng k trong mảng");
            System.out.println("5. Sử dụng thuật toán sắp xếp nổi bọt sắp xếp mảng giảm dần");
            System.out.println("6. Tính số lượng các phần tử là số nguyên tố trong mảng");
            System.out.println("7. Sắp xếp các phần tử chẵn chia hết cho 3 ở đầu mảng theo thứ tự tăng dần, các phần tử lẻ chia hết cho 3 ở cuối mảng theo thứ tự giảm dần, các phần tử còn lại ở giữa mảng theo thứ tự tăng dần");
            System.out.println("8. Nhập giá trị m từ bàn phím, chèn giá trị m vào mảng (sắp xếp giảm dần) đúng vị trí");
            System.out.println("9. Thoát");

            System.out.print("Lựa chọn của bạn: ");
            int sum;
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice){
                case 1:
                    System.out.print("n = ");
                    int n = Integer.parseInt(sc.nextLine());

                    //kiểm tra tính hợp lệ
                    if(n <= 0){
                        System.out.println("n không hợp lệ!");
                        break;
                    }

                    // nhập giá trị
                    for(int i = curIdx; i < n; i++) {
                        System.out.printf("arr[%d] = ", i);
                        arr[i] = Integer.parseInt(sc.nextLine());
                        curIdx++;
                    }
                    break;
                case 2:
                    // kiểm tra mảng đã có giá trị chưa
                    if(curIdx == 0){
                        System.out.println("Mảng chưa được nhập giá trị!");
                    }else {
                        System.out.print("arr ");
                        System.out.println(Arrays.toString(Arrays.copyOfRange(arr,0,curIdx)));
                    }
                    break;
                case 3:
                    if(curIdx == 0) {
                        System.out.println("Mảng chưa được nhập giá trị!");
                        break;
                    }

                    // tạo biến tổng và biến đếm
                    sum = 0;
                    int count = 0;

                    // duyệt những phần tử dương trong mảng
                    for(int i = 0; i < curIdx; i++) {
                        if(arr[i] > 0){
                            sum += arr[i];
                            count ++;
                        }
                    }

                    System.out.println("average = " + (float) sum/count);
                    break;
                case 4:
                    // kiểm tra xem mảng đã có giá trị chưa
                    if(curIdx == 0) {
                        System.out.println("Mảng chưa được nhập giá trị!");
                        break;
                    }
                    // in ra index của phần tử với giá trị k nhưng nếu nhiều phần tử = k thì lấy k đầu tiên
                    System.out.println("Nhập phần tử cần tìm: ");
                    int k = Integer.parseInt(sc.nextLine());
                    boolean found = false;
                    for(int i = 0; i < curIdx; i++) {
                        if(arr[i] == k){
                            System.out.println("Vị trí cần tìm = " + i );
                            found = true;
                            break;
                        }
                    }

                    if (!found){
                        System.out.println("Không tìm thấy "+ k);
                    }
                    break;
                case 5:
                    if(curIdx == 0) {
                        System.out.println("Mảng chưa được nhập giá trị!");
                        break;
                    }
                    // dùng bubble sort desc
                    boolean isSwapped;
                    for(int i = 0; i < curIdx; i++) {
                        isSwapped = false;
                        for(int j = 0; j < curIdx-i; j++) {
                            if(arr[j] < arr[j+1]){
                                int temp = arr[j];
                                arr[j] = arr[j+1];
                                arr[j+1] = temp;
                                isSwapped = true;
                            }
                        }
                        if (!isSwapped) break;
                    }
                    break;
                case 6:
                    if(curIdx == 0) {
                        System.out.println("Mảng chưa được nhập giá trị!");
                        break;
                    }
                    // tạo flag
                    int countOfPrime = 0;
                    boolean isPrime;
                    for(int i = 2; i < curIdx; i++) {
                        // duyệt để kiểm tra
                        isPrime = true;
                        for(int j = 2; j <= Math.sqrt(i); j++) {
                            if(i % j == 0){
                                isPrime = false;
                                break;
                            }
                        }

                        if (isPrime){
                            countOfPrime ++;
                        }
                    }

                    System.out.println("Tổng số nguyên tố = "+ countOfPrime);
                    break;
                case 7:
                    if(curIdx == 0) {
                        System.out.println("Mảng chưa được nhập giá trị!");
                        break;
                    }
                    // đếm số lượng
                    int countSt = 0, countNd = 0, countRd = 0;
                    for (int i = 0; i < curIdx; i++) {
                        if (arr[i] % 3 == 0 && arr[i] % 2 == 0) countSt++;
                        else if (arr[i] % 3 == 0 && arr[i] % 2 != 0) countNd++;
                        else countRd++;
                    }

                    // a.tạo mảng chứa các phần tử chẵn chia hết cho 3
                    // b.tạo mảng chứa các phần tử lẻ chia hết cho 3
                    // c.tạo mảng chứa các phần tử còn lại
                    int[] newArrSt = new int[countSt];
                    int[] newArrNd = new int[countNd];
                    int[] newArrRd = new int[countRd];

                    int idxSt = 0, idxNd = 0, idxRd = 0;
                    for (int i = 0; i < curIdx; i++) {
                        if (arr[i] % 3 == 0 && arr[i] % 2 == 0) newArrSt[idxSt++] = arr[i];
                        else if (arr[i] % 3 == 0 && arr[i] % 2 != 0) newArrNd[idxNd++] = arr[i];
                        else newArrRd[idxRd++] = arr[i];
                    }

                    // sắp xếp
                    Arrays.sort(newArrSt);
                    for (int i = 1; i < newArrNd.length; i++) {
                        int key = newArrNd[i];
                        int j = i - 1;
                        while (j >= 0 && newArrNd[j] < key) {
                            newArrNd[j + 1] = newArrNd[j];
                            j--;
                        }
                        newArrNd[j + 1] = key;
                    }

                    Arrays.sort(newArrRd);

                    System.out.println(Arrays.toString(newArrSt));
                    System.out.println(Arrays.toString(newArrNd));
                    System.out.println(Arrays.toString(newArrRd));

                    // ghép chúng vào với nhau theo thứ tự acb
                    int idx = 0;
                    System.arraycopy(newArrSt, 0, arr, idx, newArrSt.length);
                    idx += newArrSt.length;

                    System.arraycopy(newArrRd, 0, arr, idx, newArrRd.length);
                    idx += newArrRd.length;

                    System.arraycopy(newArrNd, 0, arr, idx, newArrNd.length);
                    break;
                case 8:
                    // sắp xếp mảng giảm dần
                    for (int i = 0; i < curIdx - 1; i++) {
                        for (int j = i + 1; j < curIdx; j++) {
                            if (arr[i] < arr[j]) {
                                int temp = arr[i];
                                arr[i] = arr[j];
                                arr[j] = temp;
                            }
                        }
                    }


                    // chèn m vào vị trí
                    System.out.println("Nhập m = ");
                    int  m = Integer.parseInt(sc.nextLine());
                    int pos = 0;
                    while (pos < curIdx && arr[pos] > m) {
                        pos++;
                    }

                    for (int i = curIdx; i > pos; i--) {
                        arr[i] = arr[i - 1];
                    }

                    arr[pos] = m;
                    curIdx++;
                    break;
                case 9:
                    System.out.println("Thoát chương trình!");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        }while(true);
    }
}
