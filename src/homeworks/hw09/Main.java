package homeworks.hw09;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Order> orders = List.of(
                new Order(1, "Quý", LocalDate.of(2025, 3, 20), LocalDate.of(2025, 3, 25)),
                new Order(2, "Lan", LocalDate.of(2025, 3, 21), null),
                new Order(3, "Minh", LocalDate.of(2025, 3, 22), LocalDate.of(2025, 3, 23)),
                new Order(4, "Huyền", LocalDate.of(2025, 3, 23), null),
                new Order(5, "Việt", LocalDate.of(2025, 3, 23), LocalDate.of(2025, 3, 30))
        );

        System.out.println("đơn hàng đã được giao:");
        List<Order> result1 = orders.stream()
                        .filter((Order o) -> !o.getDeliveryDate().isPresent()).toList();
        for (Order o : result1) o.toDisplayString();

        System.out.println("đơn hàng chưa giao:");
        List<Order> result2 = orders.stream()
                .filter((Order o) -> o.getDeliveryDate().isPresent()).toList();
        for (Order o : result2) o.toDisplayString();

        System.out.println("đơn hàng giao trong khoảng :");
        long result3 = orders.stream()
                .filter((Order o) -> !o.getDeliveryDate().isPresent()).count();
        System.out.println(result3);
    }
}
