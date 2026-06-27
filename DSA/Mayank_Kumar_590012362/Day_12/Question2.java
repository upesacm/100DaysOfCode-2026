import java.util.HashSet;
import java.util.Set;
public class Question2 {
    public String shortSubs(String s) {
        Set<Character> a = new HashSet<>();
        for (char c : s.toCharArray()) a.add(c);

        int r = a.size(), m = s.length();
        for (int i = 0; i < s.length(); i++) {
            Set<Character> b = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                b.add(s.charAt(j));
                if (b.size() == r) {
                    m = Math.min(m, j - i + 1);
                    break;
                }
            }
        } return String.valueOf(m);
    }
}