package homeworks.hw02;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("nhập tên tệp từ bàn phím (chỉ tên)");
        String filename = sc.nextLine();
        String scr = "src/homeworks/hw02/" + filename + ".txt";

        try{
            File file = new File(scr);
            if(!file.exists()){
                String mes = file.createNewFile() ? "file đã được tạo" : "không thể tạo.";
                System.out.println(mes);
            }else {
                System.out.println("file đã tồn tại!.");
            }
            System.out.println(file.getAbsoluteFile());
            System.out.println(file.getName());
            System.out.println(file.getPath());
            System.out.println(file.canWrite() + " - " + file.canRead());
        }catch (IOException e){
            homeworks.hw01.Main.logger.severe(e.getMessage());
        }
    }
}
