#include <iostream>
#include <vector>
#include <unordered_map>
using namespace std;

long long countDistinctSubseq(string s) {
    int n = s.length();

    vector<long long> dp(n + 1, 0);
    dp[0] = 1;

    unordered_map<char, int> last;

    for (int i = 1; i <= n; i++) {
        dp[i] = 2 * dp[i - 1];

        char ch = s[i - 1];

        if (last.find(ch) != last.end()) {
            dp[i] -= dp[last[ch] - 1];
        }

        last[ch] = i;
    }

    return dp[n];
}

string betterString(string s1, string s2) {
    long long cnt1 = countDistinctSubseq(s1);
    long long cnt2 = countDistinctSubseq(s2);

    if (cnt1 >= cnt2)
        return s1;

    return s2;
}

int main() {
    string s1 = "abc";
    string s2 = "aac";

    cout << betterString(s1, s2);

    return 0;
}