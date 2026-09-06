class Solution {
public:
    int hammingDistance(int x, int y) {
        // XOR gives us a number where set bits represent differing positions
        int xorResult = x ^ y;
        int distance = 0;
        
        // Count the number of set bits (1s)
        while (xorResult != 0) {
            xorResult &= (xorResult - 1); // Clear the lowest set bit
            distance++;
        }
        
        return distance;
    }
};