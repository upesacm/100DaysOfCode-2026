class Solution {
    public boolean isPowerOfTwoOrZero(int n) {
        return n == 0 || (n & (n - 1)) == 0;
    }
}
