package DSA.Mugdha_590015431.Day_12;
import java.util.*;
public class Question2 {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        System.out.println(smallestWindow(str));

        sc.close();
    }

    public static int smallestWindow(String str) {
        HashSet<Character> set = new HashSet<>();

        for(int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }

        int distinct = set.size();

        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int minLength = Integer.MAX_VALUE;

        for(int right = 0; right < str.length(); right++) {

            char ch = str.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while(map.size() == distinct) {

                minLength = Math.min(minLength, right - left + 1);

                char leftChar = str.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);

                if(map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }

                left++;
            }
        }

        return minLength;
    }
}
