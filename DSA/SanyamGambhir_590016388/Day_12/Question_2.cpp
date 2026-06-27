#include <iostream>
#include <string>
#include <unordered_set>
#include <unordered_map>
#include <climits>
#include <algorithm>

using namespace std;

int smallestDistinctWindow(const string& s) {
    if (s.empty()) return 0;

    
    unordered_set<char> distinct_chars(s.begin(), s.end());
    int distinct_count = distinct_chars.size();

    
    unordered_map<char, int> window_map;

    int left = 0;
    int min_len = INT_MAX;
    int count_unique_in_window = 0;

    for (int right = 0; right < s.length(); ++right) {
        char right_char = s[right];
        
        
        window_map[right_char]++;
        
        
        if (window_map[right_char] == 1) {
            count_unique_in_window++;
        }

        
        while (count_unique_in_window == distinct_count) {
            
            min_len = min(min_len, right - left + 1);

            
            char left_char = s[left];
            window_map[left_char]--;

            
            if (window_map[left_char] == 0) {
                count_unique_in_window--;
            }

            left++;
        }
    }

    return (min_len == INT_MAX) ? 0 : min_len;
}

int main() {
    // Test Cases
    cout << smallestDistinctWindow("abcda") << endl;      
    cout << smallestDistinctWindow("aabcbcdbca") << endl; 
    cout << smallestDistinctWindow("a") << endl;          
    cout << smallestDistinctWindow("aaaaa") << endl;      
    cout << smallestDistinctWindow("abcdef") << endl;     

    return 0;
}