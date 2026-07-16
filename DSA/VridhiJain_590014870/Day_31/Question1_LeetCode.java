import java.util.*;
class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> stack = new Stack<>();
        for (int i = prices.length - 1; i >= 0; i--) {
            int current = prices[i];
            while (!stack.isEmpty() && stack.peek() > current) {
                stack.pop();
            }
            if (!stack.isEmpty()) {
                prices[i] = current - stack.peek();
            }
            stack.push(current);
        }
        return prices;
    }
}