package homeworks.hw10;

import java.time.LocalDate;
import java.util.Optional;

public class Task {
    int id;
    String title;
    User assignedTo;
    LocalDate dueDate;
    boolean completed;

    public Task(int id, String title, User assignedTo, LocalDate dueDate,boolean completed) {
        this.id = id;
        this.title = title;
        this.assignedTo = assignedTo;
        this.completed = completed;
        this.dueDate = dueDate;
    }


}
