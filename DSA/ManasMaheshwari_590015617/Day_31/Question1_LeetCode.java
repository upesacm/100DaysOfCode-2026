class Solution {
    public int[] finalPrices(int[] prices) {
        int[] result = new int[prices.length];
        for (int i = 0; i < prices.length; i++) {
            result[i] = prices[i];
        }
        
        int[] stack = new int[prices.length];
        int top = -1;
        
        for (int i = 0; i < prices.length; i++) {
            while (top >= 0 && prices[stack[top]] >= prices[i]) {
                int index = stack[top];
                result[index] = prices[index] - prices[i];
                top--;
            }
            
            top++;
            stack[top] = i;
        }
        
        return result;
    }
}
