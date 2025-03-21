package practices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Yêu cầu:
Tạo một ArrayList chứa tên của 5 người bạn.
Hiển thị danh sách này lên màn hình.
 */
public class P01 {
    public static void main(String[] args) {
        List<String> friends = new ArrayList<>(Arrays.asList("duong","linh","dieu","chi","anh"));
        System.out.println(friends);
    }
}
