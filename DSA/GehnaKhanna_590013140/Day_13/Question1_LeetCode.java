import java.util.*;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {

        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> freq = new HashMap<>();

        StringBuilder word = new StringBuilder();
        String ans = "";
        int maxFreq = 0;

        for (int i = 0; i <= paragraph.length(); i++) {

            if (i < paragraph.length() && Character.isLetter(paragraph.charAt(i))) {
                word.append(Character.toLowerCase(paragraph.charAt(i)));
            } else if (word.length() > 0) { // End of a word

                String w = word.toString();

                if (!bannedSet.contains(w)) {
                    int count = freq.getOrDefault(w, 0) + 1;
                    freq.put(w, count);

                    if (count > maxFreq) {
                        maxFreq = count;
                        ans = w;
                    }
                }

                word.setLength(0); 
            }
        }

        return ans;
    }
}
