#include <bits/stdc++.h>
using namespace std;

vector<int> maxTemperature(vector<int>& temperatures, int k) {

    deque<int> dq;
    vector<int> ans;

    for (int i = 0; i < temperatures.size(); i++) {

        // Remove elements outside the window
        while (!dq.empty() && dq.front() <= i - k)
            dq.pop_front();

        // Remove smaller elements
        while (!dq.empty() &&
               temperatures[dq.back()] <= temperatures[i])
            dq.pop_back();

        // Insert current index
        dq.push_back(i);

        // Window formed
        if (i >= k - 1)
            ans.push_back(temperatures[dq.front()]);
    }

    return ans;
}

int main() {

    vector<int> temperatures = {1,3,-1,-3,5,3,6,7};
    int k = 3;

    vector<int> ans = maxTemperature(temperatures, k);

    cout << "Maximum temperatures:\n";

    for (int x : ans)
        cout << x << " ";

    return 0;
}