public class Hw04 {
    // stringbuilder và stringbuffer chưa học kỹ ở trên lớp.
    public static void main(String[] args) {
        String initialString = "abcdefghij".repeat(100000);

        // Đảo ngược chuỗi
        char[] charArray = initialString.toCharArray();
        int left = 0, right = charArray.length - 1;
        while (left < right) {
            char temp = charArray[left];
            charArray[left] = charArray[right];
            charArray[right] = temp;
            left++;
            right--;
        }
        String reversedString = new String(charArray);
        System.out.println("Chuỗi sau khi đảo ngược (chỉ in 100 ký tự đầu): " + reversedString.substring(0, 100));

        // Chèn chuỗi con vào vị trí 500000
        int insertPos = 500000;
        String insertedString = initialString.substring(0, insertPos) + "INSERTED_TEXT" + initialString.substring(insertPos);
        System.out.println("Chuỗi sau khi chèn (vị trí 500000, chỉ in 50 ký tự quanh vị trí đó): " +
                insertedString.substring(499990, 500010));

        // Xóa đoạn từ 200000 đến 200100
        int deleteStart = 200000, deleteEnd = 200100;
        String deletedString = initialString.substring(0, deleteStart) + initialString.substring(deleteEnd);
        System.out.println("Chuỗi sau khi xóa (chỉ in 50 ký tự quanh vị trí 200000): " +
                deletedString.substring(199990, 200010));

        // Thay thế đoạn từ 700000 đến 700010
        int replaceStart = 700000, replaceEnd = 700010;
        String replacedString = initialString.substring(0, replaceStart) + "REPLACED" + initialString.substring(replaceEnd);
        System.out.println("Chuỗi sau khi thay thế (chỉ in 50 ký tự quanh vị trí 700000): " +
                replacedString.substring(699990, 700010));
    }
}
