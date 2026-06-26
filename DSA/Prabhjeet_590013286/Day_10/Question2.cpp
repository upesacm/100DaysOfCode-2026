//Determine Gender
//Count distinct chars and decide the output

#include <iostream>
#include <set>
#include <string>
using namespace std;

int main()
{
    string name;
    cin >> name;

    set<char> uniqueChars;

    for (char ch : name)
    {
        uniqueChars.insert(ch);
    }

    if (uniqueChars.size() % 2 == 0)
    {
        cout << "CHAT WITH HER!";
    }
    else
    {
        cout << "IGNORE HIM!";
    }

    return 0;
}