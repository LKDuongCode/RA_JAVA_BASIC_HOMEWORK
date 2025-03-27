package checkingHomeworks.presentation;

import checkingHomeworks.business.CustomerBusiness;
import checkingHomeworks.business.OrderBusiness;
import checkingHomeworks.entity.Customer;
import checkingHomeworks.entity.Order;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ShopManagement {
    public static int customerId = 0;
    public static int orderId = 0;
    public static List<Customer> customers = new ArrayList<>();
    public static List<Order> orders = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        OrderBusiness running = new OrderBusiness();
        do {
            printMenu("main");
            System.out.println("Lựa chọn của bạn:");
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice){
                case 1:
                    boolean exitCus = false;
                    do {
                        printMenu("customer");

                        System.out.println("Lựa chọn của bạn:");
                        int cusChoice = Integer.parseInt(sc.nextLine());

                        switch (cusChoice){
                            case 1:
                                CustomerBusiness.displayCustomers();
                                break;
                            case 2:
                                CustomerBusiness.addCustomer(sc);
                                break;
                            case 3:
                                System.out.println("quay lại main");
                                exitCus = true;
                                break;
                            default:
                                System.out.println("không hợp lệ");
                                break;
                        }
                    }while (exitCus);
                    break;
                case 2:
                    boolean exitO = false;
                    do {
                        printMenu("order");

                        System.out.println("Lựa chọn của bạn:");
                        int oChoice = Integer.parseInt(sc.nextLine());

                        switch (oChoice){
                            case 1:
                                if (ShopManagement.orders.isEmpty()) {
                                    System.out.println("Chưa có đơn");
                                } else {
                                    OrderBusiness orderBusiness = new OrderBusiness();
                                    orderBusiness.displayOrders();
                                }
                                break;
                            case 2:
                                running.addOrder(sc);
                                break;
                            case 3:
                                running.updateOrderStatus(sc);
                                break;
                            case 4:
                                List<Order> overdueOrders = running.getOrderOverdue();
                                overdueOrders.forEach(System.out::println);
                                break;
                            case 5:
                                long countDelivered = running.getOrderDeled().size();
                                System.out.println(countDelivered);
                                break;
                            case 6:
                                double totalRevenue = running.getTotalRevenue();
                                System.out.println(totalRevenue);
                                break;

                            case 7:
                                System.out.println("quay lại main");
                                exitO = true;
                                break;
                            default:
                                System.out.println("không hợp lệ");
                                break;
                        }
                    }while (exitO);
                    break;
                case 3:
                    System.out.println("dừng chương trình");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("không hợp lệ");
                    break;
            }
        }while(true);
    }

    public static void printMenu (String mes){
        if(mes == "main"){
            System.out.println("main menu============");
            System.out.println("1. quản lí khách");
            System.out.println("2. quản đơn");
            System.out.println("3. thoát");
            return;
        }

        if(mes == "customer"){
            System.out.println("customer menu============");
            System.out.println("1. in danh sách khách");
            System.out.println("2. thêm mới khách");
            System.out.println("3. thoát");
            return;
        }

        if(mes == "order"){
            System.out.println("order menu============");
            System.out.println("1. in danh sách đơn");
            System.out.println("2. thêm mới đơn");
            System.out.println("3. cập nhật trạng thái đơn");
            System.out.println("4. danh sách đơn quá hạn ");
            System.out.println("5. thống kê số lượng đơn đã giao (True)");
            System.out.println("6. tính tổng doanh thu các đơn đã giao.");
            System.out.println("7. thoát");
            return;
        }
    }
}
