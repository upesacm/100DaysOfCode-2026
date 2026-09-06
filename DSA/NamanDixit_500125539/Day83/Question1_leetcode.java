class Question1_leetcode {
    // Function to find the number that appears only once
    static int singleNumber(int[] nums) {

        // This will store our final answer
        int answer = 0;

        // An integer has 32 bits
        // So we check every bit position
        for (int bit = 0; bit < 32; bit++) {

            // This counts how many times
            // the current bit is 1
            int count = 0;

            // Check every number in the array
            for (int num : nums) {

                // Move the required bit to the last position
                // and check whether it is 1
                //
                // Example:
                // num = 5 = 0101
                //
                // If bit = 0:
                // 0101 >> 0 = 0101
                // 0101 & 0001 = 0001
                //
                // So the bit is 1
                if (((num >> bit) & 1) == 1) {

                    // Increase the count
                    count++;
                }
            }

            // Numbers appearing 3 times
            // will make the count a multiple of 3.
            //
            // If there is a remainder of 1,
            // that bit belongs to the unique number.
            if (count % 3 == 1) {

                // Put a 1 at this bit position
                answer = answer | (1 << bit);
            }
        }

        // Return the unique number
        return answer;
    }

}