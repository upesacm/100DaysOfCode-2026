public class Problem2 {
    public int smallestDistinctWindow(String str) {
        int[] freq = new int[256];
        int distinctCount = 0;

        for (int i = 0; i < str.length(); i++) {
            if (freq[str.charAt(i)] == 0) {
                distinctCount++;
            }
            freq[str.charAt(i)]++;
        }
        int[] window = new int[256];
        int formed = 0;
        int left = 0;
        int answer = str.length();
        for (int right = 0; right < str.length(); right++) {
            char current = str.charAt(right);
            window[current]++;
            if (window[current] == 1) {
                formed++;
            }
            while (formed == distinctCount) {
                answer = Math.min(answer, right - left + 1);
                char leftChar = str.charAt(left);
                window[leftChar]--;
                if (window[leftChar] == 0) {
                    formed--;
                }
                left++;
            }
        }
        return answer;
    }
}