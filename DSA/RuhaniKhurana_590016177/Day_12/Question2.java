import java.util.*;

public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        boolean[] present = new boolean[256];
        int tD = 0;
        for (char ch : s.toCharArray()) {
            if (!present[ch]) {
                present[ch] = true;
                tD++;
            }
        }

        int[] freq = new int[256];
        int l = 0, count = 0;
        int min = Integer.MAX_VALUE;

        for (int r = 0; r < s.length(); r++) {
            char ch = s.charAt(r);

            if (freq[ch] == 0)
                count++;
            freq[ch]++;

            while (count == tD) {
                min = Math.min(min, r - l + 1);

                char lc = s.charAt(l);
                freq[lc]--;

                if (freq[lc] == 0)
                    count--;

                l++;
            }
        }

        System.out.println(min);
    }
}