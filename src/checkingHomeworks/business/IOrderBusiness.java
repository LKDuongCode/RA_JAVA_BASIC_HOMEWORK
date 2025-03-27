package checkingHomeworks.business;

import checkingHomeworks.entity.Order;
import checkingHomeworks.presentation.ShopManagement;

import java.util.List;
import java.util.Scanner;

public interface IOrderBusiness {
    void addOrder(Scanner scanner);
    void displayOrders();
    void updateOrderStatus(Scanner scanner);
    List<Order> getOrderOverdue();
    List<Order> getOrderDeled();
    default double getTotalRevenue() {
        return ShopManagement.orders.stream()
                .filter(Order::isStatus).mapToDouble(Order::getTotalAmount).sum();
    }

}
