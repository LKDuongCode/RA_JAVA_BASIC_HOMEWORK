package utils;

import business.service.statistic.StatisticService;
import business.service.statistic.StatisticServiceImpl;

import java.util.Map;

public class StatisticUtils {
    private final StatisticService service = new StatisticServiceImpl();

    public void printTotalEmployee() {
        int total = service.getTotalEmployee();
        System.out.println("Tổng số nhân viên toàn hệ thống: " + total + " nhân viên");
    }

    public void printEmployeeCountPerDepartment() {
        System.out.println(" Số lượng nhân viên theo từng phòng ban:");
        Map<String, Integer> map = service.getEmployeeCountPerDepartment();
        if (map.isEmpty()) {
            System.out.println("Không có dữ liệu phòng ban.");
            return;
        }
        map.forEach((dept, count) ->
                System.out.println("- " + dept + ": " + count + " nhân viên")
        );
    }

    public void printDepartmentWithMostEmployees() {
        String most = service.getDepartmentWithMostEmployees();
        System.out.println(" Phòng ban có nhiều nhân viên nhất: " + most);
    }

    public void printDepartmentWithHighestAvgSalary() {
        String rich = service.getDepartmentWithHighestAverageSalary();
        System.out.println("Phòng ban có lương trung bình cao nhất: " + rich);
    }

}
