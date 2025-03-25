import java.util.*;

public class Hw07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập n: ");
        int n = Integer.parseInt(sc.nextLine());
        int[] arr = new int[n];

        inputData(arr,sc);

        System.out.println(Arrays.toString(arr));

        Map<Integer,Integer> checkingAppear = new LinkedHashMap<>();
        calAppear(checkingAppear,arr);
        Hw03.displayAll(checkingAppear);
    }

    static void inputData (int[] arr, Scanner sc){
        System.out.println("nhập giá trị: ");
        for (int i = 0; i<arr.length; i++){
            arr[i] = Integer.parseInt(sc.nextLine());
        }
    }

    static void calAppear (Map<Integer,Integer> maps, int[] arr){
        for(int i = 0; i < arr.length; i++) {
            if(maps.containsKey(arr[i])){
                maps.put(arr[i], maps.get(arr[i]) + 1);
            }else {
                maps.put(arr[i],1);
            }
        }
        // c2
//        for (int num : arr) {
//            maps.put(num, maps.getOrDefault(num, 0) + 1);
//        }
    }
}
