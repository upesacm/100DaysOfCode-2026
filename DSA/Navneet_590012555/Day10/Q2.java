class Solution {
    public static String check(String s) {
        Set<Character> set = new HashSet<>();

        for (char c : s.toCharArray())
            set.add(c);

        return set.size() % 2 == 0 ? "CHAT WITH HER!": "IGNORE HIM!";
    }
}