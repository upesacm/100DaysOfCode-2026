import java.util.*;

// LeetCode Problem 819: Most Common Word

class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>();
        for (String b : banned) {
            bannedSet.add(b);
        }
        
        Map<String, Integer> counts = new HashMap<>();
        int maxCount = 0;
        String result = "";
        
        StringBuilder word = new StringBuilder();
        int count = paragraph.length();
        
        for (int i = 0; i <= count; i++) {
            if (i < count && Character.isLetter(paragraph.charAt(i))) {
                word.append(Character.toLowerCase(paragraph.charAt(i)));
            } else if (word.length() > 0) {
                String w = word.toString();
                
                if (!bannedSet.contains(w)) {
                    int currentCount = counts.getOrDefault(w, 0) + 1;
                    counts.put(w, currentCount);
                    
                    if (currentCount > maxCount) {
                        maxCount = currentCount;
                        result = w;
                    }
                }
                word.setLength(0);
            }
        }
        
        return result;
    }
}
