#include <iostream>
#include <string>
using namespace std;
int main() {
    string s;
    getline(cin, s);
    string result = "";

    for (int i = 0; i < s.length(); i++) {
        if (s[i] != ' ') {
            result += s[i];
        }
    }
    cout << result;
    return 0;
}
