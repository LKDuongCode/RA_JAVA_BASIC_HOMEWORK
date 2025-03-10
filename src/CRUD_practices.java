import java.util.Arrays;
import java.util.Scanner;
// todo: bài tập được giao crud đối với mảng
public class CRUD_practices {
    public static void main(String[] args) {
        /*
        1. nhập số phần tử mảng n và khai báo mảng số nguyên gồm n phần tử
        2. nhập giá trị và chỉ số cần chèn vào mảng
        3. cập nhật giá trị với index
        4. xóa giá trị với index
        */

        Scanner sc = new Scanner(System.in);
        System.out.println("Khởi tạo mảng.");
        System.out.println("Nhập n = ");
        int n = Integer.parseInt(sc.nextLine());
        int[] arr = new int[n];
        for(int i = 0; i < n; i++) {
            System.out.printf("arr[%d] = ", i);
            arr[i] = Integer.parseInt(sc.nextLine());
        }
        System.out.println("Mảng hiện tại: " + Arrays.toString(arr));

        do {
            System.out.println("Menu");
            System.out.println("1. Thêm giá trị mới cho mảng.");
            System.out.println("2. Chèn một phần tử vào mảng ");
            System.out.println("3. Cập nhật một phần tử trong mảng.");
            System.out.println("4. Xóa một phần tử trong mảng.");
            System.out.println("5. Thoát.");
            System.out.print("Nhập lựa chọn của bạn: ");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice){
                case 1:
                    // nhận số phần tử cần thêm
                    System.out.println("Nhập số phần tử muốn thêm");
                    int addQuantity = Integer.parseInt(sc.nextLine());

                    // tạo mảng với kích thước mới
                    arr = Arrays.copyOf(arr, arr.length + addQuantity);

                    // gán gt vào
                    System.out.println("Nhập giá trị các phần tử muốn thêm.");
                    for(int i = (arr.length-addQuantity); i < arr.length; i++) {
                        System.out.printf("arr[%d] = ", i);
                        arr[i] = Integer.parseInt(sc.nextLine());
                    }

                    System.out.println(Arrays.toString(arr));
                    break;
                case 2:
                    System.out.println("Nhập giá trị cần chèn:");
                    int insertVal = Integer.parseInt(sc.nextLine());
                    System.out.println("Nhập vào index cần chèn:");
                    int insertIdx = Integer.parseInt(sc.nextLine());

                    if(insertIdx < 0){
                        System.out.println("Không tồn tại index này!");
                    } else if (insertIdx < n) {
                        // mở rộng mảng
                        arr = Arrays.copyOf(arr, arr.length + 1);

                        //chuyển các phần từ sau ra sau và chèn mới vào
                        for (int i = n; i > insertIdx; i--) {
                            arr[i] = arr[i - 1];
                        }
                        arr[insertIdx] = insertVal;

                        System.out.println(Arrays.toString(arr));

                    }else{
                        // trường hợp idx lớn hơn chiều dài mảng
                        // khoảng cách độ dài giữa mảng mới và mảng cũ
                        int distance = (insertIdx - arr.length) + 1;

                        arr = Arrays.copyOf(arr, arr.length + distance);
                        arr[insertIdx] = insertVal;
                        System.out.println(Arrays.toString(arr));
                    }
                    break;
                case 3:
                    // nhận index và giá trị
                    System.out.println("Nhập giá trị cần chèn:");
                    int editVal = Integer.parseInt(sc.nextLine());
                    System.out.println("Nhập index cần chèn:");
                    int editIdx = Integer.parseInt(sc.nextLine());

                    // kiểm tra tính hợp lệ
                    if(editIdx > arr.length-1 || editIdx < 0){
                        System.out.println("vị trí không hợp lệ.");
                        break;
                    }

                    arr[editIdx] = editVal;
                    System.out.println(Arrays.toString(arr));
                    break;
                case 4:
                    System.out.println(Arrays.toString(arr));
                    System.out.println("Nhập vị trí cần xóa.");
                    int deleteIdx = Integer.parseInt(sc.nextLine());

                    //kiểm tra tính hợp lệ
                    if(deleteIdx > arr.length-1 || deleteIdx < 0){
                        System.out.println("vị trí không hợp lệ.");
                        break;
                    }


                    break;
                case 5:
                    System.out.println("Thoát chương trình.");
                    sc.close();
                    System.exit(0);
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }
        } while(true);
    }
}
