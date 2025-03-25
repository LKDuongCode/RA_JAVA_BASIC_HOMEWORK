import java.util.Map;
import java.util.TreeMap;

public class Hw04 {
    public static void main(String[] args) {
        Map<String,Double> employees = new TreeMap<>();
        employees.put("nv123",100.0);
        employees.put("nv543",200.0);
        employees.put("nv246",600.0);
        employees.put("nv789",500.0);
        employees.put("nv189",500.0);

        Hw03.displayAll(employees);

        employees.replace("nv189",1000.0);

        employees.remove("nv789");
        Hw03.displayAll(employees);


    }
}
