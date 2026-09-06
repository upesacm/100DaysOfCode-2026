public class Solution {
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);   // clear the lowest set bit
            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution sol = new Solution();

        // Example 1
        int n1 = 11; // binary: 1011
        System.out.println("Input: " + n1 + " -> Output: " + sol.hammingWeight(n1));
        // Expected: 3

        // Example 2
        int n2 = 128; // binary: 10000000
        System.out.println("Input: " + n2 + " -> Output: " + sol.hammingWeight(n2));
        // Expected: 1

        // Example 3
        int n3 = 2147483645; // binary: 1111111111111111111111111111101
        System.out.println("Input: " + n3 + " -> Output: " + sol.hammingWeight(n3));
        // Expected: 30
    }
}
