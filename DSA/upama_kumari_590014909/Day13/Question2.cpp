#include <iostream>
#include <unordered_map>
#include <vector>
#include <string>
using namespace std;

long long countDistinctSubsequences(string s) {
    int n = s.size();

    vector<long long> dp(n + 1, 0);
    dp[0] = 1;

    unordered_map<char, int> last;

    for (int i = 1; i <= n; i++) {
        dp[i] = 2 * dp[i - 1];

        if (last.count(s[i - 1])) {
            dp[i] -= dp[last[s[i - 1]] - 1];
        }

        last[s[i - 1]] = i;
    }

    return dp[n];
}

string betterString(string s1, string s2) {
    long long cnt1 = countDistinctSubsequences(s1);
    long long cnt2 = countDistinctSubsequences(s2);

    if (cnt1 >= cnt2)
        return s1;
    return s2;
}

int main() {
    string s1 = "x";
    string s2 = "y";

    cout << betterString(s1, s2) << endl;

    return 0;
}