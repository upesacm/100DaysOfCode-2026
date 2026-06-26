public class Problem2 {
    public String determineGender(String username) {
        boolean[] seen = new boolean[26];
        int distinct = 0;
        for (int i = 0; i < username.length(); i++) {
            int index = username.charAt(i) - 'a';
            if (!seen[index]) {
                seen[index] = true;
                distinct++;
            }
        }
        if (distinct % 2 == 0) {
            return "CHAT WITH HER!";
        }
        return "IGNORE HIM!";
    }
}