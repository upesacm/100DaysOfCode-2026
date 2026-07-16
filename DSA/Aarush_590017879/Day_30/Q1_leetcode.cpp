#include <iostream>
#include <stack>
#include <algorithm>
using namespace std;

string removeDuplicates(string s) {
    stack<char> st;

    for (char ch : s) {
        if (!st.empty() && st.top() == ch) {
            st.pop();
        } else {
            st.push(ch);
        }
    }

    string result = "";

    while (!st.empty()) {
        result += st.top();
        st.pop();
    }

    reverse(result.begin(), result.end());

    return result;
}

int main() {
    string s;
    cin >> s;

    cout << removeDuplicates(s) << endl;

    return 0;
}