#include <iostream>
#include <string>
using namespace std;

class Solution {
public:
    int lengthOfLastWord(string s) {
        int i = s.length() - 1;

        // Skip trailing spaces
        while (i >= 0 && s[i] == ' ') {
            i--;
        }

        int length = 0;

        // Count characters of the last word
        while (i >= 0 && s[i] != ' ') {
            length++;
            i--;
        }

        return length;
    }
};

int main() {
    Solution sol;

    string s;
    getline(cin, s);

    cout << sol.lengthOfLastWord(s) << endl;

    return 0;
}
