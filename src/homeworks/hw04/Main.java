package homeworks.hw04;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        students.add(new Student("duong",20,100));
        students.add(new Student("linh",17,100));
        students.add(new Student("chi",15,70));
        students.add(new Student("dieu",16,70));
        List<Student> readStudents = new ArrayList<>();
        String scr = "src/homeworks/hw04/student.dat";

        writeBinaryFile(scr,students);
        readBinaryFile(scr,readStudents);

        readStudents.forEach(s -> System.out.println("name = " + s.name + "| age = " + s.age));
    }

    static void readBinaryFile (String scr, List<Student> students){
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(scr))){
            while (true){
                try{
                    Student std = (Student) ois.readObject();
                    students.add(std);
                }catch (EOFException e){
                    break;
                }
            }
            System.out.println("đọc thành công.");

        }catch (IOException | ClassNotFoundException e){
            homeworks.hw01.Main.logger.severe(e.getMessage());
        }
    }

    static void writeBinaryFile (String destination, List<Student> students){
        File file = new File(destination);
        if(file.exists()){
            System.out.println("đã tồn tại.");
        }else{
            try {
                String mes = file.createNewFile() ? "tạo thành công" : "không tạo được";
                System.out.println(mes);
            }catch (IOException e){
                homeworks.hw01.Main.logger.severe(e.getMessage());
            }

        }

        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(destination))){
            for (Student s : students){
                oos.writeObject(s);
            }
            System.out.println("ghi thành công.");
        }catch (IOException e){
            homeworks.hw01.Main.logger.severe(e.getMessage());
        }

    }
}
