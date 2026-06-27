class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedW = new HashSet<>(Arrays.asList(banned));
        Map<String, Integer> freq = new HashMap<>();
        paragraph = paragraph.toLowerCase().replaceAll("[^a-z]", " ");
        String[] words = paragraph.split("\\s+");
        String result = "";
        int maxCount = 0;

        for (String word : words) 
        {
            if (!word.isEmpty() && !bannedW.contains(word)) 
            {
                int count = freq.getOrDefault(word, 0) + 1;
                freq.put(word, count);

                if (count > maxCount) 
                {
                    maxCount = count;
                    result = word;
                }
            }
        }
        return result;
    }
}
