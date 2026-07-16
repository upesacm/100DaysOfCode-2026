#include <iostream>
#include <vector>
#include <stack>

using namespace std;

vector<int> finalPrices(vector<int>& prices) {
    int n = prices.size();
    vector<int> ans = prices;
    stack<int> st; // Stores indices

    for (int i = n - 1; i >= 0; i--) {

        while (!st.empty() && prices[st.top()] > prices[i]) {
            st.pop();
        }

        if (!st.empty()) {
            ans[i] = prices[i] - prices[st.top()];
        }

        st.push(i);
    }

    return ans;
}

int main() {
    vector<int> prices = {8, 4, 6, 2, 3};

    vector<int> result = finalPrices(prices);

    cout << "Final Prices: ";
    for (int price : result) {
        cout << price << " ";
    }
    cout << endl;

    return 0;
}
