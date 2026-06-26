import java.util.*;

class Solution {

    public int shortestSubstring(String str) {

        HashSet<Character> set = new HashSet<>();

        for (char ch : str.toCharArray()) {
            set.add(ch);
        }

        int required = set.size();

        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int answer = Integer.MAX_VALUE;

        for (int right = 0; right < str.length(); right++) {

            char ch = str.charAt(right);
            map.put(ch, map.getOrDefault(ch, 0) + 1);

            while (map.size() == required) {

                answer = Math.min(answer, right - left + 1);

                char leftChar = str.charAt(left);
                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    map.remove(leftChar);
                }

                left++;
            }
        }

        return answer;
    }
}