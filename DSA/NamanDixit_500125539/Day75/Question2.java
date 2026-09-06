import java.util.*;

public class Question2 {

    /*
     * Each road is given as:
     * [from, to, cost]
     *
     * The cities form a RING.
     *
     * To make the whole ring strongly connected,
     * all roads must point in the SAME circular direction.
     *
     * We have two choices:
     *
     * Direction 1:
     *     1 -> 2 -> 3 -> ... -> 1
     *
     * Direction 2:
     *     1 -> n -> n-1 -> ... -> 1
     *
     * We calculate the cost for both directions
     * and take the minimum.
     */

    public static void main(String[] args) {

        // Scanner is used to take input from the user
        Scanner sc = new Scanner(System.in);

        // Take number of cities
        int n = sc.nextInt();

        // There are n roads in a ring
        int[][] roads = new int[n][3];

        // Take all roads as input
        // Format: from to cost
        for (int i = 0; i < n; i++) {

            roads[i][0] = sc.nextInt(); // from
            roads[i][1] = sc.nextInt(); // to
            roads[i][2] = sc.nextInt(); // cost
        }

        /*
         * cost1 = cost of making the ring go in
         * one circular direction.
         *
         * cost2 = cost of making the ring go
         * in the opposite direction.
         */
        int cost1 = 0;
        int cost2 = 0;

        /*
         * We first create a simple representation
         * of the ring.
         *
         * Since the cities are numbered 1 to n,
         * the natural ring is:
         *
         * 1 - 2 - 3 - ... - n - 1
         *
         * However, the input roads may be given
         * in any order.
         *
         * For every road:
         *
         * If it goes from the smaller city to the
         * larger city, it already follows:
         *
         * 1 -> 2 -> 3 -> ... -> n
         *
         * Otherwise, it needs to be reversed
         * for that direction.
         *
         * The special road between n and 1 follows
         * the ring direction n -> 1.
         */

        for (int i = 0; i < n; i++) {

            int from = roads[i][0];
            int to = roads[i][1];
            int cost = roads[i][2];

            /*
             * Check if the road follows the direction:
             *
             * 1 -> 2 -> 3 -> ... -> n -> 1
             */

            boolean followsFirstDirection;

            if (from == n && to == 1) {

                // n -> 1 is correct
                followsFirstDirection = true;

            } else if (to == from + 1) {

                // Example: 1 -> 2, 2 -> 3, 3 -> 4
                followsFirstDirection = true;

            } else {

                // The road is pointing in the wrong direction
                followsFirstDirection = false;
            }

            /*
             * If the road is already pointing correctly,
             * no reversal cost is needed.
             *
             * Otherwise, we must reverse it.
             */
            if (!followsFirstDirection) {
                cost1 += cost;
            }

            /*
             * For the opposite direction:
             *
             * 1 <- 2 <- 3 <- ... <- n <- 1
             *
             * A road that follows the first direction
             * must now be reversed.
             *
             * A road that did NOT follow the first direction
             * is already correct.
             */
            if (followsFirstDirection) {
                cost2 += cost;
            }
        }

        /*
         * We can choose either circular direction.
         *
         * Therefore, take the smaller cost.
         */
        int answer = Math.min(cost1, cost2);

        // Print the minimum cost
        System.out.println(answer);

        // Close Scanner
        sc.close();
    }
}


/*
===========================================================
EXAMPLE
===========================================================

Input:

3
1 3 1
1 2 1
3 2 1


The roads are:

1 -> 3
1 -> 2
3 -> 2


The ring is:

        1
       / \
      2---3


We can choose this direction:

1 -> 3 -> 2 -> 1

Current roads:

1 -> 3    CORRECT
3 -> 2    CORRECT
1 -> 2    WRONG

So we reverse:

1 -> 2

Cost = 1


The ring becomes:

1 -> 3 -> 2 -> 1

Now every city can reach every other city.

Therefore:

Output:
1


===========================================================
WHY DOES THIS MAKE THE GRAPH STRONGLY CONNECTED?
===========================================================

A directed ring is strongly connected when every road
points around the ring in the same direction.

For example:

1 -> 2 -> 3 -> 4 -> 1

From any city, we can keep following the arrows
and eventually reach every other city.

So we only have two possible final directions:

1) 1 -> 2 -> 3 -> ... -> n -> 1

OR

2) 1 -> n -> n-1 -> ... -> 2 -> 1

We calculate the reversal cost for both and choose
the smaller one.


===========================================================
TIME COMPLEXITY
===========================================================

We look at every road only once.

Time:  O(n)

Space: O(n)     // To store the roads
*/