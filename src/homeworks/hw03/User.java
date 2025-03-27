package homeworks.hw03;

import java.util.Optional;

public class User {
    private String name;
    private Optional<String> phone;

    public User(String name, String phone) {
        this.name = name;
        this.phone = Optional.of(Optional.ofNullable(phone).orElse("không có"));

    }

    public Optional<String> getPhone() {
        return phone;
    }

    public void setPhone(Optional<String> phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


}
