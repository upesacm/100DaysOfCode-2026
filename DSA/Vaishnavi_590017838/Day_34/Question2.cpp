#include <iostream>
#include <vector>
#include <stack>
using namespace std;

int maximumVisiblePeople(vector<int>& height) {
    int n = height.size();
    vector<int> left(n);
    vector<int> right(n);
    stack<int> st;
    for(int i = 0; i < n; i++) {
        while(!st.empty() && height[st.top()] < height[i])
            st.pop();
        if(st.empty())
            left[i] = i;
        else
            left[i] = i - st.top();
        st.push(i);
    }
    while(!st.empty())
        st.pop();
    for(int i = n - 1; i >= 0; i--) {
        while(!st.empty() && height[st.top()] < height[i])
            st.pop();
        if(st.empty())
            right[i] = n - 1 - i;
        else
            right[i] = st.top() - i;
        st.push(i);
    }
    int answer = 1;
    for(int i = 0; i < n; i++) {
        int visible = left[i] + right[i] + 1;
        if(visible > answer)
            answer = visible;
    }
    return answer;
}
int main() {
    int n;
    cout << "Enter the number of people: ";
    cin >> n;
    vector<int> height(n);
    cout << "Enter the heights: ";
    for(int i = 0; i < n; i++)
        cin >> height[i];
    cout << "Maximum people visible: "
         << maximumVisiblePeople(height);
    return 0;
}
