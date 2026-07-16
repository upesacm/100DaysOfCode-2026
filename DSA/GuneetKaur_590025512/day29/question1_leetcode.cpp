
#include<iostream>
#include<string>
#include<stack>
using namespace std;
class Solution {
public:
    string removeDuplicates(string s) {

        string st;

        for(char ch : s)
        {
            if(!st.empty() && st.back() == ch)
                st.pop_back();
            else
                st.push_back(ch);
        }

        return st;
    }
};