import java.util.*;

class Question2 {
    public static String moreDistinctSubseq(String s1, String s2) {
        return count(s1) >= count(s2) ? s1 : s2;
    }

    public static long count(String s) {
        long total = 1; // empty subsequence
        Map<Character, Long> last = new HashMap<>();

        for (char c : s.toCharArray()) {
            long newTotal = total * 2;

            if (last.containsKey(c)) {
                newTotal -= last.get(c);
            }

            last.put(c, total);
            total = newTotal;
        }

        return total;
    }

    public static void main(String[] args) {
        String s1 = "abab";
        String s2 = "abba";

        System.out.println(moreDistinctSubseq(s1, s2));
    }
}