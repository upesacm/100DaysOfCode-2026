#include <iostream>
#include <unordered_map>
#include <unordered_set>
#include <vector>
#include <string>
using namespace std;

class Solution {
public:
    string mostCommonWord(string paragraph, vector<string>& banned) {
        unordered_set<string> bannedWords;
        for(string word : banned)
            bannedWords.insert(word);
        unordered_map<string, int> wordCount;
        string currentWord = "";
        string answer = "";
        int maxCount = 0;
        paragraph += ' ';
        for(char ch : paragraph) {
            if(isalpha(ch)) {
                currentWord += tolower(ch);
            }
            else {
                if(currentWord != "") {
                    if(bannedWords.find(currentWord) == bannedWords.end()) {
                        wordCount[currentWord]++;
                        if(wordCount[currentWord] > maxCount) {
                            maxCount = wordCount[currentWord];
                            answer = currentWord;
                        }
                    }
                    currentWord = "";
                }
            }
        }
        return answer;
    }
};

int main() {
    Solution obj;
    string paragraph = "Bob hit a ball, the hit BALL flew far after it was hit.";
    vector<string> banned = {"hit"};
    cout << obj.mostCommonWord(paragraph, banned);
    return 0;
}
