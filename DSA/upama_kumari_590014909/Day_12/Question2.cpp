#include <iostream>
#include <string>
#include <unordered_map>
#include <unordered_set>
#include <climits>
using namespace std;

int smallestDistinctWindow(string s) {
    // Count total distinct characters
    unordered_set<char> distinctSet(s.begin(), s.end());
    int totalDistinct = distinctSet.size();
    
    unordered_map<char, int> charCount;
    int minLen = INT_MAX;
    int left = 0;
    int formed = 0; // distinct chars currently in window
    
    for (int right = 0; right < s.length(); right++) {
        // Add right character to window
        charCount[s[right]]++;
        if (charCount[s[right]] == 1) // new distinct char
            formed++;
        
        // Shrink window from left while all distinct chars present
        while (formed == totalDistinct) {
            minLen = min(minLen, right - left + 1);
            
            charCount[s[left]]--;
            if (charCount[s[left]] == 0) // lost a distinct char
                formed--;
            left++;
        }
    }
    
    return minLen;
}

int main() {
    string str = "bcda";
    
    
    cout << "Smallest distinct window length: " 
         << smallestDistinctWindow(str) << endl;
    
    return 0;
}