class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String[] words = paragraph.replaceAll("[^a-zA-Z]", " ").toLowerCase().split("\\s+");
        
        String[] foundWord = new String[words.length];
        int[] counts = new int[words.length];
        int uniqCount = 0;
        
        for (String word : words) {
            if (word.isEmpty()) continue;
            
            boolean isBanned = false;
            for (String b : banned) {
                if (word.equals(b)) {
                    isBanned = true;
                    break;
                }
            }
            if (isBanned) continue;
            
            int index = -1;
            for (int i = 0; i < uniqCount; i++) {
                if (foundWord[i].equals(word)) {
                    index = i;
                    break;
                }
            }
            
            if (index != -1) {
                counts[index]++;
            } else {
                foundWord[uniqCount] = word;
                counts[uniqCount] = 1;
                uniqCount++;
            }
        }
        
        String result = "";
        int maxCount = 0;
        for (int i = 0; i < uniqCount; i++) {
            if (counts[i] > maxCount) {
                maxCount = counts[i];
                result = foundWord[i];
            }
        }
        
        return result;
    }
}