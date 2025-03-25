import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class Hw06 {
    public static void main(String[] args) {
        Map<String,Double> students = new LinkedHashMap<>();
        students.put("duong",10.0);
        students.put("linh",10.0);
        students.put("chi",7.0);
        students.put("hoang",8.0);
        students.put("tien",6.0);
        students.put("dieu",5.0);
        students.put("thang",4.0);
        students.put("thua",1.0);
        students.put("vip",8.0);
        students.put("boy",6.0);

        Hw03.displayAll(students);
        double averange = calAverage(students);
        System.out.println(averange);


        deleteStudent(students);
        Hw03.displayAll(students);

    }

    public static <K,V> Double calAverage (Map<K,V> maps){
        int count = 0;
        double sum = 0;

        for (V value : maps.values()){
            sum += (Double) value;
            count++;
        }
        return sum/count;
    }

    static void deleteStudent (Map<String,Double> maps){
        Iterator<String> it = maps.keySet().iterator();
        while(it.hasNext()){
            String cur = it.next();
            if(maps.get(cur) < 5){
                it.remove();
            }
        }
    }
}
