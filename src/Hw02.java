public class Hw02 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder("Hello, Java World!");
        System.out.println("ban đầu: " + sb);
        // xóa từ 5-9
        sb.delete(5,9);
        System.out.println("xóa : " + sb);

        // thay World = Universe
       int start = sb.indexOf("World");
       if (start != -1){
           int end = start + "World".length();
           sb.replace(start,end,"Universe");
       }
        System.out.println("thay thế : " + sb);

    }
}
