#include <iostream>
#include <string>
#include <cctype>

using namespace std;

class Solution {
public:
    bool isPalindrome(string s) {
        int left = 0;
        int right = s.size() - 1;

        while (left < right) {
            // Skip non-alphanumeric characters from the left
            while (left < right && !isalnum((unsigned char)s[left])) {
                left++;
            }

            // Skip non-alphanumeric characters from the right
            while (left < right && !isalnum((unsigned char)s[right])) {
                right--;
            }

            // Compare characters case-insensitively
            if (tolower((unsigned char)s[left]) !=
                tolower((unsigned char)s[right])) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
};

int main() {
    Solution sol;

    string s;
    cout << "Enter a string: ";
    getline(cin, s);

    if (sol.isPalindrome(s)) {
        cout << "Palindrome" << endl;
    } else {
        cout << "Not a palindrome" << endl;
    }

    return 0;
}