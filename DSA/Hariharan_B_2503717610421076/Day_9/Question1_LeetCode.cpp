class Solution {
public:
    string removeSpaces(string s) {
        string ans = "";

        for (char ch : s) {
            if (ch != ' ')
                ans += ch;
        }

        return ans;
    }
};
