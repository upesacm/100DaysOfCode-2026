import java.util.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> ban = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> count = new HashMap<>();

        StringBuilder word = new StringBuilder();
        String ans = "";
        int maxFreq = 0;

        paragraph += "."; // Sentinel to process the last word

        for (char c : paragraph.toCharArray()) {
            if (Character.isLetter(c)) {
                word.append(Character.toLowerCase(c));
            } else if (word.length() > 0) {
                String w = word.toString();

                if (!ban.contains(w)) {
                    int freq = count.getOrDefault(w, 0) + 1;
                    count.put(w, freq);

                    if (freq > maxFreq) {
                        maxFreq = freq;
                        ans = w;
                    }
                }

                word.setLength(0); // Clear for the next word
            }
        }

        return ans;
    }
}