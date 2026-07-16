#include <iostream>
#include <string>
using namespace std;

bool backspaceCompare(string s, string t) {

    int i = s.size() - 1;
    int j = t.size() - 1;

    while (i >= 0 || j >= 0) {

        int skip = 0;
        while (i >= 0) {
            if (s[i] == '#') {
                skip++;
                i--;
            } else if (skip > 0) {
                skip--;
                i--;
            } else {
                break;
            }
        }

        skip = 0;
        while (j >= 0) {
            if (t[j] == '#') {
                skip++;
                j--;
            } else if (skip > 0) {
                skip--;
                j--;
            } else {
                break;
            }
        }

        if (i >= 0 && j >= 0 && s[i] != t[j])
            return false;

        if ((i >= 0) != (j >= 0))
            return false;

        i--;
        j--;
    }

    return true;
}

int main() {

    string s = "ab#c";
    string t = "ad#c";

    cout << (backspaceCompare(s, t) ? "true" : "false");

    return 0;
}