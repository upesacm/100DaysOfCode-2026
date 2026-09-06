#include <iostream>
#include <vector>
#include <unordered_set>

using namespace std;

int findMaximumXOR(vector<int>& nums) {
    int maxXor = 0;
    int mask = 0;
    
    // Start from the most significant bit (31) down to 0
    for (int i = 31; i >= 0; --i) {
        // Expand the mask to include the current bit
        mask = mask | (1 << i);
        
        unordered_set<int> prefixes;
        // Store the prefixes of all numbers
        for (int num : nums) {
            prefixes.insert(num & mask);
        }
        
        // The candidate maximum XOR if we can set the current bit to 1
        int candidate = maxXor | (1 << i);
        
        // Check if there are two prefixes that XOR to the candidate
        for (int prefix : prefixes) {
            if (prefixes.count(candidate ^ prefix)) {
                maxXor = candidate; // Candidate is achievable, keep it
                break;
            }
        }
    }
    
    return maxXor;
}

int main() {
    vector<int> nums = {1, 2, 3, 4};
    
    cout << "Output: " << findMaximumXOR(nums) << "\n";
    // Expected Output: 7 (Because 3 ^ 4 = 7)
    
    return 0;
}