#include <iostream>
#include <string>
using namespace std;

int lengthOfLastWord(string s)
{
    int res = 0;

    for (int i = s.length() - 1; i >= 0; i--)
    {
        if (s[i] != ' ')
        {
            res++;
        }
        else if (res > 0)
        {
            return res;
        }
    }

    return res;
}

int main()
{
    string s = "Hello World";
    cout << lengthOfLastWord(s);
    return 0;
}