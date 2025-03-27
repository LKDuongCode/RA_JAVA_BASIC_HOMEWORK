package homeworks.hw10;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        User u1 = new User(1, "Quý", "quy@example.com");
        User u2 = new User(2, "Lan", null);
        User u3 = new User(3, "Huyền", "huyen@example.com");

        List<Task> tasks = List.of(
                new Task(1, "Viết báo cáo", u1, LocalDate.of(2025, 3, 20), false),
                new Task(2, "Thiết kế slide", u1, LocalDate.of(2025, 3, 25), true),
                new Task(3, "Họp nhóm", u2, LocalDate.of(2025, 3, 18), false),
                new Task(4, "Nộp tài liệu", u3, LocalDate.of(2025, 3, 22), true),
                new Task(5, "Chuẩn bị thuyết trình", u2, LocalDate.of(2025, 3, 19), true));

        System.out.println("danh sách công việc quá hạn và chưa hoàn thành");
        List<Task> result01 = tasks.stream()
                .filter((Task t) -> !t.completed && t.dueDate.isBefore(LocalDate.of(2025,3,23))).toList();
        printList(result01);

        System.out.println("số công việc đã hoàn thành");
        long countCompleted = tasks.stream()
                .filter((Task t) -> t.completed).count();
        System.out.println(countCompleted);

        System.out.println("thống kê công việc theo tên người dùng.");
        Map<User,List<Task>> groupUser = tasks.stream() // gom task theo user
                .collect(Collectors.groupingBy((Task t) -> t.assignedTo));

        for(Map.Entry<User,List<Task>> entry : groupUser.entrySet()){
            String email = entry.getKey().email.orElse("không có");
            long totalTask = entry.getValue().size();
            long overTask = entry.getValue().stream()
                    .filter((Task t) -> !t.completed && t.dueDate.isBefore(LocalDate.of(2025,3,23))).count();
            System.out.println("name " + entry.getKey().name + " | email " + email + " | total " + totalTask + " | overtask " + overTask );
        }
    }

    public static void printList (List<Task> list){
        for (Task t : list){
            System.out.println(" - " + t.title);
        }
    }
}
