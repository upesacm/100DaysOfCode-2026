public class Question1_LeetCode {
    public int[] finalPrices(int[] prices) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int id = stack.pop();
                prices[id] = prices[id] - prices[i];
            }
            stack.push(i);
        }
        return prices;
    }
}
