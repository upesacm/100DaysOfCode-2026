
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Question2 {

    public static int countDistinctSubsequences(String s) {
        // map to store the total subsequences ending right before a character's last appearance
        Map<Character, Integer> lastSeenCount = new HashMap<>();

        // Base case: an empty string has 1 subsequence (the empty string itself)
        int currentCount = 1;

        for (char ch : s.toCharArray()) {
            int previousCount = currentCount;

            // 1. Double the current count (include or exclude the new character)
            currentCount = 2 * previousCount;

            // 2. If we've seen this character before, subtract the duplicate paths
            if (lastSeenCount.containsKey(ch)) {
                currentCount -= lastSeenCount.get(ch);
            }

            // 3. Save the snapshot of what the count *was* right before this character
            lastSeenCount.put(ch, previousCount);
        }

        return currentCount;
    }

    public static String betterString(String s1, String s2) {
        int count1 = countDistinctSubsequences(s1);
        int count2 = countDistinctSubsequences(s2);

        // Return s1 if they are equal or if s1 is greater
        return (count2 > count1) ? s2 : s1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter s1: ");
        String s1 = sc.next();
        System.out.print("Enter s2: ");
        String s2 = sc.next();

        System.out.println("The better string is: " + betterString(s1, s2));
        sc.close();
    }
}
