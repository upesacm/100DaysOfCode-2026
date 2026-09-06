public class Question1_Leetcode {
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
}