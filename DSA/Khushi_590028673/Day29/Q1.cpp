#include <iostream>
#include <stack>
#include<string>

using namespace std;

class Solution{
    public:

    bool isValid(string s){
        stack<char> st;

        for(int i=0; i<s.length(); i++){
            if(s[i] == '(' || s[i]=='{' || s[i]=='['){
                st.push(s[i]);
            }
            else{
                if(st.empty()){
                    return false;
                }

                if((s[i]==')' && st.top()=='(') || 
                    (s[i]=='}' && st.top()=='{') ||
                    (s[i]==']' && st.top()=='[')){
                        st.pop();
                    }

                    else{
                        return false;
                    }
            }
        }

        return st.empty();
    }
};

int main(){
    Solution sol;

    string s;

    cout<<"Enter the string";
    cin>>s;

    if(sol.isValid(s)){
        cout<<"Valid Parentheses"<<endl;
    }

    else{
        cout<<"Invalid Parentheses"<<endl;
    }

    return 0;
}