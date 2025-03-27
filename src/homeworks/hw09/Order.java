package homeworks.hw09;

import java.time.LocalDate;
import java.util.Optional;

public class Order {
    private int id;
    private String name;
    private LocalDate createdDate;
    private Optional<LocalDate> deliveryDate;

    public Order() {
    }

    public Order(int id, String name, LocalDate createdDate, LocalDate deliveryDate) {
        this.id = id;
        this.name = name;
        this.createdDate = createdDate;
        this.deliveryDate = Optional.ofNullable(deliveryDate);
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

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public Optional<LocalDate> getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = Optional.ofNullable(deliveryDate);
    }

    public void toDisplayString (){
        System.out.println("ID : " + this.id + "|name : " + this.name + "|createdDate : " + this.createdDate + "deliveryDate : " + (!this.deliveryDate.isPresent() ? "Chưa giao" : this.deliveryDate.get()));
    }
}
