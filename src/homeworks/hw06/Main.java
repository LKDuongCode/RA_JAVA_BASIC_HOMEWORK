package homeworks.hw06;

import java.io.*;

public class Main {
    public static void main(String[] args) {
        String inputPath = "src/homeworks/hw06/input.txt";
        String outputPath = "src/homeworks/hw06/copy.txt";
        String originalContent = "hello java";

        createFileIfNotExists(inputPath, originalContent);

        String content = readText(inputPath);
        System.out.println("ban đầu:" + content);

        String reversed = new StringBuilder(content).reverse().toString();

        writeText(outputPath, reversed);

        System.out.println("đã đảo:" + readText(outputPath));
    }

    static void createFileIfNotExists(String path, String content) {
        File file = new File(path);
        try {
            if (!file.exists()) {
                try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
                    writer.write(content);
                }
            } else {
                System.out.println("đã tồn tại");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    static String readText(String path) {
        StringBuilder result = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while((line = reader.readLine()) != null) {
                result.append(line).append("\n");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return result.toString().trim();
    }

    static void writeText(String path, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            writer.write(content);
            System.out.println("Ghi vào file copy.txt thành công");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
