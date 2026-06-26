//Remove vowels and add dot before every remaining letter

#include <iostream>
#include <string>
#include <cctype>
using namespace std;

int main()
{
    string str;
    cin >> str;

    string vowels = "aeiouyAEIOUY";

    for (char ch : str)
    {
        if (vowels.find(ch) == string::npos)
        {
            cout << "." << (char)tolower(ch);
        }
    }

    return 0;
}