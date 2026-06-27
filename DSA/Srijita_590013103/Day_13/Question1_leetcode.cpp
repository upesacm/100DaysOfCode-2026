#pragma GCC optimize("Ofast")

#include <bits/stdc++.h>
using namespace std;

static constexpr size_t max_align = alignof(max_align_t);
alignas(max_align) static unsigned char BUFFER[64 * 1024 * 1024];
static size_t pos = 0;

void *operator new(const size_t size) {
    const size_t padding = (max_align - (pos % max_align)) % max_align;
    pos += padding + size;
    return static_cast<void *>(&BUFFER[pos - size]);
}

void *operator new[](const size_t size) { return operator new(size); }
void operator delete(void *) noexcept {}
void operator delete[](void *) noexcept {}
void operator delete(void *, size_t) noexcept {}
void operator delete[](void *, size_t) noexcept {}



class Solution {
public:
    string mostCommonWord(string paragraph, vector<string>& banned) {
        unordered_set<string> ban(banned.begin() , banned.end());
        unordered_map<string, int> freq;

        for(char &c: paragraph){
            if(ispunct(c))
             c= ' ';
            else
             c= tolower(c);
        }
        stringstream ss(paragraph);
        string word;

        while( ss >> word){
            if(!ban.count(word)){
                freq[word]++;
            }
        }
        string answer;
        int maxFreq = 0;
        for(auto &p : freq){
            if(p.second > maxFreq){
                maxFreq = p.second;
                answer = p.first;
            }
        }
        return answer;
    }
};