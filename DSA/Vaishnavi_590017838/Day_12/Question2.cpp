#include <iostream>
#include <unordered_set>
#include <unordered_map>
#include <string>
using namespace std;

int main() {
    string str;
    cin >> str;
    unordered_set<char> uniqueChars;
    for(char ch : str) {
        uniqueChars.insert(ch);
    }
    int required = uniqueChars.size();
    unordered_map<char,int> freq;
    int left = 0;
    int answer = str.length();
    for(int right = 0; right < str.length(); right++) {
        freq[str[right]]++;
        while(freq.size() == required) {
            answer = min(answer, right - left + 1);
            freq[str[left]]--;
            if(freq[str[left]] == 0) {
                freq.erase(str[left]);
            }
            left++;
        }
    }
    cout << answer;
    return 0;
}
