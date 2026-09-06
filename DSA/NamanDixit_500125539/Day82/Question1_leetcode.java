
class Question1_leetcode {

    static int numberOfSteps(int n) {

        // This variable stores the number of steps
        int steps = 0;

        // Keep running until n becomes 0
        while (n > 0) {

            // Check whether n is even or odd
            //
            // n & 1 gives the last bit of n
            //
            // Last bit = 0 -> even
            // Last bit = 1 -> odd
            if ((n & 1) == 0) {

                // If n is even,
                // divide n by 2
                n = n / 2;

            } else {

                // If n is odd,
                // subtract 1
                n = n - 1;
            }

            // One operation has been performed
            steps++;
        }

        // Return the total number of steps
        return steps;
    }
}
