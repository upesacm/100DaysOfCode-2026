// Q1 Isomorphic string 
#include <iostream>
#include <unordered_map>
using namespace std;

class Solution {
public:
    bool isIsomorphic(string s, string t) {
        if (s.length() != t.length()) return false;

        unordered_map<char, char> st, ts;

        for (int i = 0; i < s.size(); i++) {
            char c1 = s[i];
            char c2 = t[i];

            // Check mapping from s -> t
            if (st.count(c1)) {
                if (st[c1] != c2) return false;
            } else {
                st[c1] = c2;
            }

            // Check mapping from t -> s
            if (ts.count(c2)) {
                if (ts[c2] != c1) return false;
            } else {
                ts[c2] = c1;
            }
        }

        return true;
    }
};


int main() {
    Solution obj;

    string s, t;
    cout << "Enter string s: ";
    cin >> s;

    cout << "Enter string t: ";
    cin >> t;

    bool result = obj.isIsomorphic(s, t);

    cout << (result ? "true" : "false") << endl;

    return 0;
}