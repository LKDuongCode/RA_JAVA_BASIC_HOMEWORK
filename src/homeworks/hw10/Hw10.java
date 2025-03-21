package homeworks.hw10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Hw10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập số sinh viên (>= 5): ");
        int n;
        while (true) {
            n = Integer.parseInt(sc.nextLine());
            if (n >= 5) break;
            System.out.println("Số lượng không hợp lệ ");
        }

        List<Student> students = Student.inputData(sc, n);

        displayAll(students);

        searchStudentByName(sc,students);

        for (Student st : students) {
            System.out.println(st.getName() + " " + st.getGpa() + "  = " + st.classifyingGpa());
        }
    }

    public static void displayAll(List<Student> students) {
        System.out.println("\nDanh sách sinh viên:");
        for (Student st : students) {
            System.out.println(st);
        }
    }

    public static void searchStudentByName (Scanner sc, List<Student> students){
        System.out.print("Nhập tên cần tìm: ");
        String searchValue = sc.nextLine();

        boolean found = false;
        for (Student st : students) {
            if (st.getName().contains(searchValue)) {
                System.out.println(st);
                found = true;
            }
        }

        if (!found) {
            System.out.println("Không tìm thấy " + searchValue);
        }
    }
}
