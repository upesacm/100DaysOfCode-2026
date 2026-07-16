#include <iostream>
#include <stack>
#include <string>

using namespace std;

string reverseString(string s) {
    stack<char> st;
    
    // Step 1: Push all characters into the stack
    for (char ch : s) {
        st.push(ch);
    }
    
    // Step 2: Pop characters from the stack to build the reversed string
    string reversed = "";
    while (!st.empty()) {
        reversed += st.top();
        st.pop();
    }
    
    return reversed;
}

int main() {
    string input = "hello";
    string output = reverseString(input);
    cout << "Input: s = " << input << endl;
    cout << "Output: " << output << endl;
    return 0;
}