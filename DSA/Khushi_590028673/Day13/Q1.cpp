// Q1- Most Common Word
#include <iostream>
#include <unordered_map>
#include <unordered_set>
#include <string>
#include <vector>
#include <cctype>

using namespace std;

string mostCommonWord(string paragraph, vector<string>& banned) {
    // Store banned words for O(1) lookup
    unordered_set<string> bannedSet;
    for (string word : banned) {
        bannedSet.insert(word);
    }

    // Store frequency of each valid word
    unordered_map<string, int> freq;

    string word = "";

    // Add one extra space to process the last word
    paragraph += " ";

    for (char ch : paragraph) {
        if (isalpha(ch)) {
            word += tolower(ch);
        } else {
            if (!word.empty()) {
                if (bannedSet.count(word) == 0) {
                    freq[word]++;
                }
                word.clear();
            }
        }
    }

    string answer = "";
    int maxFreq = 0;

    for (auto &it : freq) {
        if (it.second > maxFreq) {
            maxFreq = it.second;
            answer = it.first;
        }
    }

    return answer;
}

int main() {
    string paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
    vector<string> banned = {"hit"};

    cout << "Most Common Word: "
         << mostCommonWord(paragraph, banned) << endl;

    return 0;
}
