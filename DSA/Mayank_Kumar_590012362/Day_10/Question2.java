import java.util.HashSet;
class Question2 {
    public static String detGen(String s) {
        HashSet<Character> set = new HashSet<>();
        for (char ch : s.toCharArray()) set.add(ch);
        return (set.size() % 2 == 0) ? "CHAT WITH HER!" : "IGNORE HIM!";
    }
}