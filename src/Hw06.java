public class Hw06 {
    public static void main(String[] args) {
        
        String str = "Hello";
        long startTime = System.currentTimeMillis();
        int repeating = 100000;
        String str2 = " World";
        
        for (int i = 0; i < repeating; i++) {
            str += str2;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("nối chuỗi bằng String: " + (endTime - startTime) + " ms");

        // stringbuilder
        startTime = System.currentTimeMillis();
        StringBuilder sb = new StringBuilder("Hello");
        for (int i = 0; i < repeating; i++) {
            sb.append(str2);
        }
        endTime = System.currentTimeMillis();
        System.out.println("nối chuỗi bằng StringBuilder: " + (endTime - startTime) + " ms");

        // stringbuffer
        startTime = System.currentTimeMillis();
        StringBuffer sbf = new StringBuffer("Hello");
        for (int i = 0; i < repeating; i++) {
            sbf.append(str2);
        }
        endTime = System.currentTimeMillis();
        System.out.println("nối chuỗi bằng StringBuffer: " + (endTime - startTime) + " ms");

        /*
        kết quả
        nối chuỗi bằng String: 3861 ms
        nối chuỗi bằng StringBuilder: 1 ms
        nối chuỗi bằng StringBuffer: 3 ms

        - thời gian thực thi của stringbuilder nhanh nhất sau đó đến stringbuffer và cuối cùng là nối chuỗi thường
        vì string thường là immutable => mỗi lần nối là tạo một đối tượng mới
        và stringbuilder và stringbuffer thì ngược lại
        stringbuffer hỗ trợ đa luồng nên an toàn trong trường hợp có nhiều luồng chạy
        nếu chỉ làm việc 1 luồng thì dùng stringbuilder.
        */
    }
}
