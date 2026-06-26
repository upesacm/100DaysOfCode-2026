package DSA.Mugdha_590015431.Day_11;
import java.util.*;
public class Question1_LeetCode {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String t = sc.nextLine();

        System.out.println(isIsomorphic(s, t));

        sc.close();
    }

    public static boolean isIsomorphic(String s, String t) {
        HashMap<Character, Character> mapST = new HashMap<>();
        HashMap<Character, Character> mapTS = new HashMap<>();

        for(int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);

            if(mapST.containsKey(c1)) {
                if(mapST.get(c1) != c2) {
                    return false;
                }
            } else {
                mapST.put(c1, c2);
            }

            if(mapTS.containsKey(c2)) {
                if(mapTS.get(c2) != c1) {
                    return false;
                }
            } else {
                mapTS.put(c2, c1);
            }
        }

        return true;
    }
}
