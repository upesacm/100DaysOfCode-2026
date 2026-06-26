#include <iostream>
#include <string>
using namespace std;
string removeSpaces(string s)
{
    string result = "";
    for (int i = 0; i < s.length(); i++)
    {
        if (s[i] != ' ')
        {
            result += s[i];
        }
    }
    return result;
}
int main()
{
    string s = "C od ing";

    cout << removeSpaces(s);

    return 0;
}