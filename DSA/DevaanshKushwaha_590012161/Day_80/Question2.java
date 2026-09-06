public class Solution {
    /**
     * Returns true if n is 0 or a power of two.
     * A power of two has exactly one set bit (e.g. 1000 in binary).
     * n & (n - 1) clears the lowest set bit:
     *   - For a power of two, this leaves 0 (only one bit was set).
     *   - For n = 0, n - 1 underflows to all 1s, but 0 & anything = 0.
     * So checking (n & (n - 1)) == 0 covers BOTH cases in one line.
     */
    public boolean isPowerOfTwoOrZero(int n) {
        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] tests = {0, 1, 2, 3, 4, 5, 16, 17, 1024, 1023, 2147483647};
        for (int n : tests) {
            System.out.println("n = " + n + " -> " + sol.isPowerOfTwoOrZero(n));
        }
    }
}
