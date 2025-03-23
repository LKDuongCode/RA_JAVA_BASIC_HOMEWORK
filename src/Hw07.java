import java.util.*;

public class Hw07 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("nhập đoạn văn bản: ");
        String inputText = sc.nextLine();
        inputText = inputText.toLowerCase().trim();

        List<String> words = new ArrayList<>(Arrays.asList(inputText.split("\\W+")));

        Set<String> uniqueWords = new HashSet<>(words);

        Iterator<String> it = words.iterator();
        Iterator<String> uniqueIt = uniqueWords.iterator();
        while (uniqueIt.hasNext()){
            System.out.println(uniqueIt.next() + ": " + Collections.frequency(words,it.next()));
        }

    }
}
