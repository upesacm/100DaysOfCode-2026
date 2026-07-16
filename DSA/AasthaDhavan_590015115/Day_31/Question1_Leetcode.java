class Solution {
    public int[] finalPrices(int[] prices) {
        Stack<Integer> st=new Stack<>();
        int[] res=new int[prices.length];
        for(int i=0;i<prices.length;i++){
            while(!st.isEmpty() && prices[st.peek()]>=prices[i] ){
                int idx=st.pop();
                res[idx]=prices[idx]-prices[i];
            }
            st.push(i);
        }
        while(!st.isEmpty()){
            int idx=st.pop();
            res[idx]=prices[idx];
        }
        return res;
    }
}