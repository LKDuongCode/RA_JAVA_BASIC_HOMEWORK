public  class Hw01 {
    public static void main(String[] args) {
        // khai báo mảng và gán giá trị trực tiếp
        int[] arr = {3,2,5,6};

        // tạo 1 biến để lưu trữ max
        int max = arr[0];

        // duyệt qua từng phần tử và cập nhật max
        for(int i : arr){
            if (i > max) max = i;
        }

        System.out.println("max = "+ max);
    }
}