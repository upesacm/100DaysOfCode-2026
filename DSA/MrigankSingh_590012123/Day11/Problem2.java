public class Problem2 {
    public String transformString(String s) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            char lower = Character.toLowerCase(current);
            if (lower == 'a' || lower == 'e' || lower == 'i' || lower == 'o' || lower == 'u') {
                continue;
            }
            result.append('.');
            result.append(lower);
        }
        return result.toString();
    }
}