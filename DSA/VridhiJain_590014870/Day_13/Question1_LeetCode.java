class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        paragraph = paragraph.toLowerCase();
        paragraph = paragraph.replaceAll("[^a-z ]", " ");
        String[] w = paragraph.split("\\s+");
        HashSet<String> b = new HashSet<>();
        for (String s : banned) {
            b.add(s);
        }
        HashMap<String, Integer> m = new HashMap<>();

        for (String x : w) {
            if (!b.contains(x)) {
                m.put(x, m.getOrDefault(x, 0) + 1);
            }
        }
        String a = "";
        int max = 0;
        for (String x : m.keySet()) {
            if (m.get(x) > max) {
                max = m.get(x);
                a = x;
            }
        }
        return a;
    }
}