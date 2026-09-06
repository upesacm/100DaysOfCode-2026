<h2 align="center">Week 12 Day 78 (31/08/2026)</h2>

## 1. Single Number (LeetCode #136)
### Solution
```cpp
#include <bits/stdc++.h>
using namespace std;

int singleNumber(vector<int>& nums) {
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

    cout << singleNumber(nums) << "\n";
    return 0;
}
```

* Time: O(n) — every element is visited exactly once.
* Space: O(1) — only one accumulator variable is used.

The XOR operator is the key to the optimal solution. Since `a ^ a = 0`, every number that appears twice cancels itself when all elements are XORed together. Also, because `0 ^ x = x`, the only value remaining after all duplicate pairs cancel is the number that appears exactly once. This is already the optimal approach because every element must be examined at least once, giving O(n) time and O(1) extra space.

**Inbuilt function:** No C++ STL function is required or better suited here; the bitwise XOR operator `^` directly gives the optimal solution.

---

## 2. Maximum XOR Pair
### Solution
```cpp
#include <bits/stdc++.h>
using namespace std;

class Trie {
    struct Node {
        Node* child[2];

        Node() {
            child[0] = child[1] = nullptr;
        }
    };

    Node* root;

public:
    Trie() {
        root = new Node();
    }

    void insert(int num) {
        Node* cur = root;

        for (int bit = 30; bit >= 0; bit--) {
            int b = (num >> bit) & 1;

            if (!cur->child[b])
                cur->child[b] = new Node();

            cur = cur->child[b];
        }
    }

    int getMaximumXOR(int num) {
        Node* cur = root;
        int ans = 0;

        for (int bit = 30; bit >= 0; bit--) {
            int b = (num >> bit) & 1;
            int opposite = 1 - b;

            // Choosing the opposite bit makes this XOR bit 1,
            // which greedily maximizes the answer from MSB to LSB.
            if (cur->child[opposite]) {
                ans |= (1 << bit);
                cur = cur->child[opposite];
            } else {
                cur = cur->child[b];
            }
        }

        return ans;
    }
};

int main() {
    int n;
    cin >> n;

    vector<int> arr(n);
    for (int i = 0; i < n; i++)
        cin >> arr[i];

    Trie trie;

    for (int x : arr)
        trie.insert(x);

    int maximumXOR = 0;

    for (int x : arr)
        maximumXOR = max(maximumXOR, trie.getMaximumXOR(x));

    cout << maximumXOR << "\n";
    return 0;
}
```

* Time: O(n × 31), which is effectively O(n) — each insertion and query processes the 31 bits required for values up to `10^9`.
* Space: O(n × 31) = O(n) — the binary Trie stores at most one node per processed bit along each inserted number's path.

The optimal approach uses a binary Trie. Each number is represented using bits from bit `30` down to bit `0`. For every bit of the current number, the algorithm greedily tries to move to the child containing the opposite bit because `0 ^ 1` and `1 ^ 0` both produce `1`. Maximizing a higher bit is always more important than any combination of lower bits, so this greedy choice from the most significant bit to the least significant bit gives the maximum possible XOR value for that number. Taking the maximum over all numbers gives the answer.

**Optimization:** A brute-force comparison of every pair takes O(n²), which is too slow for `n = 10^5`. The binary Trie reduces the search to O(31n), making it the optimized solution for the given constraints.

**Inbuilt function:** There is no standard C++ STL inbuilt function that directly finds the maximum XOR pair. A binary Trie is the standard optimized data structure for this problem.

---
