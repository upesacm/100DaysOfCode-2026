class Solution {
    public int hammingDistance(int x, int y) {
        int n = x ^ y;
        int count = 0;

        while (n != 0) {
            count += n & 1;
            n = n >>> 1;
        }

        return count;
    }
}
