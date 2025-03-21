package homeworks;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Hw01 {
    public static void main(String[] args) {
        List<String> studentNames = new ArrayList<>();
        studentNames.add("duong");
        studentNames.add("hoang");
        studentNames.add("linh");
        studentNames.add("chi");
        studentNames.add("anh");

        System.out.println("for :");
        for (int i = 0; i < studentNames.size(); i++) {
            System.out.println(studentNames.get(i));
        }

        System.out.println("foreach: ");
        for (String name : studentNames) {
            System.out.println(name);
        }

        System.out.println("Iterator:");
        Iterator<String> iterator = studentNames.iterator();
        while (iterator.hasNext()) {
            String name = iterator.next();
            System.out.println(name);
        }
    }
}
