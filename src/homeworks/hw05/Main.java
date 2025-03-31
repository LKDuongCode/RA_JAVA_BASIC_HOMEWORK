package homeworks.hw05;

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/homeworks/hw05/input.txt";
        List<String> players = Arrays.asList(
                "Văn Lâm", "Tiến Linh", "Xuân Son", "Hoàng Đức", "Văn Hậu"
        );
        createFileIfNotExists(filePath, players);

        List<String> names = readLines(filePath);

        findLongestName(names);
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
                System.out.println("File đã tồn tại");
            }
        } catch (IOException e) {
            System.out.println( e.getMessage());
        }
    }


    static List<String> readLines(String path) {
        List<String> lines = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                lines.add(line);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return lines;
    }

    static void findLongestName(List<String> names) {
        if (names.isEmpty()) {
            System.out.println("rỗng.");
            return;
        }

        String longest = Collections.max(names, Comparator.comparingInt(String::length));
        System.out.println("dài nhất: " + longest);
        System.out.println(longest.length() + " ký tự");
    }
}


