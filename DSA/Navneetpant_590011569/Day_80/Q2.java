class Solution {
    public boolean isPowerOfTwo(int n) {
        if (n <= 0) {
            return false;
        }
        String binary = Integer.toBinaryString(n);
        for (int i = 1; i < binary.length(); i++) {
            if (binary.charAt(i) == '1') {
                return false;
            }
        }

        return true;
    }
}