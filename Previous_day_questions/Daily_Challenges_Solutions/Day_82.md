<h2 align="center">Week 12 Day 82 (04/09/2026)</h2>

## 1. Number of Steps to Reduce a Number to Zero (LeetCode #1342)
### Solution
```cpp
#include <bits/stdc++.h>
using namespace std;

int numberOfSteps(int num) {
    int steps = 0;

    while (num != 0) {
        if (num & 1)
            num--;
        else
            num >>= 1;

        steps++;
    }

    return steps;
}

int main() {
    int num;
    cin >> num;

    cout << numberOfSteps(num) << "\n";
    return 0;
}
```

* Time: O(log n) — each division by `2` reduces the number significantly, and there are at most O(log n) bits.
* Space: O(1) — only a few integer variables are used.

The least significant bit determines whether `num` is odd or even. The expression `num & 1` checks this directly. If the number is odd, subtracting `1` makes it even; if it is even, right-shifting by one bit performs division by `2`. Therefore, the process follows the exact rules of the problem while using bit manipulation.

**Optimized solution:** For `num > 0`, the number of steps can also be computed as `floor(log2(num)) + popcount(num)`. Every `1` bit causes one subtraction, and every bit except the most significant bit eventually causes one division by `2`. For fixed-width integers, the bit operations can be considered O(1).

**Inbuilt function:** In C++20, `std::popcount()` from `<bit>` can count the set bits. `std::bit_width()` can be used to obtain the number of significant bits. Compiler built-ins such as `__builtin_popcount()` and `__builtin_clz()` can also be used.

---

## 2. Turn Off the Rightmost Set Bit
### Solution
```cpp
#include <bits/stdc++.h>
using namespace std;

int turnOffRightmostSetBit(int n) {
    return n & (n - 1);
}

int main() {
    int n;
    cin >> n;

    cout << turnOffRightmostSetBit(n) << "\n";
    return 0;
}
```

* Time: O(1) — only one subtraction and one bitwise AND operation are performed.
* Space: O(1) — only the input and a few primitive variables are used.

The expression `n - 1` changes the rightmost set bit of `n` to `0` and changes all bits to its right to `1`. When `n` is ANDed with `n - 1`, those changed lower bits become `0`, while the rightmost set bit is also cleared. Therefore, `n & (n - 1)` directly turns off the rightmost set bit.

**Optimized solution:** `n & (n - 1)` is the standard optimal bit-manipulation solution. It performs the required operation in constant time and uses constant extra space.

**Inbuilt function:** There is no direct C++ STL function specifically for turning off the rightmost set bit. The bitwise expression `n & (n - 1)` is the standard and optimal technique.

---
