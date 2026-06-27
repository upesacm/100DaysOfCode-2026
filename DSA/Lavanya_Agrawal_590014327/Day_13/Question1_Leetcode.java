import java.util.*;

public class Question1_Leetcode  {

    public static String mostCommonWord(String paragraph, String[] banned) {

        Set<String> bannedWords = new HashSet<>();

        for (String word : banned) {
            bannedWords.add(word.toLowerCase());
        }

        Map<String, Integer> frequency = new HashMap<>();

        paragraph = paragraph.toLowerCase().replaceAll("[^a-z]", " ");

        String[] words = paragraph.split("\\s+");

        String answer = "";
        int maxCount = 0;

        for (String word : words) {

            if (word.isEmpty() || bannedWords.contains(word)) {
                continue;
            }

            int count = frequency.getOrDefault(word, 0) + 1;
            frequency.put(word, count);

            if (count > maxCount) {
                maxCount = count;
                answer = word;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String paragraph = sc.nextLine();

        int n = sc.nextInt();
        sc.nextLine();

        String[] banned = new String[n];

        for (int i = 0; i < n; i++) {
            banned[i] = sc.nextLine();
        }

        System.out.println(mostCommonWord(paragraph, banned));

        sc.close();
    }
}