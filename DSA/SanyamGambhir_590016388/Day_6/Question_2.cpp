#include <iostream>
#include <vector>

class Solution {
public:
    std::vector<int> findUnion(const std::vector<int>& arr1, const std::vector<int>& arr2) {
        int n = arr1.size();
        int m = arr2.size();
        int i = 0, j = 0;
        
        std::vector<int> unionArr;
        // Optimization: Reserve capacity to avoid frequent reallocations
        unionArr.reserve(n + m); 

        // Lambda helper to push unique elements into the result vector
        auto pushUnique = [&unionArr](int val) {
            if (unionArr.empty() || unionArr.back() != val) {
                unionArr.push_back(val);
            }
        };

        while (i < n && j < m) {
            if (arr1[i] < arr2[j]) {
                pushUnique(arr1[i]);
                i++;
            } 
            else if (arr2[j] < arr1[i]) {
                pushUnique(arr2[j]);
                j++;
            } 
            else { // Both elements are equal
                pushUnique(arr1[i]);
                i++;
                j++;
            }
        }

        // Exhaust remaining elements of arr1
        while (i < n) {
            pushUnique(arr1[i]);
            i++;
        }

        // Exhaust remaining elements of arr2
        while (j < m) {
            pushUnique(arr2[j]);
            j++;
        }

        return unionArr;
    }
};

int main() {
    Solution sol;
    std::vector<int> arr1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
    std::vector<int> arr2 = {2, 3, 4, 4, 5, 11, 12};

    std::vector<int> result = sol.findUnion(arr1, arr2);

    std::cout << "Union: ";
    for (int num : result) {
        std::cout << num << " ";
    }
    std::cout << std::endl; 
    // Output: 1 2 3 4 5 6 7 8 9 10 11 12

    return 0;
}