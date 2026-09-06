#include <stdint.h>

class Solution {
public:
    int hammingWeight(uint32_t n) {
        int count = 0;
        
        while (n != 0) {
            n &= (n - 1); // Clears the lowest set bit
            count++;
        }
        
        return count;
    }
};