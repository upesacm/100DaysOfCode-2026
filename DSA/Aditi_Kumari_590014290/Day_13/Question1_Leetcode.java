package Day_13;
import java.util.*;
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> map = new HashMap<>();
        paragraph = paragraph.toLowerCase().replaceAll("[^a-z]", " ");
        String ans = "";
        int max = 0;
        for (String word : paragraph.split("\\s+")) {
            if (!ban.contains(word)) {
                int count = map.getOrDefault(word, 0) + 1;
                map.put(word, count);
                if (count > max) {
                    max = count;
                    ans = word;
                }
            }
        }
        return ans;
    }
}