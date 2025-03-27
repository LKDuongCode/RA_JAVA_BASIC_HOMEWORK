package homeworks.hw10;

import java.util.Optional;

public class User {
    int id;
    String name;
    Optional<String> email;

    public User(int id, String name,String email ) {
        this.id = id;
        this.email = Optional.of( Optional.ofNullable(email).orElse("không có"));
        this.name = name;
    }

}
