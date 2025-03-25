package services;

import entity.Student;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Methods {
    public static Map<String, Student> students = new HashMap<>();

    public static void printMenu (){
        System.out.println("===menu===");
        System.out.println("1. In danh sách sinh viên.");
        System.out.println("2. thêm mới sinh viên");
        System.out.println("3. Xóa sinh viên theo mã ");
        System.out.println("4. Tính điểm trung bình các sinh viên.");
        System.out.println("5. In sinh viên điểm trung bình cao nhất.");
        System.out.println("6. In sinh viên nhỏ tuổi nhất");
        System.out.println("7. thoát");
        System.out.println("Lựa chọn của bạn: ");
    }

    public static void displayAll (){
        if(students.isEmpty()) {
            System.out.println("danh sách trống");
            return;
        }
        System.out.println("danh sách sinh viên");
        for(Map.Entry<String,Student> entry : students.entrySet()){
            System.out.println(entry);
        }
    }

    public static void addStudent (Scanner sc){
        Student newStudent = new Student();
        newStudent.inputData(sc);

        students.put(newStudent.getId(), newStudent);
        System.out.println("thêm mới thành công");
    }

    public static void deleteStudentByID (Scanner sc){
        if(students.isEmpty()) {
            System.out.println("danh sách trống");
            return;
        }

        System.out.print(" nhập id cần tìm: ");
        String id = sc.nextLine();
        boolean found = false;

        for (String key : students.keySet()){
            if(key == id){
                found = true;
                students.remove(key);
                break;
            }
        }

        if(!found){
            System.out.println("không tìm thấy sinh viên cần xóa");
        }
    }

    public static float calAvgScoreAll (){
        float sum = 0;
        int count = 0;
        for (Student s : students.values()){
            sum += s.getAverageScore();
            count++;
        }

        return sum/count;
    }

    public static void searchHighestScore (){
        float max = Float.MIN_VALUE;
        Student std = new Student();

        for (Student s : students.values()){
            if(max < s.getAverageScore()){
                max = s.getAverageScore();
                std = s;
            }
        }

        std.toString();
    }

    public static void searchYoungestStudent (){
        int min = Integer.MAX_VALUE;
        Student std = new Student();

        for (Student s : students.values()){
            if(min > s.getAge()){
                min = s.getAge();
                std = s;
            }
        }

        std.toString();
    }
}
