import java.util.*;

public class Question2 {

    /*
     * This function finds the maximum XOR of any two
     * different numbers in the array.
     *
     * XOR rules:
     *
     * 0 ^ 0 = 0
     * 1 ^ 1 = 0
     * 0 ^ 1 = 1
     * 1 ^ 0 = 1
     *
     * We use a Binary Trie to solve this efficiently.
     */

    static class TrieNode {

        // Child for bit 0
        TrieNode zero;

        // Child for bit 1
        TrieNode one;
    }

    /*
     * Insert one number into the Binary Trie.
     */
    static void insert(TrieNode root, int number) {

        // Start from the root
        TrieNode current = root;

        /*
         * Integers have 32 bits.
         *
         * We start from the most significant bit.
         */
        for (int bit = 31; bit >= 0; bit--) {

            // Get the current bit
            int currentBit = (number >> bit) & 1;

            // If bit is 0
            if (currentBit == 0) {

                // Create node if it does not exist
                if (current.zero == null) {
                    current.zero = new TrieNode();
                }

                // Move to bit 0
                current = current.zero;

            } else {

                // Create node if it does not exist
                if (current.one == null) {
                    current.one = new TrieNode();
                }

                // Move to bit 1
                current = current.one;
            }
        }
    }

    /*
     * Find the maximum XOR that 'number' can make
     * with any number already present in the Trie.
     */
    static int findMaximumXOR(TrieNode root, int number) {

        // Start from root
        TrieNode current = root;

        // This will store the XOR value
        int xor = 0;

        /*
         * For every bit:
         *
         * If our current bit is 0,
         * we WANT a 1 in the Trie.
         *
         * If our current bit is 1,
         * we WANT a 0 in the Trie.
         *
         * Different bits produce 1 in XOR.
         */
        for (int bit = 31; bit >= 0; bit--) {

            // Get current bit of the number
            int currentBit = (number >> bit) & 1;

            if (currentBit == 0) {

                /*
                 * We want 1 because:
                 *
                 * 0 ^ 1 = 1
                 *
                 * Try to go to the 'one' child.
                 */
                if (current.one != null) {

                    xor |= (1 << bit);
                    current = current.one;

                } else {

                    // Otherwise, go to zero
                    current = current.zero;
                }

            } else {

                /*
                 * We want 0 because:
                 *
                 * 1 ^ 0 = 1
                 *
                 * Try to go to the 'zero' child.
                 */
                if (current.zero != null) {

                    xor |= (1 << bit);
                    current = current.zero;

                } else {

                    // Otherwise, go to one
                    current = current.one;
                }
            }
        }

        // Return the maximum XOR for this number
        return xor;
    }


    /*
     * Main function to find the maximum XOR pair.
     */
    static int maximumXOR(int[] arr) {

        // Create the root of the Trie
        TrieNode root = new TrieNode();

        // Insert the first number
        insert(root, arr[0]);

        // Initially maximum XOR is 0
        int answer = 0;

        /*
         * Start from the second number.
         *
         * The Trie contains only previous numbers,
         * so we never compare a number with itself.
         */
        for (int i = 1; i < arr.length; i++) {

            // Find the best XOR with previous numbers
            int currentXOR =
                    findMaximumXOR(root, arr[i]);

            // Update the maximum answer
            answer = Math.max(answer, currentXOR);

            // Insert current number for future pairs
            insert(root, arr[i]);
        }

        // Return maximum XOR
        return answer;
    }


    public static void main(String[] args) {

        // Scanner is used to take input
        Scanner sc = new Scanner(System.in);

        // Take number of elements
        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        // Create the array
        int[] arr = new int[n];

        // Take array elements
        System.out.println("Enter the elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Find maximum XOR
        int answer = maximumXOR(arr);

        // Print the answer
        System.out.println("Maximum XOR = " + answer);

        // Close Scanner
        sc.close();
    }
}


/*
========================================================
EXAMPLE
========================================================

Input:

4
1 2 3 4


Possible pairs:

1 ^ 2 = 3
1 ^ 3 = 2
1 ^ 4 = 5
2 ^ 3 = 1
2 ^ 4 = 6
3 ^ 4 = 7

Maximum:

3 ^ 4 = 7

Output:

Maximum XOR = 7


========================================================
WHY TRIE?
========================================================

Consider:

3 = 011
4 = 100

XOR:

  011
^ 100
-----
  111

111 in binary = 7


To get a large XOR, we want different bits.

For every bit:

If our number has 0:
    We try to find 1.

If our number has 1:
    We try to find 0.


This gives the maximum possible XOR.


========================================================
TIME COMPLEXITY
========================================================

Each number has 32 bits.

Insert:
    O(32) = O(1)

Search:
    O(32) = O(1)

For N numbers:

    O(32 * N)
    = O(N)

Space:

    O(32 * N)
    = O(N)
*/