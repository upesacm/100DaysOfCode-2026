class Solution {
public:
    vector<int> finalPrices(vector<int>& prices) {
        int n = prices.size();
        vector<int> ans;
        stack<int> s;

        for(int i = n - 1; i >=0 ;i--){
            while(!s.empty() && s.top() > prices[i]){
                s.pop();
            }
            ans.push_back(s.empty() ? prices[i] : prices[i] - s.top());
            s.push(prices[i]);
        }
        reverse(ans.begin(),ans.end());
        return ans;
    }
};