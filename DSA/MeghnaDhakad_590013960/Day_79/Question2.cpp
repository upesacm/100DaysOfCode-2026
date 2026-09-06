#include <iostream>
#include <vector>

using namespace std;

int findMissingElement(const vector<int>& nums) {
    int uniqueElement = 0;
    
    // XOR all elements in the array
    for (int num : nums) {
        uniqueElement ^= num;
    }
    
    return uniqueElement;
}

int main() {
    vector<int> nums = {4, 1, 2, 1, 2, 4, 7};
    
    cout << "Output: " << findMissingElement(nums) << "\n";
    // Expected Output: 7
    
    return 0;
}