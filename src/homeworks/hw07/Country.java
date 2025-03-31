package homeworks.hw07;

public class Country {
    private int id;
    private String code;
    private String name;

    public Country(int id, String code, String name) {
        this.id = id;
        this.code = code;
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("[ ID: %-2d | CODE: %-4s | NAME: \"%s\" ]", id, "\"" + code + "\"", name);
    }
}
