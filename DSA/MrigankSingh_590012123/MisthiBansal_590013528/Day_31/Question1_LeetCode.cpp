class Solution {
public:
    vector<int> finalPrices(vector<int>& prices) {

        stack<int> st; // stores indices

        for(int i = prices.size() - 1; i >= 0; i--)
        {
            while(!st.empty() && prices[st.top()] > prices[i])
            {
                st.pop();
            }

            if(!st.empty())
            {
                prices[i] = prices[i] - prices[st.top()];
            }

            st.push(i);
        }

        return prices;
    }
};