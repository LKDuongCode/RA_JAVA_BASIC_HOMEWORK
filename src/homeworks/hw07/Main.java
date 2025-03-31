package homeworks.hw07;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/homeworks/hw07/data.txt";
        List<String> lines = Arrays.asList(
                "1,\"AU\",\"Australia\"",
                "2,\"CN\",\"China\"",
                "3,\"AU\",\"Australia\"",
                "4,\"CN\",\"China\"",
                "5,\"JP\",\"Japan\"",
                "6,\"CN\",\"China\"",
                "7,\"JP\",\"Japan\"",
                "8,\"TH\",\"Thailand\""
        );

        createFileIfNotExists(filePath, lines);
        List<Country> countries = readCountries(filePath);

        countries.forEach(System.out::println);
    }

    static void createFileIfNotExists(String path, List<String> contents) {
        File file = new File(path);
        try {
            if (!file.exists()) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    for (String line : contents) {
                        writer.write(line);
                        writer.newLine();
                    }
                }
            } else {
                System.out.println("đã tồn tại");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static List<Country> readCountries(String path) {
        List<Country> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0].trim());
                String code = parts[1].replace("\"", "").trim();

                String name = parts[2].replace("\"", "").trim();
                list.add(new Country(id, code, name));
            }
        } catch (IOException e) {
            System.out.println( e.getMessage());
        }
        return list;
    }
}
