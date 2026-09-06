<h2 align="center">Week 12 Day 80 (02/09/2026)</h2>

## 1. Number of 1 Bits (LeetCode #191)
### Solution
```cpp
#include <bits/stdc++.h>
using namespace std;

int hammingWeight(unsigned int n) {
    int count = 0;

    while (n != 0) {
        n &= (n - 1);
        count++;
    }

    return count;
}

int main() {
    unsigned int n;
    cin >> n;

    cout << hammingWeight(n) << "\n";
    return 0;
}
```

* Time: O(k), where `k` is the number of set bits in `n`. In the worst case for a 32-bit integer, this is O(32) = O(1).
* Space: O(1) — only a counter variable is used.

The expression `n & (n - 1)` removes the rightmost set bit from `n`. For example, if `n = 12`, its binary form is `1100`. Then `n - 1 = 1011`, and `1100 & 1011 = 1000`, so one set bit has been removed. Repeating this process once for every set bit gives the Hamming weight. This is more efficient than checking all 32 bits when the number contains relatively few `1`s.

**Inbuilt function:** In C++20, `std::popcount(n)` from the `<bit>` header can directly count the number of set bits. The compiler may also provide built-in functions such as `__builtin_popcount()`.

**Optimized solution:** The `n &= (n - 1)` approach is the standard optimized bit-manipulation solution because it performs one iteration per set bit instead of always checking every bit position.

---

## 2. Power of Two or Zero?
### Solution
```cpp
#include <bits/stdc++.h>
using namespace std;

bool isPowerOfTwoOrZero(int n) {
    return n == 0 || (n & (n - 1)) == 0;
}

int main() {
    int n;
    cin >> n;

    cout << (isPowerOfTwoOrZero(n) ? "true" : "false") << "\n";
    return 0;
}
```

* Time: O(1) — only a constant number of bitwise operations is performed.
* Space: O(1) — no additional data structure is used.

Every positive power of two contains exactly one set bit. Subtracting `1` changes that set bit to `0` and changes all lower bits to `1`, so `n` and `n - 1` have no set bit in common. Therefore, `(n & (n - 1)) == 0` identifies positive powers of two. The additional condition `n == 0` is required because this problem explicitly considers `0` a valid answer.

**Inbuilt function:** No C++ STL function is required here. The bitwise AND operator `&` gives the optimal constant-time solution.

**Optimized solution:** This is already the optimal approach with O(1) time and O(1) extra space. Repeated division by `2` would take O(log n) time and is unnecessary.

---
