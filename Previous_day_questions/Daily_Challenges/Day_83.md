<h2 align="center">Week 12 Day 83 (05/09/2026)</h2>

## 1. Single Number II (LeetCode #137)

A problem that teaches advanced bit manipulation for finding a unique element when every other element appears exactly three times.

You are given an integer array `nums` where every element appears three times except for one element, which appears exactly once. Find the single element and return it.

The solution must have linear runtime complexity and use only constant extra space.

This problem helps build concepts like:
- Bit manipulation
- Frequency counting modulo `3`
- Bitwise state transitions
- Constant extra-space algorithms

which are important for solving frequency-based problems efficiently.

**Your task:** Return the element that appears exactly once in the array.

### Input
An integer array `nums`, where every element appears three times except one element that appears once.

**Constraints:**
- `1 <= nums.length <= 3 * 10^4`
- `-2^31 <= nums[i] <= 2^31 - 1`
- Each element in `nums` appears exactly three times except for one element which appears once.

### Output
Return the single element that appears exactly once.

### Examples

**Input:**
```text
nums = [2, 2, 3, 2]
```

**Output:**
```text
3
```

---

**Input:**
```text
nums = [0, 1, 0, 1, 0, 1, 99]
```

**Output:**
```text
99
```

---

**Input:**
```text
nums = [5, 5, 7, 5]
```

**Output:**
```text
7
```

---

## 2. Count Set Bits

A problem that teaches bit manipulation for counting the number of set bits, or `1`s, in the binary representation of an integer.

You are given a non-negative integer `n`. Your task is to count the number of set bits in its binary representation.

You must solve the problem using bit manipulation.

This problem helps build concepts like:
- Binary representation
- Set bits
- Bitwise AND
- Rightmost set bit
- `n & (n - 1)` bit manipulation technique

which are important for solving binary and bit-level problems efficiently.

**Your task:** Count and return the number of set bits (`1`s) in the binary representation of `n`.

### Input
A non-negative integer `n`.

**Constraints:**
- `0 <= n <= 10^9`

### Output
Return the number of set bits (`1`s) in the binary representation of `n`.

### Examples

**Input:**
```text
n = 13
```

**Output:**
```text
3
```

---

**Input:**
```text
n = 7
```

**Output:**
```text
3
```

---
