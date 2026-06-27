import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Smallest_distinct_window {
    public static void main (String[] args) {
        String str = "aabcbcdbca";


        Set<Character> distinctChars = new HashSet<>();
        for (char c : str.toCharArray()) {
            distinctChars.add(c);
        }
        //minimum length of substring having all distinct characters
        int required = distinctChars.size();

        HashMap<Character, Integer> map = new HashMap<>();
        
        int left = 0 , right = 0;
        int minLength = Integer.MAX_VALUE;

        for( right = 0 ; right < str.length() ; right++ ){

            char ch = str.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while ( map.size() == required ) {

                minLength = Math.min(minLength, right - left + 1);

                char leftChar = str.charAt(left);

                map.put(leftChar, map.get(leftChar) - 1);
                
                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }
                left++;
            }
        }
        System.out.println(minLength);
    }
}
