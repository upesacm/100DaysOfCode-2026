#include <iostream>
#include <vector>
#include <stack>
using namespace std;

vector<int> nextGreaterElement(vector<int>& arr) {
    int n = arr.size();
    vector<int> result(n);
    stack<int> st;
    for(int i = n - 1; i >= 0; i--) {
        while(!st.empty() && st.top() <= arr[i]) {
            st.pop();
        }
        if(st.empty())
            result[i] = -1;
        else
            result[i] = st.top();
        st.push(arr[i]);
    }
    return result;
}

int main() {
    int n;
    cout << "Enter the number of elements: ";
    cin >> n;
    vector<int> arr(n);
    cout << "Enter the array elements: ";
    for(int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    vector<int> result = nextGreaterElement(arr);
    cout << "Next Greater Elements: ";
    for(int value : result)
        cout << value << " ";
    return 0;
}
