
class Solution {

    public int hammingWeight(int n) {

        // Variable to store the number of 1 bits
        int count = 0;

        // Check all 32 bits
        while (n != 0) {

            // If the last bit is 1, increase the count
            if ((n & 1) == 1) {
                count++;
            }

            // Unsigned right shift by 1 bit
            // This moves to the next bit
            n = n >>> 1;
        }

        // Return the total number of 1 bits
        return count;
    }
}
