public class Hw06 {
    public static void main(String[] args) {
        int[] markingArray = new int[1000];
        int[] originalArray = {100, 200, 300, 100, 400, 500, 200, 100, 600, 700, 200, 800, 100, 900, 200, 100, 300, 400, 500, 100};

        // Đếm số lần xuất hiện của từng phần tử
        for (int num : originalArray) {
            markingArray[num]++;
        }

        // Tìm số lần xuất hiện lớn nhất
        int maxCount = 0;
        for (int count : markingArray) {
            if (count > maxCount) {
                maxCount = count;
            }
        }

        System.out.print("Phần tử xuất hiện nhiều nhất: ");
        for (int i = 0; i < markingArray.length; i++) {
            if (markingArray[i] == maxCount) {
                System.out.print(i + " ");
            }
        }
        System.out.println("\nSố lần xuất hiện: " + maxCount);
    }
}
