package DSA.Mugdha_590015431.Day_13;
import java.util.*;
public class Question1_LeetCode {
     public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String paragraph = sc.nextLine();

        int n = sc.nextInt();
        sc.nextLine();

        String[] banned = new String[n];
        for(int i = 0; i < n; i++) {
            banned[i] = sc.nextLine();
        }

        System.out.println(mostCommonWord(paragraph, banned));

        sc.close();
    }

    public static String mostCommonWord(String paragraph, String[] banned) {

        HashSet<String> bannedSet = new HashSet<>();

        for(String word : banned) {
            bannedSet.add(word.toLowerCase());
        }

        paragraph = paragraph.toLowerCase().replaceAll("[^a-z]", " ");

        String[] words = paragraph.split("\\s+");

        HashMap<String, Integer> map = new HashMap<>();

        String answer = "";
        int maxFreq = 0;

        for(String word : words) {

            if(word.length() == 0 || bannedSet.contains(word))
                continue;

            map.put(word, map.getOrDefault(word, 0) + 1);

            if(map.get(word) > maxFreq) {
                maxFreq = map.get(word);
                answer = word;
            }
        }

        return answer;
    }
}
