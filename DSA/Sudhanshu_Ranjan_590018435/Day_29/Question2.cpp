class Solution {
public:
    void reverseString(vector<char>& s) {
        stack<char> st;
        for(char c:s)st.push(c);
        for(int i = 0; i < s.size();i++){
            char top = st.top();
            st.pop();
            s[i] = top;
        }
    }
};