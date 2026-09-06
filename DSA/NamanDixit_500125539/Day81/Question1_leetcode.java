class Question1_leetcode {
     // Function to find Hamming Distance
    static int hammingDistance(int x, int y) {

        // XOR compares the bits of x and y
        //
        // XOR rules:
        // 0 ^ 0 = 0  -> same
        // 1 ^ 1 = 0  -> same
        // 0 ^ 1 = 1  -> different
        // 1 ^ 0 = 1  -> different
        //
        // So, XOR gives 1 wherever the bits are different.
        int xor = x ^ y;

        // This variable will count how many 1s are present
        // in the XOR result.
        int count = 0;

        // Keep checking until all 1s are removed
        while (xor != 0) {

            // xor & 1 checks the last bit
            //
            // If the last bit is 1,
            // the two original numbers had different bits.
            if ((xor & 1) == 1) {
                count++;
            }

            // Right shift by 1
            // This removes the last bit
            // and moves the next bit into its place.
            xor = xor >> 1;
        }

        // Return the total number of different bits
        return count;
    }
}