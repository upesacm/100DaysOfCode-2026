class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] answer = prices.clone(); // default: no discount, full price
        
        Deque<Integer> stack = new ArrayDeque<>(); // stores indices, prices increasing bottom->top
        
        for (int i = 0; i < n; i++) {
            // Current price can act as a discount for any stacked index
            // whose price is >= current price (i.e., current <= that price)
            while (!stack.isEmpty() && prices[stack.peek()] >= prices[i]) {
                int idx = stack.pop();
                answer[idx] = prices[idx] - prices[i];
            }
            stack.push(i);
        }
        
        // Anything still on the stack never found a discount -> stays at original price (already set)
        return answer;
    }
}
