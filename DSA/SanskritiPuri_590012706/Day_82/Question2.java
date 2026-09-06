class Solution {
    public int turnOffRightmostSetBit(int n) {
        return n & (n - 1);
    }
}
