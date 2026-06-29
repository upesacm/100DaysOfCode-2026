//Need to return the string with more distinct subsequences

#include <iostream>
#include <vector>
#include <string>
using namespace std;

long long countDistinct(string str)
{
    vector<long long> dp(str.length() + 1);

    dp[0] = 1; // empty string also counts

    vector<int> last(256, -1);

    for (int i = 1; i <= str.length(); i++)
    {
        // every new char doubles the possibilities
        dp[i] = 2 * dp[i - 1];

        // seen this before, so remove duplicate subsequences
        if (last[str[i - 1]] != -1)
        {
            dp[i] -= dp[last[str[i - 1]]];
        }

        // keeping the latest position of this char
        last[str[i - 1]] = i - 1;
    }

    return dp[str.length()];
}

int main()
{
    string s1, s2;

    cin >> s1 >> s2;

    // if both have same count, keep the first one
    if (countDistinct(s1) >= countDistinct(s2))
    {
        cout << s1;
    }
    else
    {
        cout << s2;
    }

    return 0;
}