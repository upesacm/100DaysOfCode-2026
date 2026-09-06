#include <vector>

using namespace std;

class Solution {
public:
    int singleNumber(vector<int>& nums) {
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
        
        return ones;
    }
};