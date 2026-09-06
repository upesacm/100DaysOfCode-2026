#include <iostream>

using namespace std;

int countSetBits(int n) {
    int count = 0;
    
    while (n > 0) {
        n &= (n - 1); // Clears the lowest set bit
        count++;
    }
    
    return count;
}

int main() {
    int n = 13; // 13 in binary is 1101
    
    cout << "Output: " << countSetBits(n) << "\n";
    // Expected Output: 3
    
    return 0;
}