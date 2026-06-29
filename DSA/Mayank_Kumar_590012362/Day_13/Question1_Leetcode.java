class Solution {
    public String mostCommonWord(String p, String[] b) {
        String s = p.replaceAll("[^a-zA-Z0-9 ]", " ").toLowerCase();
        String[] w = s.split("\\s+");
        Set<String> x = new HashSet<>();
        for (String i : b) x.add(i);
        Map<String, Integer> m = new HashMap<>();
        for (String i : w) {
            if (!x.contains(i)) m.put(i, m.getOrDefault(i, 0) + 1);
        }
        return Collections.max(m.entrySet(), Map.Entry.comparingByValue()).getKey();
    }
}