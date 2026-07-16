#include <iostream>
#include <stack>
#include <string>

using namespace std;

class Solution{
    public:

    string reverse(string s){
        stack<char>st;

        for(char ch:s){
            st.push(ch);
        }

        string reversed="";

        while(!st.empty()){
            reversed += st.top();
            st.top();
        }

        return reversed;
    }
};

int main(){
    Solution sol;
    string s;

    cout<<"Enter a string: ";
    getline(cin, s);

    cout<<"Reversed String: "<<sol.reverse(s)<<endl;

    return 0;
}