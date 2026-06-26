#include <iostream>
#include <string>
using namespace std;

char toLowerCase(char ch)
{
    if(ch >= 'A' && ch <= 'Z')
    {
        ch = ch + 32;
    }
    return ch;
}

bool isAlphaNumeric(char ch)
{
    if((ch >= 'a' && ch <= 'z') ||
       (ch >= 'A' && ch <= 'Z') ||
       (ch >= '0' && ch <= '9'))
    {
        return true;
    }
    return false;
}

bool isPalindrome(string s)
{
    int left = 0;
    int right = s.length() - 1;

    while(left < right)
    {
        while(left < right && !isAlphaNumeric(s[left]))
        {
            left++;
        }

        while(left < right && !isAlphaNumeric(s[right]))
        {
            right--;
        }

        if(toLowerCase(s[left]) != toLowerCase(s[right]))
        {
            return false;
        }

        left++;
        right--;
    }

    return true;
}

int main()
{
    string s;
    getline(cin, s);

    if(isPalindrome(s))
    {
        cout << "true";
    }
    else
    {
        cout << "false";
    }

    return 0;
}