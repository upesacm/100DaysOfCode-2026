#include <iostream>
using namespace std;

int turnOffRightmostSetBit(int n) {
    return n & (n - 1);
}

int main() {
    int n;
    cin >> n;

    int result = turnOffRightmostSetBit(n);

    cout << result << endl;

    return 0;
}