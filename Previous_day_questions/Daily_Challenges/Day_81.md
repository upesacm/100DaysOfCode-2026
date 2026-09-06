<h2 align="center">Week 12 Day 81 (03/09/2026)</h2>

## 1. Hamming Distance (LeetCode #461)

A problem that teaches bit manipulation and binary comparison. The Hamming distance between two integers is the number of bit positions at which their corresponding binary bits are different.

The key observation is that the XOR of two numbers has a `1` exactly at every position where the two numbers differ. Therefore, the Hamming distance is simply the number of set bits in `x ^ y`.

This problem helps build concepts like:
- Bitwise XOR
- Hamming distance
- Counting set bits
- Binary representation

which are important for solving problems involving bit-level comparisons.

**Your task:** Find and return the Hamming distance between `x` and `y` using bit manipulation.

### Input
Two integers `x` and `y` representing the given numbers.

**Constraints:**
- `0 <= x, y <= 2^31 - 1`

### Output
Return the Hamming distance between `x` and `y`.

### Examples

**Input:**
```
x = 1
y = 4
```

**Output:**
```
2
```

---

**Input:**
```
x = 3
y = 1
```

**Output:**
```
1
```

---

## 2. The Unique Bit Pattern

A problem that teaches advanced bit manipulation for counting occurrences. You are given an integer array `nums` of length `n`. Every number in the array appears exactly three times, except for one number that appears exactly once.

The optimized approach tracks how many times each bit has appeared modulo `3`. Instead of using extra memory to count frequencies, two bit masks can represent the bits seen once and the bits seen twice.

This problem helps build concepts like:
- Bit manipulation
- Frequency counting modulo `3`
- Finite-state transitions using bit masks
- Constant extra-space algorithms

which are important for solving frequency problems under strict complexity constraints.

**Your task:** Find the number that appears exactly once. You must solve the problem using bit manipulation and achieve O(n) time complexity with O(1) extra space.

### Input
An integer `n` representing the number of elements in the array, followed by `n` space-separated integers representing the elements of `nums`.

**Constraints:**
- `1 <= n <= 2 × 10^5`
- `1 <= nums[i] <= 10^9`
- Every element appears exactly three times except one element which appears exactly once.
- `n % 3 != 0`

### Output
Return the integer that appears exactly once in the array.

### Examples

**Input:**
```
7
2 2 2 5 5 5 9
```

**Output:**
```
9
```

---

**Input:**
```
10
4 7 4 4 7 7 12 12 12 15
```

**Output:**
```
15
```

---
