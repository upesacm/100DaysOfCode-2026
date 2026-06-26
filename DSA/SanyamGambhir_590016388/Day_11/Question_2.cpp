#include <iostream>
#include <string>
#include <cctype>

using namespace std;

string processString(string s) {
    string result = "";
    // Standard English vowels
    string vowels = "aeiouAEIOU";
    
    for (char c : s) {
        // Check if character is a letter and not a vowel
        if (isalpha(c) && vowels.find(c) == string::npos) {
            result += '.';
            result += tolower(c);
        }
    }
    return result;
}

int main() {
    string input = "Hello";
    cout << processString(input) << endl; // Output: .h.l.l
    return 0;
}