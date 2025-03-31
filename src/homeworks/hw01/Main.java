package homeworks.hw01;

import java.io.*;
import java.util.Scanner;
import java.util.logging.Logger;

public class Main {
    public static final Logger logger = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String scr = "src/homeworks/hw01/output.txt";
        writeFile(sc,scr);
        readFile(scr);
    }


    static void readFile (String scr){
        try (BufferedReader reader = new BufferedReader(new FileReader(scr))){
            String line;
            while ((line = reader.readLine()) != null){
                System.out.println(line);
            }
        }catch (IOException e){
            logger.severe("đã xảy ra lỗi " + e.getMessage());
        }
    }

    static void writeFile (Scanner sc, String scr){
        System.out.println("nhập số dòng cần ghi: ");
        int numOfLine = Integer.parseInt(sc.nextLine());
        System.out.println("mời nhập nội dung.");
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(scr),numOfLine)) {
            for(int i = 0; i < numOfLine; i++){
                writer.write(sc.nextLine());
                writer.newLine();
            }
        }catch (IOException e){
            logger.severe(e.getMessage());
        }
    }
}
