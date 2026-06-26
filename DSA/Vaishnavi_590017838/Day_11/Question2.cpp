#include <iostream>
#include <string>
using namespace std;

int main() {
    string str;
    cin >> str;
    string answer = "";
    for(int i = 0; i < str.length(); i++) {
        char ch = tolower(str[i]);
        if(ch != 'a' && ch != 'e' && ch != 'i' &&
           ch != 'o' && ch != 'u') {
            answer += '.';
            answer += ch;
        }
    }
    cout << answer;
    return 0;
}
