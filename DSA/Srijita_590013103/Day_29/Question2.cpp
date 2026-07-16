#include <stack>
#include <string>
using namespace std;

class Solution {
public:
    string reverseString(string s) {
        stack<char> str;

        for (int i = 0; i < s.length(); i++) {
            str.push(s[i]);
        }

        string result = "";

        while (!str.empty()) {
            result += str.top();
            str.pop();
        }
        return result;
    }
};