#include <iostream>
#include <unordered_map>
#include <unordered_set>
#include <string>
#include <climits>
using namespace std;

int smallestDistinctWindow(string str) {
    unordered_set<char> distinctChars(str.begin(), str.end());
    int required = distinctChars.size();

    unordered_map<char, int> freq;
    int formed = 0;
    int left = 0;
    int minLen = INT_MAX;

    for (int right = 0; right < str.size(); right++) {
        freq[str[right]]++;

        if (freq[str[right]] == 1)
            formed++;

        while (formed == required) {
            minLen = min(minLen, right - left + 1);

            freq[str[left]]--;

            if (freq[str[left]] == 0)
                formed--;

            left++;
        }
    }

    return minLen;
}

int main() {
    string str = "abcda";

    cout << smallestDistinctWindow(str);

    return 0;
}