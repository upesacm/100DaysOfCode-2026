class Solution {
public:
    string removeDuplicates(string s) {
        if(s.size() == 1) return s;
        int n = s.size();
        string ans = "";
        stack<char>st;
        st.push(s[n - 1]);
        
        for(int i = n - 2; i >= 0; i--){
            if(!st.empty() && s[i] == st.top()){
                st.pop();
            }else{
                st.push(s[i]);
            }
        }

        while(!st.empty()){
            ans.push_back(st.top());
            st.pop();
        }
        return ans;
    }
};