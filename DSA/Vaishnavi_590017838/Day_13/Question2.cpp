#include <iostream>
#include <unordered_map>
#include <string>
using namespace std;

long long countSubsequences(string str) {
    unordered_map<char, long long> lastCount;
    long long total = 1;
    for(char ch : str) {
        long long newTotal = total * 2;
        if(lastCount.count(ch)) {
            newTotal -= lastCount[ch];
        }
        lastCount[ch] = total;
        total = newTotal;
    }
    return total;
}

int main() {
    string s1, s2;
    cin >> s1 >> s2;
    long long count1 = countSubsequences(s1);
    long long count2 = countSubsequences(s2);
    if(count1 >= count2)
        cout << s1;
    else
        cout << s2;

    return 0;
}
