package homeworks;

import java.util.ArrayList;
import java.util.List;

public class Hw08 {
    public static void main(String[] args) {
        List<String> stringList = new ArrayList<>();

        stringList.add("duong");
        stringList.add("chi");
        stringList.add("linh");

        for (int i = 0; i < stringList.size() - 1; i++) {
            for (int j = 0; j < stringList.size() - i - 1; j++) {
                int len1 = stringList.get(j).length();
                int len2 = stringList.get(j + 1).length();

                if (len1 > len2 || (len1 == len2 && stringList.get(j).compareTo(stringList.get(j + 1)) > 0)) {
                    String temp = stringList.get(j);
                    stringList.set(j, stringList.get(j + 1));
                    stringList.set(j + 1, temp);
                }
            }
        }

        System.out.println(stringList);


    }
}
