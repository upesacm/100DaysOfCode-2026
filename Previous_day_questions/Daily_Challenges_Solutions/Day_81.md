<h2 align="center">Week 12 Day 81 (03/09/2026)</h2>

## 1. Hamming Distance (LeetCode #461)
### Solution
```cpp
#include <bits/stdc++.h>
using namespace std;

int hammingDistance(int x, int y) {
    unsigned int diff = x ^ y;
    int count = 0;

    while (diff != 0) {
        diff &= (diff - 1);
        count++;
    }

    return count;
}

int main() {
    int x, y;
    cin >> x >> y;

    cout << hammingDistance(x, y) << "\n";
    return 0;
}
```

* Time: O(k), where `k` is the number of different bit positions. For fixed-width integers, the worst case is O(32) = O(1).
* Space: O(1) — only a few variables are used.

The XOR operation produces `1` exactly at positions where `x` and `y` have different bits. Therefore, the Hamming distance is the number of set bits in `x ^ y`. The expression `diff &= (diff - 1)` removes the rightmost set bit during each iteration, so the loop runs exactly once for every differing bit.

**Inbuilt function:** In C++20, `std::popcount(x ^ y)` from the `<bit>` header directly computes the answer. Compiler built-ins such as `__builtin_popcount(x ^ y)` can also be used.

**Optimized solution:** XOR followed by set-bit counting is the standard optimal bit-manipulation solution.

---

## 2. The Unique Bit Pattern
### Solution
```cpp
#include <bits/stdc++.h>
using namespace std;

int singleNumber(vector<int>& nums) {
    int ones = 0;
    int twos = 0;

    for (int x : nums) {
        ones = (ones ^ x) & ~twos;
        twos = (twos ^ x) & ~ones;
    }

    return ones;
}

int main() {
    int n;
    cin >> n;

    vector<int> nums(n);
    for (int i = 0; i < n; i++)
        cin >> nums[i];

    cout << singleNumber(nums) << "\n";
    return 0;
}
```

* Time: O(n) — each array element is processed exactly once.
* Space: O(1) — only two integer masks, `ones` and `twos`, are used.

The optimized solution treats every bit position independently and keeps track of its frequency modulo `3`. The mask `ones` stores bits that have appeared once, while `twos` stores bits that have appeared twice. When a bit appears for the third time, the state transitions back to zero and the bit is cleared from both masks. After processing the complete array, all bits belonging to numbers that appeared three times have been removed, leaving only the bits of the unique number in `ones`.

**Optimization:** A frequency map would use O(n) extra space. Counting every bit position separately with 32 counters also uses constant space but performs a fixed 32n operations. The two-mask state-machine approach is the optimized bit-manipulation solution with O(n) time and O(1) extra space.

**Inbuilt function:** No C++ STL inbuilt function directly solves this problem. The bitwise operators `^`, `&`, and `~` provide the required optimized solution.

---
