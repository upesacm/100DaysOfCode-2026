import java.util.*;

public class SmallDistinctWindow {

    public static int findSubString(String str) {
        int n = str.length();

        // Count total distinct characters
        boolean[] visited = new boolean[256];
        int distinct = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[str.charAt(i)]) {
                visited[str.charAt(i)] = true;
                distinct++;
            }
        }

        int[] freq = new int[256];
        int start = 0;
        int count = 0;
        int minLen = Integer.MAX_VALUE;

        for (int end = 0; end < n; end++) {
            char ch = str.charAt(end);

            freq[ch]++;

            if (freq[ch] == 1)
                count++;

            while (count == distinct) {
                minLen = Math.min(minLen, end - start + 1);

                freq[str.charAt(start)]--;

                if (freq[str.charAt(start)] == 0)
                    count--;

                start++;
            }
        }

        return minLen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input String
        String str = sc.nextLine();

        System.out.println(findSubString(str));

        sc.close();
    }
}