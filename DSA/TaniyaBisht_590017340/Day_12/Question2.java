
import java.util.*;
class Dist{
    public static void main(String[] args) {
        String str = "abcda";
        HashSet<Character> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }
        int dist = set.size();
        int minlen = Integer.MAX_VALUE;
        for (int i = 0; i < str.length(); i++) {
            HashSet<Character> temp = new HashSet<>();
            for (int j = i; j < str.length(); j++) {
                temp.add(str.charAt(j));
                if (temp.size() == dist) {
                    minlen = Math.min(minlen, j - i + 1);
                    break;
                }
            }
        }
        System.out.println(minlen);
    }
}