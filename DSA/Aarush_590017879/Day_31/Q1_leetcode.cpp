#include <iostream>
#include <vector>
#include <stack>
using namespace std;

vector<int> finalPrices(vector<int>& prices) {
    vector<int> result = prices;
    stack<int> st;

    for (int i = 0; i < prices.size(); i++) {
        while (!st.empty() && prices[st.top()] >= prices[i]) {
            result[st.top()] -= prices[i];
            st.pop();
        }

        st.push(i);
    }

    return result;
}

int main() {
    vector<int> prices = {8, 4, 6, 2, 3};

    vector<int> answer = finalPrices(prices);

    cout << "Final Prices: ";
    for (int price : answer) {
        cout << price << " ";
    }

    return 0;
}