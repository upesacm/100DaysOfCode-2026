#include <iostream>
#include <vector>
#include <stack>
using namespace std;

vector<int> nextGreaterElement(vector<int>& arr) {
    int n = arr.size();
    vector<int> result(n, -1);
    stack<int> st;

    for (int i = 0; i < n; i++) {
        while (!st.empty() && arr[i] > arr[st.top()]) {
            result[st.top()] = arr[i];
            st.pop();
        }

        st.push(i);
    }

    return result;
}

int main() {
    vector<int> arr = {1, 3, 2, 4};

    vector<int> answer = nextGreaterElement(arr);

    cout << "Next Greater Elements: ";
    for (int num : answer) {
        cout << num << " ";
    }

    return 0;
}