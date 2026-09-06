class Solution {
    public int turnOff(int n) {
        return n & (n - 1);
    }
}