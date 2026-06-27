import java.util.*;

public class Question2 {

    public static int smallestWindow(String str) {

        Set<Character> unique = new HashSet<>();

        for (char ch : str.toCharArray()) {
            unique.add(ch);
        }

        int required = unique.size();

        HashMap<Character, Integer> map = new HashMap<>();

        int left = 0;
        int formed = 0;
        int answer = Integer.MAX_VALUE;

        for (int right = 0; right < str.length(); right++) {

            char ch = str.charAt(right);

            map.put(ch, map.getOrDefault(ch, 0) + 1);

            if (map.get(ch) == 1) {
                formed++;
            }

            while (formed == required) {

                answer = Math.min(answer, right - left + 1);

                char leftChar = str.charAt(left);

                map.put(leftChar, map.get(leftChar) - 1);

                if (map.get(leftChar) == 0) {
                    formed--;
                }

                left++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        System.out.println(smallestWindow(str));

        sc.close();
    }
}