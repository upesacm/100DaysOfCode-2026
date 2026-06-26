#include <iostream>
#include <string>
#include <cctype>
using namespace std;

bool isVowel(char ch) {
    return ch == 'a' || ch == 'e' || ch == 'i' ||
           ch == 'o' || ch == 'u';
}

int main() {
    string s;
    cin >> s;

    string result = "";

    for (char ch : s) {
        ch = tolower(ch);

        if (!isVowel(ch)) {
            result += '.';
            result += ch;
        }
    }

    cout << result;

    return 0;
}