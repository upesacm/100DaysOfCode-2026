import java.util.*;

public class MostFrequentWord {

    public static String mostCommonWord(String paragraph, String[] banned) {

        // Step 1: Build banned set
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));

        // Step 2: Normalize — lowercase + replace punctuation with space
        String cleaned = paragraph.toLowerCase().replaceAll("[!?',;.]", " ");

        // Step 3: Split into words
        String[] words = cleaned.split("\\s+");

        // Step 4: Count frequencies (skip banned)
        Map<String, Integer> freq = new HashMap<>();
        for (String word : words) {
            if (!word.isEmpty() && !bannedSet.contains(word)) {
                freq.put(word, freq.getOrDefault(word, 0) + 1);
            }
        }

        // Step 5: Find the word with max frequency
        String result = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : freq.entrySet()) {
            if (entry.getValue() > maxCount) {
                maxCount = entry.getValue();
                result = entry.getKey();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        System.out.println(mostCommonWord(
            "Bob hit a ball, the hit BALL flew far after it was hit.",
            new String[]{"hit"}
        )); // Output: ball

        System.out.println(mostCommonWord(
            "a.",
            new String[]{}
        )); // Output: a
    }
}
