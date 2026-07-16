
import java.util.Stack;

class Question1_leetcode {

    public int[] finalPrices(int[] prices) {

        // Size of array
        int n = prices.length;

        // Answer array
        int[] answer = new int[n];

        // Stack to store possible discounts
        Stack<Integer> stack = new Stack<>();

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {

            // Remove prices greater than current price
            while (!stack.isEmpty() && stack.peek() > prices[i]) {
                stack.pop();
            }

            // No discount
            if (stack.isEmpty()) {
                answer[i] = prices[i];
            } // Apply discount
            else {
                answer[i] = prices[i] - stack.peek();
            }

            // Push current price
            stack.push(prices[i]);
        }

        // Return answer
        return answer;
    }
}
