import java.util.*;

class Question1_leetcode {

    public int singleNumber(int[] nums) {

        // XOR of 0 with any number gives that number
        int answer = 0;

        // Go through every number in the array
        for (int num : nums) {

            // XOR the current number with answer
            answer = answer ^ num;
        }

        // Return the number that appears only once
        return answer;
    }
}


/*
========================================================
MAIN METHOD FOR TESTING
========================================================

LeetCode does NOT need the main() method.

The main() method is only here because you asked
to take input from the user.
*/

class Main {

    public static void main(String[] args) {

        // Scanner is used to take input
        Scanner sc = new Scanner(System.in);

        // Take the number of elements
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        // Create the array
        int[] nums = new int[n];

        // Take all elements
        System.out.println("Enter the elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Create Solution object
        Solution solution = new Solution();

        // Find the single number
        int answer = solution.singleNumber(nums);

        // Print the answer
        System.out.println("Single number = " + answer);

        // Close Scanner
        sc.close();
    }
}


/*
========================================================
EXAMPLE
========================================================

Input:

5
4 1 2 1 2

XOR works like this:

0 ^ 4 = 4
4 ^ 1 = 5
5 ^ 2 = 7
7 ^ 1 = 6
6 ^ 2 = 4

Answer = 4


========================================================
WHY XOR?
========================================================

Important XOR properties:

1. x ^ x = 0

   Example:
   5 ^ 5 = 0


2. x ^ 0 = x

   Example:
   5 ^ 0 = 5


3. XOR order does not matter.

   So:

   4 ^ 1 ^ 2 ^ 1 ^ 2

   can be rearranged as:

   4 ^ (1 ^ 1) ^ (2 ^ 2)

   = 4 ^ 0 ^ 0

   = 4


Therefore, all numbers that appear twice
cancel each other out.

Only the number appearing once remains.


========================================================
TIME COMPLEXITY
========================================================

We visit every element once.

Time:  O(n)

We use only one extra variable.

Space: O(1)

This satisfies the LeetCode requirement:
linear time + constant space.
*/