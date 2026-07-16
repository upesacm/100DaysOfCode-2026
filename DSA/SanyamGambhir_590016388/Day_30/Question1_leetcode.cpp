class Solution {
public:
    string removeDuplicates(string s) {
        stack<char> st;
        
        for (int i = 0; i < s.length(); i++) {
            // Check if stack is NOT empty AND the top element matches the current character
            if (!st.empty() && st.top() == s[i]) {
                st.pop(); 
            } else {
                st.push(s[i]); 
            }
        }
        
        // At this point, the stack contains the correct characters, 
        // but pulling them out will give them to us in reverse order.
        string res = "";
        while (!st.empty()) {
            res += st.top();
            st.pop();
        }
        
        // Reverse the string to get the original correct order
        reverse(res.begin(), res.end());
        
        return res;
    }
};