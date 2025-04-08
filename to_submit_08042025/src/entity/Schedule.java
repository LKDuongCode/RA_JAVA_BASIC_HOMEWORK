package entity;

import utils.InputUtils;
import utils.ValidateScheduleUtils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;

public class Schedule implements  IApp{
    private static final AtomicInteger AUTO_SCHEDULE_ID = new AtomicInteger(1);

    private int scheduleId;
    private int classroomId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;

    public Schedule() {
    }

    public Schedule(int scheduleId, int classroomId, LocalDateTime startTime, LocalDateTime endTime) {
        this.scheduleId = scheduleId;
        this.classroomId = classroomId;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public int getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(int scheduleId) {
        this.scheduleId = scheduleId;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public int getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(int classroomId) {
        this.classroomId = classroomId;
    }

    @Override
    public void inputData(Scanner sc) {
        setScheduleId(AUTO_SCHEDULE_ID.getAndIncrement());

        System.out.println("nhập mã lớp:");
        setClassroomId(InputUtils.validateInt(sc));

        LocalDateTime[] schedule = ValidateScheduleUtils.inputValidSchedule(sc);
        setStartTime(schedule[0]);
        setEndTime(schedule[1]);
    }

    @Override
    public String toString() {
        return " |scheduleId: "+ this.scheduleId +
                " |classroomId: " +this.classroomId +
                " |startTime: " + this.startTime+
                " |endTime: " + this.endTime;
    }
}
