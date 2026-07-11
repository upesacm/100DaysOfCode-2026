import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(shortestSubstring(s));

        sc.close();
    }

    public static int shortestSubstring(String s) {
        Set<Character> all = new HashSet<>();
        for (char c : s.toCharArray()) {
            all.add(c);
        }

        int totalDistinct = all.size();
        int minLen = s.length();

        for (int i = 0; i < s.length(); i++) {
            Set<Character> seen = new HashSet<>();
            for (int j = i; j < s.length(); j++) {
                seen.add(s.charAt(j));
                if (seen.size() == totalDistinct) {
                    minLen = Math.min(minLen, j - i + 1);
                    break;
                }
            }
        }

        return minLen;
    }
}
