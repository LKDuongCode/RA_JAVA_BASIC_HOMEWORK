import java.util.HashMap;
import java.util.Map;

public class Hw01 {
    public static void main(String[] args) {
        Map<String,Double> students = new HashMap<>();
        students.put("duong",10.0);
        students.put("linh",10.0);
        students.put("chi",7.0);
        students.put("hoang",8.0);
        students.put("tien",6.0);

        System.out.println(students);

        if (students.containsKey("duong")) {
            System.out.println("duong - " + students.get("duong"));
        }

    }
}
