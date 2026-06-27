import java.util.*;
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>();
        for (String word : banned) {
            bannedSet.add(word);
        }
        paragraph = paragraph.toLowerCase().replaceAll("[^a-z]", " ");
        String[] words = paragraph.split("\\s+");
        Map<String, Integer> freq = new HashMap<>();
        String answer = "";
        int maxCount = 0;
        for (String word : words) {
            if (!word.isEmpty() && !bannedSet.contains(word)) {
                int count = freq.getOrDefault(word, 0) + 1;
                freq.put(word, count);
                if (count > maxCount) {
                    maxCount = count;
                    answer = word;
                }
            }
        }
        return answer;
    }
}
