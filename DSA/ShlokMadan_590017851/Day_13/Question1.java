import java.util.*;

public class Question1 {

    public static String mostCommonWord(String paragraph, String[] banned) {

        HashSet<String> bannedWords = new HashSet<>();

        for (String word : banned) {
            bannedWords.add(word.toLowerCase());
        }

        HashMap<String, Integer> map = new HashMap<>();

        paragraph = paragraph.toLowerCase().replaceAll("[^a-z]", " ");

        String[] words = paragraph.split("\\s+");

        String answer = "";
        int max = 0;

        for (String word : words) {

            if (word.length() == 0 || bannedWords.contains(word)) {
                continue;
            }

            map.put(word, map.getOrDefault(word, 0) + 1);

            if (map.get(word) > max) {
                max = map.get(word);
                answer = word;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        String paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
        String[] banned = {"hit"};

        System.out.println(mostCommonWord(paragraph, banned));
    }
}