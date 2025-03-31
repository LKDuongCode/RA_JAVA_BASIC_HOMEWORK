package homeworks.hw03;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String scrInput = "src/homeworks/hw03/input.txt";
        String scrCopy = "src/homeworks/hw03/copy.txt";
        List<String> contents = new ArrayList<>();
        copyFileTo(scrInput,scrCopy,contents);
    }

    static void readFile (String scr, List<String> contents){
        try(BufferedReader reader = new BufferedReader(new FileReader(scr))){
            String line;
            int count = 0;
            while ((line = reader.readLine()) != null){
                contents.add(line);
                count++;
            }

            System.out.println("đã ghi " + count + " dòng vào danh sách trung gian.");
        }catch (IOException e){
            homeworks.hw01.Main.logger.warning(e.getMessage());
        }
    }

    static void writeFile (String scr, List<String> contents){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(scr))){
            File file = new File(scr);
            if(file.exists()){
                System.out.println("file đã tồn tại, tiến hành copy.");
            }else {
                String mes = file.createNewFile() ? "file mới được tạo" : "không thể tạo";
                System.out.println(mes);
            }

            for (String c : contents) {
                writer.write(c);
                writer.newLine();
            }
        }catch (IOException e) {
            homeworks.hw01.Main.logger.warning(e.getMessage());
        }
    }

    static void copyFileTo (String source, String destination, List<String> contents){
        readFile(source,contents);
        writeFile(destination,contents);
        System.out.println("đã copy nội dung từ inputdata -> copy!");
    }
}
