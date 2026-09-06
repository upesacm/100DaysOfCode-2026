import java.util.*;

class Question1_leetcode {

    // Modulo value given by LeetCode
    static final long MOD = 1000000007;

    public int waysToBuildRooms(int[] prevRoom) {

        // Number of rooms
        int n = prevRoom.length;

        // Create the tree
        List<List<Integer>> tree = new ArrayList<>();

        // Create an empty list for every room
        for (int i = 0; i < n; i++) {
            tree.add(new ArrayList<>());
        }

        // Build the tree
        // prevRoom[i] is the parent of room i
        for (int i = 1; i < n; i++) {

            int parent = prevRoom[i];

            // Add room i as a child of its parent
            tree.get(parent).add(i);
        }

        /*
         * factorial[i] = i!
         *
         * We need factorials to calculate the answer.
         */
        long[] factorial = new long[n + 1];

        factorial[0] = 1;

        for (int i = 1; i <= n; i++) {

            factorial[i] =
                    factorial[i - 1] * i % MOD;
        }

        /*
         * inverseFactorial[i] = 1 / i! modulo MOD
         */
        long[] inverseFactorial = new long[n + 1];

        inverseFactorial[n] =
                power(factorial[n], MOD - 2);

        // Calculate all inverse factorials
        for (int i = n - 1; i >= 0; i--) {

            inverseFactorial[i] =
                    inverseFactorial[i + 1] * (i + 1) % MOD;
        }

        /*
         * subtreeSize[i] tells us the number of rooms
         * in the subtree starting from room i.
         */
        int[] subtreeSize = new int[n];

        /*
         * We use iterative DFS.
         *
         * This is safer than recursive DFS because
         * n can be as large as 100000.
         */
        int[] order = new int[n];
        int[] stack = new int[n];

        int top = 0;
        int index = 0;

        // Start DFS from room 0
        stack[top++] = 0;

        // Store nodes in DFS order
        while (top > 0) {

            // Take one node
            int node = stack[--top];

            // Store it
            order[index++] = node;

            // Add all children
            for (int child : tree.get(node)) {
                stack[top++] = child;
            }
        }

        /*
         * Process from bottom to top.
         *
         * Children must be calculated before parents.
         */
        for (int i = n - 1; i >= 0; i--) {

            // Current room
            int node = order[i];

            // Count the room itself
            subtreeSize[node] = 1;

            // Add all children's subtree sizes
            for (int child : tree.get(node)) {

                subtreeSize[node] += subtreeSize[child];
            }
        }

        /*
         * IMPORTANT FORMULA:
         *
         * Answer =
         *
         *              n!
         * --------------------------------
         * product of all subtree sizes
         *
         *
         * For:
         *
         * [-1, 0, 1]
         *
         * Tree:
         *
         * 0
         * |
         * 1
         * |
         * 2
         *
         * Subtree sizes:
         *
         * room 0 = 3
         * room 1 = 2
         * room 2 = 1
         *
         * Answer:
         *
         * 3! / (3 * 2 * 1)
         *
         * = 6 / 6
         *
         * = 1
         *
         * This is the important correction.
         */

        long answer = factorial[n];

        // Divide by every subtree size
        for (int i = 0; i < n; i++) {

            /*
             * Find inverse of subtreeSize[i].
             *
             * 1 / x =
             *
             * (x - 1)! / x!
             */
            long inverseSize =
                    factorial[subtreeSize[i] - 1]
                    * inverseFactorial[subtreeSize[i]]
                    % MOD;

            // Multiply by inverse instead of dividing
            answer =
                    answer * inverseSize % MOD;
        }

        // Return final answer
        return (int) answer;
    }


    /*
     * Fast exponentiation.
     *
     * Calculates:
     *
     * base^exponent % MOD
     */
    private long power(long base, long exponent) {

        long result = 1;

        while (exponent > 0) {

            // If exponent is odd
            if (exponent % 2 == 1) {

                result =
                        result * base % MOD;
            }

            // Square the base
            base =
                    base * base % MOD;

            // Divide exponent by 2
            exponent /= 2;
        }

        return result;
    }
}
