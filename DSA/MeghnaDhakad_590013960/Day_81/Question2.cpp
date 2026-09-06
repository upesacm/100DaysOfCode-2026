#include <iostream>
#include <vector>

using namespace std;

int findUniqueBitPattern(const vector<int>& nums) {
    int ones = 0;
    int twos = 0;
    
    for (int num : nums) {
        // Update 'ones' to hold bits appearing 1st time, 
        // but ONLY if they are not already in 'twos'.
        ones = (ones ^ num) & ~twos;
        
        // Update 'twos' to hold bits appearing 2nd time,
        // but ONLY if they are not already in 'ones'.
        twos = (twos ^ num) & ~ones;
    }
    
    return ones; // The unique element will be left in 'ones'
}

int main() {
    vector<int> nums = {2, 2, 2, 5, 5, 5, 9};
    
    cout << "Output: " << findUniqueBitPattern(nums) << "\n";
    // Expected Output: 9
    
    return 0;
}