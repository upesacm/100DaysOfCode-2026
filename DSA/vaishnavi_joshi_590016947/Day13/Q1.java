import java.util.*;

public class MostCommonWord {

    public static String mostCommonWord(String paragraph, String[] banned) {

        Set<String> bannedSet = new HashSet<>();
        for (String word : banned) {
            bannedSet.add(word.toLowerCase());
        }

        Map<String, Integer> map = new HashMap<>();

        paragraph = paragraph.toLowerCase().replaceAll("[^a-z]", " ");

        String[] words = paragraph.split("\\s+");

        String answer = "";
        int max = 0;

        for (String word : words) {

            if (word.length() == 0 || bannedSet.contains(word))
                continue;

            int count = map.getOrDefault(word, 0) + 1;
            map.put(word, count);

            if (count > max) {
                max = count;
                answer = word;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input paragraph
        String paragraph = sc.nextLine();

        // Number of banned words
        int n = Integer.parseInt(sc.nextLine());

        String[] banned = new String[n];

        for (int i = 0; i < n; i++) {
            banned[i] = sc.nextLine();
        }

        System.out.println(mostCommonWord(paragraph, banned));

        sc.close();
    }
}