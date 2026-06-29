class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {

        paragraph = paragraph.toLowerCase().replaceAll("[^a-z]", " ");
        String[] words = paragraph.split("\\s+");

        Arrays.sort(words);

        String ans = "";
        int max = 0;

        for (int i = 0; i < words.length;) {

            boolean ban = false;
            for (String b : banned)
                if (words[i].equals(b))
                    ban = true;

            int count = 0;
            String w = words[i];

            while (i < words.length && words[i].equals(w)) {
                count++;
                i++;
            }

            if (!ban && count > max) {
                max = count;
                ans = w;
            }
        }

        return ans;
    }
}