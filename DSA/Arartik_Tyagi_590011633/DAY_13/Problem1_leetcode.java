import java.util.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {

        Set<String> bannedSet = new HashSet<>();
        for (String word : banned) {
            bannedSet.add(word);
        }

        Map<String, Integer> map = new HashMap<>();

        // Convert to lowercase and replace punctuation with spaces
        paragraph = paragraph.toLowerCase().replaceAll("[^a-z]", " ");

        String[] words = paragraph.split("\\s+");

        String result = "";
        int maxFreq = 0;

        for (String word : words) {
            if (!word.isEmpty() && !bannedSet.contains(word)) {
                int freq = map.getOrDefault(word, 0) + 1;
                map.put(word, freq);

                if (freq > maxFreq) {
                    maxFreq = freq;
                    result = word;
                }
            }
        }

        return result;
    }
}