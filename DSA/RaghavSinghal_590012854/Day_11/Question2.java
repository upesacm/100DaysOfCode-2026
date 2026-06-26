public class Question2 {
    public String solve(String s) {
        String vowels = "AEIOUYaeiouy";
        StringBuilder result = new StringBuilder();

        for (char ch : s.toCharArray()) {
            if (vowels.indexOf(ch) == -1) { // not a vowel
                result.append('.').append(Character.toLowerCase(ch));
            }
        }
        return result.toString();
    }
}