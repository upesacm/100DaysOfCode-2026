#include <iostream>
#include <string>
using namespace std;

bool backspaceCompare(string s, string t) {
    int i = s.length() - 1;
    int j = t.length() - 1;

    while (i >= 0 || j >= 0) {

        int skipS = 0;
        while (i >= 0) {
            if (s[i] == '#') {
                skipS++;
                i--;
            } else if (skipS > 0) {
                skipS--;
                i--;
            } else {
                break;
            }
        }

        int skipT = 0;
        while (j >= 0) {
            if (t[j] == '#') {
                skipT++;
                j--;
            } else if (skipT > 0) {
                skipT--;
                j--;
            } else {
                break;
            }
        }

        if (i >= 0 && j >= 0) {
            if (s[i] != t[j])
                return false;
        }
        else if (i >= 0 || j >= 0) {
            return false;
        }

        i--;
        j--;
    }

    return true;
}

int main() {
    string s = "ab#c";
    string t = "ad#c";

    if (backspaceCompare(s, t))
        cout << "true";
    else
        cout << "false";

    return 0;
}