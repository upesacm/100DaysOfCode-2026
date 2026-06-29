import java.util.*;

class Solution {

    public String mostCommonWord(String paragraph, String[] banned) {

        HashSet<String> ban = new HashSet<>();

        for (String word : banned) {
            ban.add(word);
        }

        HashMap<String, Integer> map = new HashMap<>();

        paragraph = paragraph.toLowerCase();

        paragraph = paragraph.replaceAll("[!?',;.]", " ");

        String[] words = paragraph.split("\\s+");

        String answer = "";
        int maxFreq = 0;

        for (String word : words) {

            if (ban.contains(word)) {
                continue;
            }

            map.put(word, map.getOrDefault(word, 0) + 1);

            if (map.get(word) > maxFreq) {
                maxFreq = map.get(word);
                answer = word;
            }
        }

        return answer;
    }
}