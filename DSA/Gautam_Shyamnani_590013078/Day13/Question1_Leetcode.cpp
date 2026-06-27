class Solution {
public:
    string mostCommonWord(string paragraph, vector<string>& banned) {
        unordered_set<string> ban(banned.begin(),banned.end());
        unordered_map<string,int> freq;

        for(char &ch : paragraph){
            if(isalpha(ch)) ch =  tolower(ch);
            else ch = ' ';
        }
        
        stringstream ss(paragraph);
        string word,ans;
        int maxFreq = 0;
        
        while(ss >> word){
            if(ban.count(word)) continue;
            freq[word]++;
            if(freq[word] > maxFreq){
                maxFreq = freq[word];
                ans = word;
            }
        }
        return ans;
    }
};