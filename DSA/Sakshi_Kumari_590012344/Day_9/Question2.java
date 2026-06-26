class Solution {
    public String removeSpaces(String s) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}
