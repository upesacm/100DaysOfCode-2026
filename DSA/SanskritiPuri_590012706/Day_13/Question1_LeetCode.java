class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        // Store banned words in a HashSet
        Set<String> bannedWords = new HashSet<>();
        for (String word : banned) {
            bannedWords.add(word.toLowerCase());
        }

        // Store frequency of valid words
        Map<String, Integer> freq = new HashMap<>();

        // Replace punctuation with spaces and convert to lowercase
        paragraph = paragraph.toLowerCase().replaceAll("[^a-z]", " ");

        // Split paragraph into words
        String[] words = paragraph.split("\\s+");

        String answer = "";
        int maxFreq = 0;

        for (String word : words) {
            if (word.length() == 0 || bannedWords.contains(word))
                continue;

            freq.put(word, freq.getOrDefault(word, 0) + 1);

            if (freq.get(word) > maxFreq) {
                maxFreq = freq.get(word);
                answer = word;
            }
        }

        return answer;
        
    }
}
