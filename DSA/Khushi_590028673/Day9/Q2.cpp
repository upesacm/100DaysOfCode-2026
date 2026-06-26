#include <iostream>
#include <string>
using namespace std;

class Solution {
public:
    string removeSpaces(string s) {
        string result;

        for (char ch : s) {
            if (ch != ' ') {
                result += ch;
            }
        }

        return result;
    }
};

int main() {
    Solution sol;

    string s;
    getline(cin, s);

    cout << sol.removeSpaces(s) << endl;

    return 0;
}
