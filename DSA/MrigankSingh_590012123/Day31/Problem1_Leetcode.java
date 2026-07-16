import java.util.Stack;

public class Problem1_Leetcode {
    public int[] finalPrices(int[] prices) {
        int[] answer = prices.clone();
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int index = stack.pop();
                answer[index] = prices[index] - prices[i];
            }
            stack.push(i);
        }

        return answer;
    }
}