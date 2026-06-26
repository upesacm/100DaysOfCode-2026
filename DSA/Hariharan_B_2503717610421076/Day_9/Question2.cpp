#include <iostream>
#include <string>
using namespace std;

int main() {
    string s;
    getline(cin, s);

    string result = "";

    for (char ch : s) {
        if (ch != ' ') {
            result += ch;
        }
    }

    cout << result;

    return 0;
}
