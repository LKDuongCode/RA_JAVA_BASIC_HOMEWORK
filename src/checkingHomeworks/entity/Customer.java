package checkingHomeworks.entity;

import checkingHomeworks.business.CustomerBusiness;
import checkingHomeworks.presentation.ShopManagement;

import java.util.Optional;
import java.util.Scanner;

public class Customer implements IApp{
    private int id;
    private String name;
    private Optional<String> email;

    public Customer() {
        this.id = ShopManagement.customerId++;
    }

    public Customer(int id, String name, Optional<String> email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Optional<String> getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = Optional.ofNullable(email);
    }

    @Override
    public void inputData(Scanner sc) {
        setId(ShopManagement.customerId++);
        System.out.println("name = ");
        String name = sc.nextLine();
        setName(name);
        System.out.println("email = ");
        String email = sc.nextLine();
        setEmail(email);
    }

    @Override
    public String toString() {
        return "id " + this.id  + "| name " + this.name + "| email " + this.email.orElse("không có");
    }
}
