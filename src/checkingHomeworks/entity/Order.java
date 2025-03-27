package checkingHomeworks.entity;

import checkingHomeworks.presentation.ShopManagement;

import java.time.LocalDate;
import java.util.Scanner;

public class Order implements IApp{
    private int id;
    private Customer customer;
    private LocalDate orderDate;
    private double totalAmount;
    private boolean status;

    public Order() {
        this.id = ShopManagement.orderId++;
    }

    public Order(int id, Customer customer, LocalDate orderDate, double totalAmount, boolean status) {
        this.id = id;
        this.customer = customer;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public void inputData(Scanner sc) {
        setId(ShopManagement.orderId++);
        System.out.println("customer: ");
        Customer customer1 = new Customer();
        customer1.inputData(sc);
        setCustomer(customer1);

        System.out.println("orderDate");
        setOrderDate(LocalDate.now());

        System.out.println("totalAmount");
        double total = Double.parseDouble(sc.nextLine());
        setTotalAmount(total);

        System.out.println("status");
        boolean status = Boolean.parseBoolean(sc.nextLine());
        setStatus(status);
    }

    @Override
    public String toString() {
        return "id " + this.id  + "| customer " + this.customer.getName() + "| orderDate " + this.orderDate + "| totalAmount" + this.totalAmount + "| status" + this.status;
    }
}
