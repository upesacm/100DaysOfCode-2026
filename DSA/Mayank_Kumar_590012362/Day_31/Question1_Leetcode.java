class Solution {
    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        int[] r = new int[n];
        ArrayDeque<Integer> st = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() > prices[i]) st.pop();
            r[i] = prices[i] - (st.isEmpty() ? 0 : st.peek());
            st.push(prices[i]);
        } return r;
    }
}