#include <iostream>
#include <vector>
using namespace std;
class Solution {
public:
    int numSubarrayBoundedMax(std::vector<int>& arr, int l, int r) {
        int total_subarrays = 0;
        int valid_idx = -1;
        int invalid_idx = -1;
        
        for (int i = 0; i < arr.size(); ++i) {
            // If the element is strictly greater than r, it breaks the window
            if (arr[i] > r) {
                invalid_idx = i;
            }
            // If the element is within [l, r], it becomes a valid starting/ending point
            if (arr[i] >= l) {
                valid_idx = i;
            }
            
            // If we have seen a valid element more recently than an invalid one,
            // we add the count of all valid subarrays ending at index i.
            if (valid_idx > invalid_idx) {
                total_subarrays += (valid_idx - invalid_idx);
            }
        }
        
        return total_subarrays;
    }
};

int main() {
    Solution solver;
    vector<int> arr = {1, 2, 3, 4, 5};
    int l = 2;
    int r = 5;
    
    int result = solver.numSubarrayBoundedMax(arr, l, r);
    std::cout << "Total valid subarrays: " << result << std::endl; // Output: 14
    
    return 0;
}