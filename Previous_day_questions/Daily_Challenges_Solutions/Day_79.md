<h2 align="center">Week 12 Day 79 (01/09/2026)</h2>

## 1. Add Binary (LeetCode #67)
### Solution
```cpp
#include <bits/stdc++.h>
using namespace std;

string addBinary(string a, string b) {
    int i = (int)a.size() - 1;
    int j = (int)b.size() - 1;
    int carry = 0;

    string ans;

    while (i >= 0 || j >= 0 || carry) {
        int sum = carry;

        if (i >= 0)
            sum += a[i--] - '0';

        if (j >= 0)
            sum += b[j--] - '0';

        ans.push_back(char('0' + (sum % 2)));
        carry = sum / 2;
    }

    reverse(ans.begin(), ans.end());
    return ans;
}

int main() {
    string a, b;
    cin >> a >> b;

    cout << addBinary(a, b) << "\n";
    return 0;
}
```

* Time: O(max(n, m)) — each character of both binary strings is processed at most once.
* Space: O(max(n, m)) — the answer string stores the resulting binary sum.

The optimized solution simulates binary addition from the rightmost characters of the two strings. At each step, the current two bits and the carry are added together. The result bit is `sum % 2`, and the carry for the next position is `sum / 2`. The loop continues until both strings and the carry are fully processed. Since `push_back()` builds the answer from least significant bit to most significant bit, `reverse()` is used at the end.

**Inbuilt function:** `std::reverse()` is used to reverse the final string. There is no standard C++ inbuilt function that directly performs arbitrary-length binary string addition.

---

## 2. The Missing Power of Two
### Solution
```cpp
#include <bits/stdc++.h>
using namespace std;

int findSingleNumber(const vector<int>& nums) {
    int ans = 0;

    for (int x : nums)
        ans ^= x;

    return ans;
}

int main() {
    int n;
    cin >> n;

    vector<int> nums(n);

    for (int i = 0; i < n; i++)
        cin >> nums[i];

    cout << findSingleNumber(nums) << "\n";
    return 0;
}
```

* Time: O(n) — every element is visited exactly once.
* Space: O(1) — only one accumulator variable is used.

The XOR operator gives the optimized solution. Every number that appears twice cancels because `x ^ x = 0`. XORing with zero leaves a value unchanged, so after XORing all elements, only the number appearing once remains. This achieves the required O(n) time and O(1) extra space and is optimal because every array element must be examined at least once.

**Inbuilt function:** No C++ STL inbuilt function is needed or more efficient here. The bitwise XOR operator `^` directly provides the optimal solution.

---
