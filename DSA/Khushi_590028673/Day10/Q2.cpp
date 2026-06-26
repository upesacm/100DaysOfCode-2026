#include <iostream>
#include <string>
using namespace std;

int countDistinct(string s) {
    string uniqueChars = "";
    int count = 0;

    for (int i = 0; i < s.size(); i++) {
        if (uniqueChars.find(s[i]) == string::npos) {
            uniqueChars += s[i];
            count++;
        }
    }

    return count;
}

int main() {
    string s;

    cout << "Enter username: ";
    cin >> s;

    int distinctCount = countDistinct(s);

    if (distinctCount % 2 == 0) {
        cout << "CHAT WITH HER!" << endl;
    } else {
        cout << "IGNORE HIM!" << endl;
    }

    return 0;
}
