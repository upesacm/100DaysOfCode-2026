#include <iostream>
#include <vector>
#include <stack>
using namespace std;

class Solution {
public:
    vector<int> finalPrices(vector<int>& prices) {
        stack<int> st;   // stores indices

        for (int i = 0; i < prices.size(); i++) {
            while (!st.empty() && prices[i] <= prices[st.top()]) {
                prices[st.top()] -= prices[i];
                st.pop();
            }
            st.push(i);
        }

        return prices;
    }
};

int main() {
    Solution obj;

    vector<int> prices = {8, 4, 6, 2, 3};

    vector<int> ans = obj.finalPrices(prices);

    cout << "Final Prices: ";
    for (int x : ans)
        cout << x << " ";

    return 0;
}