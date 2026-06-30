//Smallest Distinct Window
//Find shortest window having all unique chars

#include <iostream>
#include <unordered_map>
#include <unordered_set>
#include <string>
#include <climits>
using namespace std;

int main()
{
    string str;
    cin >> str;

    unordered_set<char> uniqueChars(str.begin(), str.end());
    int required = uniqueChars.size();

    unordered_map<char, int> freq;

    int left = 0;
    int count = 0;
    int ans = INT_MAX;

    for (int right = 0; right < str.length(); right++)
    {
        freq[str[right]]++;

        if (freq[str[right]] == 1)
        {
            count++;
        }

        while (count == required)
        {
            ans = min(ans, right - left + 1);

            freq[str[left]]--;

            if (freq[str[left]] == 0)
            {
                count--;
            }

            left++;
        }
    }

    cout << ans;

    return 0;
}