#include <iostream>

using namespace std;

bool isPowerOfTwoOrZero(int n) {
    // To strictly avoid signed integer underflow UB in C++ when n = 0, 
    // we can safely cast to unsigned during the subtraction.
    return (n & (n - 1U)) == 0;
}

int main() {
    int n = 0;
    
    // Print "true" or "false" based on the boolean result
    cout << "Output: " << (isPowerOfTwoOrZero(n) ? "true" : "false") << "\n";
    // Expected Output: true
    
    return 0;
}