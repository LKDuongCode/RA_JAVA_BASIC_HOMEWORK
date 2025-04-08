package business;

import entity.ClassRoom;
import entity.Schedule;
import utils.InputUtils;
import utils.ValidateScheduleUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ScheduleBusiness {
    public static final List<Schedule> SCHEDULES = new ArrayList<>();

    public void addSchedule(Scanner sc) {
        System.out.print("Nhập ID lớp học cần tạo lịch: ");
        int classId = InputUtils.validateInt(sc);

        ClassRoom found = ClassroomBusiness.CLASSROOMS.stream()
                .filter(c -> c.getClassroomId() == classId)
                .findFirst().orElse(null);

        if (found == null) {
            System.out.println("Không tìm thấy lớp học.");
            return;
        }

        System.out.println("Nhập thời gian học:");
        var dateTimes = ValidateScheduleUtils.inputValidSchedule(sc);

        Schedule schedule = new Schedule();
        schedule.setClassroomId(classId);
        schedule.setStartTime(dateTimes[0]);
        schedule.setEndTime(dateTimes[1]);

        SCHEDULES.add(schedule);
        System.out.println("Đã tạo lịch học thành công.");
    }

    public void displayAllSchedules() {
        if (SCHEDULES.isEmpty()) {
            System.out.println("Chưa có lịch học nào.");
            return;
        }

        System.out.println("Danh sách lịch học:");
        SCHEDULES.forEach(System.out::println);
    }
}