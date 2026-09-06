<h2 align="center">Week 12 Day 83 (05/09/2026)</h2>

## 1. Single Number II (LeetCode #137)
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

* Time: O(n) — each element is processed exactly once.
* Space: O(1) — only two integer masks, `ones` and `twos`, are used.

The optimized solution treats every bit position independently and keeps track of its frequency modulo `3`. The mask `ones` stores bits that have appeared once, while `twos` stores bits that have appeared twice. When a bit appears for the third time, the state transitions back to zero and the bit is cleared from both masks. After processing the complete array, the bits of the unique number remain in `ones`.

**Optimized solution:** The two-mask bit-manipulation approach achieves the required O(n) time and O(1) extra space. A frequency map would require O(n) additional space, so it is not optimal under the problem's constant-space requirement.

**Inbuilt function:** No C++ STL inbuilt function directly solves this problem. The bitwise operators `^`, `&`, and `~` provide the required optimized solution.

---

## 2. Count Set Bits
### Solution
```cpp
#include <bits/stdc++.h>
using namespace std;

int countSetBits(int n) {
    int count = 0;

    while (n != 0) {
        n &= (n - 1);
        count++;
    }

    return count;
}

int main() {
    int n;
    cin >> n;

    cout << countSetBits(n) << "\n";
    return 0;
}
```

* Time: O(k), where `k` is the number of set bits in `n`. In the worst case, for a fixed-width integer, this is O(32) = O(1).
* Space: O(1) — only a few integer variables are used.

The expression `n & (n - 1)` removes the rightmost set bit of `n`. Therefore, the loop executes exactly once for every `1` bit in the binary representation. For example, `13` is `1101` in binary. Repeatedly applying `n &= (n - 1)` removes one set bit at a time, so the loop runs three times.

**Optimized solution:** Brian Kernighan's algorithm is more efficient than checking every bit individually because it iterates only over the set bits. Its time complexity is O(k), where `k` is the number of set bits.

**Inbuilt function:** In C++20, `std::popcount(n)` from the `<bit>` header directly returns the number of set bits. GCC/Clang also provide `__builtin_popcount(n)`.

---
