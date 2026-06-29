#include <bits/stdc++.h>
using namespace std;

// Counts the number of distinct subsequences of s (including the empty subsequence)
unsigned long long countDistinctSubsequences(const string &s) {
    const int MOD_NONE = 0; // not using modulo here, using unsigned long long for range
    int n = s.size();
    vector<unsigned long long> dp(n + 1, 0);
    dp[0] = 1; // empty subsequence

    // last[c] stores the 1-indexed position of the last occurrence of character c
    int last[256];
    fill(begin(last), end(last), -1);

    for (int i = 1; i <= n; i++) {
        unsigned char c = s[i - 1];
        dp[i] = 2 * dp[i - 1];
        if (last[c] != -1) {
            dp[i] -= dp[last[c] - 1];
        }
        last[c] = i;
    }

    return dp[n]; // includes empty subsequence; fine since we only compare, it cancels out
}

string stringWithMoreSubsequences(const string &s1, const string &s2) {
    unsigned long long count1 = countDistinctSubsequences(s1);
    unsigned long long count2 = countDistinctSubsequences(s2);

    if (count2 > count1) {
        return s2;
    }
    return s1; // covers count1 > count2 and the tie case (return s1)
}

int main() {
    string s1 = "abc";
    string s2 = "aac";

    cout << "s1 = \"" << s1 << "\" has " << countDistinctSubsequences(s1) - 1
         << " distinct non-empty subsequences" << endl;
    cout << "s2 = \"" << s2 << "\" has " << countDistinctSubsequences(s2) - 1
         << " distinct non-empty subsequences" << endl;

    cout << "Output: \"" << stringWithMoreSubsequences(s1, s2) << "\"" << endl;

    return 0;
}