import java.util.*;

class Question1_leetcode {
    public String mostCommonWord(String paragraph, String[] banned) {
        // 1. Put banned words into a set for fast O(1) lookups
        Set<String> bannedSet = new HashSet<>();
        for (String word : banned) {
            bannedSet.add(word.toLowerCase());
        }

        // 2. Clean paragraph and split by any non-letter character
        String[] words = paragraph.toLowerCase().split("[^a-zA-Z]+");

        // 3. Count frequencies of non-banned words
        Map<String, Integer> wordCounts = new HashMap<>();
        String mostFrequentWord = "";
        int maxCount = 0;

        for (String word : words) {
            if (word.isEmpty() || bannedSet.contains(word)) {
                continue;
            }

            int currentCount = wordCounts.getOrDefault(word, 0) + 1;
            wordCounts.put(word, currentCount);

            if (currentCount > maxCount) {
                maxCount = currentCount;
                mostFrequentWord = word;
            }
        }

        return mostFrequentWord;
    }
}