/**
 * LeetCode 1475 - Final Prices With a Special Discount in a Shop
 * https://leetcode.com/problems/final-prices-with-a-special-discount-in-a-shop/
 */

//Need to find the first smaller or equal price on the right

import java.util.Stack;

class Solution {

    public int[] finalPrices(int[] prices) {

        Stack<Integer> stack = new Stack<>();

        for (int i = prices.length - 1; i >= 0; i--) {

            int curr = prices[i];

            // remove prices that are too big to be a discount
            while (!stack.isEmpty() && stack.peek() > curr) {
                stack.pop();
            }

            if (!stack.isEmpty()) {
                prices[i] = curr - stack.peek();
            }

            stack.push(curr);
        }

        return prices;
    }
}