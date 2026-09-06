<h2 align="center">Week 12 Day 79 (01/09/2026)</h2>

## 1. Add Binary (LeetCode #67)

A problem that teaches binary arithmetic and two-pointer simulation. You are given two binary strings `a` and `b`, representing two binary numbers. The task is to add them and return their sum as a binary string.

The addition is performed from right to left, just like decimal addition. At each position, add the current bits from both strings along with a carry. The resulting bit is `sum % 2`, while the next carry is `sum / 2`.

This problem helps build concepts like:
- Binary arithmetic
- Two pointers
- Carry propagation
- Efficient string construction

which are important for solving problems involving number representations.

**Your task:** Add the two binary numbers and return their sum as a binary string.

### Input
Two binary strings `a` and `b`, representing two binary numbers.

**Constraints:**
- `1 <= a.length, b.length <= 10^4`
- `a` and `b` consist only of `'0'` or `'1'` characters.
- Each string does not contain leading zeros except for the zero itself.

### Output
Return the sum of the two binary numbers as a binary string.

### Examples

**Input:**
```
a = "11"
b = "1"
```

**Output:**
```
"100"
```

---

**Input:**
```
a = "1010"
b = "1011"
```

**Output:**
```
"10101"
```

---

## 2. The Missing Power of Two

A problem that teaches bit manipulation and the properties of the XOR operation. You are given an integer array `nums` of length `n`. Every number appears exactly twice except for one number that appears exactly once.

The optimal solution uses XOR because equal values cancel each other:

- `a ^ a = 0`
- `a ^ 0 = a`
- XOR is commutative and associative

Therefore, when all numbers in the array are XORed together, every duplicate pair cancels and the number appearing only once remains.

This problem helps build concepts like:
- Bitwise XOR
- Bit manipulation
- Constant extra-space algorithms
- Linear-time array processing

which are important for solving array problems under strict complexity requirements.

**Your task:** Find the number that appears only once.

### Input
An integer `n` representing the number of elements in the array, followed by `n` space-separated integers representing the elements of `nums`.

**Constraints:**
- `1 <= n <= 2 × 10^5`
- `1 <= nums[i] <= 10^9`
- Every element appears exactly twice except one element which appears exactly once.
- `n` is always odd.

### Output
Return the integer that appears only once in the array.

### Examples

**Input:**
```
7
4 1 2 1 2 4 7
```

**Output:**
```
7
```

---

**Input:**
```
9
5 3 8 3 5 8 12 9 9
```

**Output:**
```
12
```

---

**Input:**
```
5
10 6 10 6 15
```

**Output:**
```
15
```

---
