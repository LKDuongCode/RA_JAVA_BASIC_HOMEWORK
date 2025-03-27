package homeworks.hw03;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<User> users = List.of(
                new User("Quý", "0987654321"),
                new User("Lan", null),
                new User("Minh", "0933222111"),
                new User("Huyền", null)
        );

        users.forEach(user -> System.out.println("name: " + user.getName() + " | phone: " + user.getPhone().get()));
    }
}
