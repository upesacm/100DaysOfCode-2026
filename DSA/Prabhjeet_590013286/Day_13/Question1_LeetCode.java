//Need to find the most frequent word that's not banned

import java.util.*;

class Solution {

    public String mostCommonWord(String paragraph, String[] banned) {

        HashSet<String> bannedWords = new HashSet<>();

        // putting all banned words in a set for quick lookup
        for (String word : banned) {
            bannedWords.add(word);
        }

        HashMap<String, Integer> freq = new HashMap<>();

        paragraph = paragraph.toLowerCase();

        StringBuilder word = new StringBuilder();

        String ans = "";
        int maxFreq = 0;

        for (int i = 0; i <= paragraph.length(); i++) {

            // keep building the current word
            if (i < paragraph.length() && Character.isLetter(paragraph.charAt(i))) {

                word.append(paragraph.charAt(i));

            } else {

                if (word.length() > 0) {

                    String curr = word.toString();

                    // ignore it if it's banned
                    if (!bannedWords.contains(curr)) {

                        freq.put(curr, freq.getOrDefault(curr, 0) + 1);

                        // found a better answer
                        if (freq.get(curr) > maxFreq) {

                            maxFreq = freq.get(curr);
                            ans = curr;
                        }
                    }

                    // ready to start the next word
                    word.setLength(0);
                }
            }
        }

        return ans;
    }
}