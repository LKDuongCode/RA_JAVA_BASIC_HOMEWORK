package checkingHomeworks.business;

import checkingHomeworks.entity.Order;
import checkingHomeworks.presentation.ShopManagement;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class OrderBusiness implements IOrderBusiness{
    @Override
    public void addOrder(Scanner sc) {
        System.out.println("Thêm đơn hàng mới");
        Order newOrder = new Order();
        newOrder.inputData(sc);
        ShopManagement.orders.add(newOrder);
        System.out.println("Thêm mới thành công");
    }

    @Override
    public void displayOrders() {
        if (ShopManagement.orders.isEmpty()) {
            System.out.println("Chưa có đơn hàng nào.");
            return;
        }
        ShopManagement.orders.forEach(System.out::println);
    }

    @Override
    public void updateOrderStatus(Scanner sc) {
        System.out.println("Nhập ID đơn hàng:");
        int id = Integer.parseInt(sc.nextLine());
        Optional<Order> order = ShopManagement.orders.stream()
                .filter(o -> o.getId() == id)
                .findFirst();

        if (order.isPresent()) {
            System.out.println("Chuyển trạng thái đơn :");
            boolean status = Boolean.parseBoolean(sc.nextLine());
            order.get().setStatus(status);
            System.out.println("Cập nhật trạng thái thành công!");
        } else {
            System.out.println("Không thấy");
        }
    }

    @Override
    public List<Order> getOrderOverdue() {
        return ShopManagement.orders.stream()
                .filter(o -> o.getOrderDate().isBefore(LocalDate.now()) && !o.isStatus())
                .toList();
    }
    @Override
    public List<Order> getOrderDeled() {
        return ShopManagement.orders.stream()
                .filter(Order::isStatus).toList();
    }
}
