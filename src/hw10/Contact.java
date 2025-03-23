package hw10;

import java.util.Objects;

public class Contact {
    static int idCount = 1;

    private int id;
    private String name;
    private String phoneNumber;

    public Contact(String name, String phoneNumber) {
        this.id = idCount++;
        this.name = name;
        this.phoneNumber = phoneNumber;
    }


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this){
            return true;
        }

        if (obj == null || getClass() != obj.getClass()){
            return false;
        }

        Contact c = (Contact) obj;
        return Objects.equals(this.phoneNumber,c.phoneNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(phoneNumber);
    }
}
