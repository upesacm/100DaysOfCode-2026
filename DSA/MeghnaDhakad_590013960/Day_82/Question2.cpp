#include <iostream>

using namespace std;

int turnOffRightmostSetBit(int n) {
    // Mathematically clears the lowest set bit (1) to 0
    return n & (n - 1);
}

int main() {
    int n = 12;
    
    cout << "Output: " << turnOffRightmostSetBit(n) << "\n";
    // Expected Output: 8
    
    return 0;
}