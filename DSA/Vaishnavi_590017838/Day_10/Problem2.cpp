#include <iostream>
#include <set>
using namespace std;
int main() {
    string username;
    cin >> username;
    set<char> uniqueChars;
    for(char ch : username) {
        uniqueChars.insert(ch);
    }
    if(uniqueChars.size() % 2 == 0) {
        cout << "CHAT WITH HER!";
    }
    else {
        cout << "IGNORE HIM!";
    }
    return 0;
}