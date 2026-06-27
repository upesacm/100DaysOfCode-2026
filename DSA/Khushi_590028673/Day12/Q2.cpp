#include <iostream>
#include <unordered_map>
#include <unordered_set>
#include <string>
#include <climits>

using namespace std;

int smallestDistinctWindow(string str) {
    // Count total distinct characters in the string
    unordered_set<char> distinctChars;
    for (char ch : str) {
        distinctChars.insert(ch);
    }

    int totalDistinct = distinctChars.size();

    unordered_map<char, int> freq;
    int start = 0;
    int count = 0;
    int minLen = INT_MAX;

    // Sliding window
    for (int end = 0; end < str.length(); end++) {
        freq[str[end]]++;

        if (freq[str[end]] == 1)
            count++;

        // Shrink the window while it contains all distinct characters
        while (count == totalDistinct) {
            minLen = min(minLen, end - start + 1);

            freq[str[start]]--;

            if (freq[str[start]] == 0) {
                count--;
            }

            start++;
        }
    }

    return minLen;
}

int main() {
    string str;

    cout << "Enter string: ";
    cin >> str;

    cout << smallestDistinctWindow(str) << endl;

    return 0;
}
