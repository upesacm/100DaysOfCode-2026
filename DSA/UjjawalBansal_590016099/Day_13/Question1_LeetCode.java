class Question1_LeetCode {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bSet = new HashSet<>(Arrays.asList(banned));
        String[] words = paragraph.toLowerCase().split("[!?',;. ]+");
        
        HashMap<String, Integer> count = new HashMap<>();
        int c = 0;
        String ans = "";
        for (String w: words) {
            if (!bSet.contains(w)) {
                int a = count.getOrDefault(w, 0) +1;
                count.put(w, a);

                if(c<a) {
                    c = a;
                    ans = w;
                }
            }
        }
        return ans;
    }
}