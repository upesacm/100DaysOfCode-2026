class Solution {
public:
    int minLength(string s) {
        string st = "";

        for(char ch : s){
            if(!st.empty()){
                char top = st.back();
                if((top == 'A' && ch == 'B') || 
                   (top == 'C' && ch == 'D')){
                    st.pop_back();
                    continue;
                }
            }
            st.push_back(ch);
        }
        return st.length();
    }
};