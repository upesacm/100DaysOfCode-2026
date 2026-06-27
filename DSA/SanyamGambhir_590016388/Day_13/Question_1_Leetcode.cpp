class Solution {
public:
    string mostCommonWord(string paragraph, vector<string>& banned) {
        unordered_set<string> bannedSet(banned.begin(), banned.end());
        unordered_map<string, int> wordCount;
        
        // Step 1: Sanitize the paragraph string
        for (char &c : paragraph) {
            if (ispunct(c)) {
                c = ' '; // Replace punctuation with spaces
            } else {
                c = tolower(c); // Normalize case
            }
        }
        
        // Step 2: Use stringstream to easily read space-separated words
        stringstream ss(paragraph);
        string word;
        string mostFrequent = "";
        int maxCount = 0;
        
        while (ss >> word) {
            if (bannedSet.find(word) == bannedSet.end()) {
                wordCount[word]++;
                // Track the max frequency on the fly
                if (wordCount[word] > maxCount) {
                    maxCount = wordCount[word];
                    mostFrequent = word;
                }
            }
        }
        
        return mostFrequent;
    }
};