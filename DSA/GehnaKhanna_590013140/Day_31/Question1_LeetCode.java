import java.util.*;

class Solution {
    public int[] finalPrices(int[] prices) {

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {

            while (!stack.isEmpty() &&
                   prices[i] <= prices[stack.peek()]) {

                prices[stack.peek()] -= prices[i];
                stack.pop();
            }

            stack.push(i);
        }

        return prices;
    }
}
