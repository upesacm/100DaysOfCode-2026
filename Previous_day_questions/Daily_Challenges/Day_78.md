<h2 align="center">Week 12 Day 78 (31/08/2026)</h2>

## 1. Single Number (LeetCode #136)

A problem that teaches bit manipulation and the properties of the XOR operation. You are given a non-empty array of integers `nums` where every element appears exactly twice except for one element that appears only once.

The key property used in the optimal solution is that XOR cancels equal values:

- `a ^ a = 0`
- `a ^ 0 = a`
- XOR is commutative and associative

Therefore, XORing all elements removes every duplicated pair and leaves only the single number.

This problem is commonly asked in interviews and helps build concepts like:
- Bitwise XOR
- Cancellation of duplicate values
- Designing an O(n) solution with O(1) extra space

which are important for solving array problems under strict time and memory constraints.

**Your task:** Find and return the element that appears only once in `nums`.

### Input
An integer array `nums`, as described above.

**Constraints:**
- `1 <= nums.length <= 3 × 10^4`
- `-3 × 10^4 <= nums[i] <= 3 × 10^4`
- Each element in the array appears twice except for one element which appears only once.

### Output
Return the element that appears only once.

### Examples

**Input:**
```
nums = [2,2,1]
```

**Output:**
```
1
```

---

**Input:**
```
nums = [4,1,2,1,2]
```

**Output:**
```
4
```

---

**Input:**
```
nums = [1]
```

**Output:**
```
1
```

---

## 2. Maximum XOR Pair

A problem that teaches greedy bit manipulation and binary Trie (prefix tree) techniques. You are given an array of `n` positive integers and must find the maximum XOR value obtainable by XORing any two distinct elements.

XOR (exclusive OR) is a bitwise operation where the result bit is `1` if exactly one of the corresponding bits of the two numbers is `1`.

To maximize the XOR value, the most significant bits should be maximized first. For each bit of the current number, the best choice is usually to pair it with the opposite bit (`0` with `1` or `1` with `0`). A binary Trie makes it possible to find such a complementary value efficiently.

This problem is commonly asked in interviews and helps build concepts like:
- Binary Trie (prefix tree)
- Greedy maximization from the most significant bit
- Bitwise XOR operations

which are important for solving maximum pair-value problems efficiently.

**Your task:** Find the maximum value of `arr[i] XOR arr[j]` for two distinct indices `i` and `j`.

### Input
The first line contains an integer `n`, the number of elements.

The second line contains `n` positive integers.

**Constraints:**
- `2 <= n <= 10^5`
- `1 <= arr[i] <= 10^9`

### Output
Print a single integer: the maximum XOR value obtainable from any pair of distinct elements.

### Examples

**Input:**
```
4
1 2 3 4
```

**Output:**
```
7
```

---
