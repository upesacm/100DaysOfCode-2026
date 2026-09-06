<h2 align="center">Week 12 Day 80 (02/09/2026)</h2>

## 1. Number of 1 Bits (LeetCode #191)

A problem that teaches bit manipulation and binary representation. You are given a 32-bit unsigned integer `n` and must count how many bits in its binary representation are set to `1`. This count is commonly called the **Hamming weight** of the number.

The optimal bit-manipulation approach uses the observation that `n & (n - 1)` removes the rightmost set bit from `n`. By repeatedly applying this operation until `n` becomes `0`, we can count all the set bits efficiently.

This problem helps build concepts like:
- Bitwise AND
- Binary representation
- Hamming weight
- Removing the rightmost set bit

which are important for solving efficient bit manipulation problems.

**Your task:** Find and return the count of set bits (`1`s) in `n`.

### Input
A single integer `n`.

**Constraints:**
- `1 <= n <= 2^31 - 1`

### Output
Complete the function `hammingWeight(n)` that returns the count of set bits (`1`s) in `n`.

### Examples

**Input:**
```
n = 11
```

**Output:**
```
3
```

---

**Input:**
```
n = 128
```

**Output:**
```
1
```

---

## 2. Power of Two or Zero?

A problem that teaches bit manipulation through the binary representation of powers of two. You are given a non-negative integer `n` and must determine whether it is either equal to `0` or a power of two.

A positive power of two has exactly one set bit in its binary representation:

- `1`  → `1`
- `2`  → `10`
- `4`  → `100`
- `8`  → `1000`

When `1` is subtracted from a positive power of two, all bits after its single set bit become `1`. Therefore:

`n & (n - 1) == 0`

is true for every positive power of two. Since this problem also considers `0` valid, the condition becomes `n == 0 || (n & (n - 1)) == 0`.

This problem helps build concepts like:
- Bitwise AND
- Powers of two
- Binary representation
- Constant-time bit manipulation

which are important for recognizing binary patterns efficiently.

**Your task:** Given an integer `n`, determine whether it is `0` or a power of two.

### Input
A single non-negative integer `n`.

**Constraints:**
- `0 <= n <= 2^31 - 1`

### Output
Return `true` if `n` is `0` or a power of two, and `false` otherwise.

### Examples

**Input:**
```
n = 0
```

**Output:**
```
true
```

---

**Input:**
```
n = 18
```

**Output:**
```
false
```

---
