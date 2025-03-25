package presentation;

import services.Methods;

import java.util.Scanner;

public class StudentManagement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        do {
            Methods.printMenu();
            int choice = Integer.parseInt(sc.nextLine());

            switch (choice){
                case 1:
                    Methods.displayAll();
                    break;
                case 2:
                    Methods.addStudent(sc);
                    break;
                case 3:
                    Methods.deleteStudentByID(sc);
                    break;
                case 4:
                    System.out.println(Methods.calAvgScoreAll());
                    break;
                case 5:
                    Methods.searchHighestScore();
                    break;
                case 6:
                    Methods.searchYoungestStudent();
                    break;
                case 7:
                    System.out.println("thoát chưởng trình");
                    sc.close();;
                    System.exit(0);
                default:
                    System.out.println("lựa chọn không hợp lệ");
                    break;

            }
        }while(true);
    }
}
