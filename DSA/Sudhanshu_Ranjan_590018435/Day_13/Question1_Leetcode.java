package DSA.Sudhanshu_Ranjan_590018435.Day_13;
import java.util.HashMap;
import java.util.HashSet;

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {

        HashSet<String> bannedWords = new HashSet<>();
        for (String word : banned)
            bannedWords.add(word);

        String ans = "";
        int maxCount = 0;
        HashMap<String, Integer> wordCount = new HashMap<>();
        StringBuilder wordBuffer = new StringBuilder();
        char[] chars = paragraph.toCharArray();

        for (int p = 0; p < chars.length; ++p) {
            char currChar = chars[p];

            if (Character.isLetter(currChar)) {
                wordBuffer.append(Character.toLowerCase(currChar));
                if (p != chars.length - 1)
                    continue;
            }

            if (wordBuffer.length() > 0) {
                String word = wordBuffer.toString();
                if (!bannedWords.contains(word)) {
                    int newCount = wordCount.getOrDefault(word, 0) + 1;
                    wordCount.put(word, newCount);
                    if (newCount > maxCount) {
                        ans = word;
                        maxCount = newCount;
                    }
                }
                wordBuffer = new StringBuilder();
            }
        }
        return ans;
    }
}