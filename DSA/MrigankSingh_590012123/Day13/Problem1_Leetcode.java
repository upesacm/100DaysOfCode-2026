import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem1_Leetcode {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedWords = new HashSet<>();
        for (String word : banned) {
            bannedWords.add(word.toLowerCase());
        }

        Map<String, Integer> frequency = new HashMap<>();
        StringBuilder currentWord = new StringBuilder();
        String answer = "";
        int bestCount = 0;

        for (int i = 0; i <= paragraph.length(); i++) {
            char currentChar = i < paragraph.length() ? paragraph.charAt(i) : ' ';
            if (Character.isLetter(currentChar)) {
                currentWord.append(Character.toLowerCase(currentChar));
            } else if (currentWord.length() > 0) {
                String word = currentWord.toString();
                currentWord.setLength(0);
                if (!bannedWords.contains(word)) {
                    int count = frequency.getOrDefault(word, 0) + 1;
                    frequency.put(word, count);
                    if (count > bestCount) {
                        bestCount = count;
                        answer = word;
                    }
                }
            }
        }

        return answer;
    }
}