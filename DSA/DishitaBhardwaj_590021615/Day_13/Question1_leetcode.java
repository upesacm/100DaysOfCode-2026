class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        String lower = paragraph.toLowerCase();
        String[] words = lower.split("\\W+"); 
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> counts = new HashMap<>();
        for (String word : words) {
            if (!bannedSet.contains(word)) {
                counts.put(word, counts.getOrDefault(word, 0) + 1);
            }
        }
        String result = "";
        int maxCount = 0;
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            if (entry.getValue() > maxCount) {
                result = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        return result;
    }
}
