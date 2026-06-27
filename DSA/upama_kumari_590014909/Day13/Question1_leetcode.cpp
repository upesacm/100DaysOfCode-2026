#include <iostream>
#include <vector>
#include <unordered_map>
#include <unordered_set>
#include <string>
#include <cctype>
using namespace std;

string mostCommonWord(string paragraph, vector<string>& banned) {
    unordered_set<string> ban(banned.begin(), banned.end());
    unordered_map<string, int> freq;

    string word = "", ans = "";
    int maxi = 0;

    paragraph += ' ';

    for (char ch : paragraph) {
        if (isalpha(ch)) {
            word += tolower(ch);
        } else {
            if (!word.empty()) {
                if (!ban.count(word)) {
                    freq[word]++;
                    if (freq[word] > maxi) {
                        maxi = freq[word];
                        ans = word;
                    }
                }
                word.clear();
            }
        }
    }

    return ans;
}

int main() {
    string paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
    vector<string> banned = {"hit"};

    cout << mostCommonWord(paragraph, banned) << endl;

    return 0;
}