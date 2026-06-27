class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {

        Set<String> bannedSet = new HashSet<>();
        for (String word : banned) {
            bannedSet.add(word);
        }

        Map<String, Integer> frequency = new HashMap<>();

        paragraph = paragraph.toLowerCase()
                             .replaceAll("[!?',;.]", " ");

        String[] words = paragraph.split("\\s+");

        String result = "";
        int highestCount = 0;

        for (String word : words) {

            if (bannedSet.contains(word)) {
                continue;
            }

            int currentCount = frequency.getOrDefault(word, 0) + 1;
            frequency.put(word, currentCount);

            if (currentCount > highestCount) {
                highestCount = currentCount;
                result = word;
            }
        }

        return result;
    }
}
