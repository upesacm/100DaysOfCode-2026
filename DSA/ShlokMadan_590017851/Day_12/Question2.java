import java.util.HashSet;

public class Question2 {

    public static int smallestWindow(String str) {

        HashSet<Character> set = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            set.add(str.charAt(i));
        }

        int required = set.size();

        int[] freq = new int[256];

        int left = 0;
        int count = 0;
        int answer = Integer.MAX_VALUE;

        for (int right = 0; right < str.length(); right++) {

            char ch = str.charAt(right);

            if (freq[ch] == 0) {
                count++;
            }

            freq[ch]++;

            while (count == required) {

                answer = Math.min(answer, right - left + 1);

                char leftChar = str.charAt(left);

                freq[leftChar]--;

                if (freq[leftChar] == 0) {
                    count--;
                }

                left++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {

        String str = "abcda";

        System.out.println(smallestWindow(str));
    }
}