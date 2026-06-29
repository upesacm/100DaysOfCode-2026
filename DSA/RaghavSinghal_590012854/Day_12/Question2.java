class Solution {
    public int findSubString(String str) {
        int n = str.length();

        boolean[] seen = new boolean[256];
        int distinct = 0;

        for (int i = 0; i < n; i++) {
            char ch = str.charAt(i);
            if (!seen[ch]) {
                seen[ch] = true;
                distinct++;
            }
        }

        int[] freq = new int[256];
        int count = 0;
        int left = 0;
        int minLen = Integer.MAX_VALUE;

        for (int right = 0; right < n; right++) {
            char ch = str.charAt(right);

            if (freq[ch] == 0)
                count++;

            freq[ch]++;

            while (count == distinct) {
                minLen = Math.min(minLen, right - left + 1);

                char leftChar = str.charAt(left);
                freq[leftChar]--;

                if (freq[leftChar] == 0)
                    count--;

                left++;
            }
        }

        return minLen;
    }
}