package practices;
/*
Yêu cầu:

Thêm một người bạn mới vào danh sách.
Xóa một người khỏi danh sách.
Thay đổi tên của một người trong danh sách.
In lại danh sách sau khi thay đổi.*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P02 {
    public static void main(String[] args) {
        List<String> friends = new ArrayList<>(Arrays.asList("chi","linh"));

        friends.add("duong");
        System.out.println(friends);

        friends.remove("linh");
        System.out.println(friends);

        friends.set(0,"phuong chi");
        System.out.println(friends);


    }
}
