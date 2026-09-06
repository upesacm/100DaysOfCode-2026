<h2 align="center">Week 12 Day 82 (04/09/2026)</h2>

## 1. Number of Steps to Reduce a Number to Zero (LeetCode #1342)

A problem that teaches bit manipulation and repeated reduction of an integer. For an even number, divide it by `2`; for an odd number, subtract `1`.

The process continues until the number becomes zero.

This problem helps build concepts like:
- Even and odd number checking
- Division by `2`
- Bitwise operations
- Counting operations
- Binary representation

which are important for understanding how arithmetic operations can be implemented and optimized using bit manipulation.

**Your task:** Return the number of steps required to reduce `num` to zero. If the current number is even, divide it by `2`; otherwise, subtract `1`.

### Input
An integer `num` representing the given number.

**Constraints:**
- `0 <= num <= 10^6`

### Output
Return the number of steps required to reduce `num` to zero.

### Examples

**Input:**
```text
num = 14
```

**Output:**
```text
6
```

---

**Input:**
```text
num = 8
```

**Output:**
```text
4
```

---

**Input:**
```text
num = 123
```

**Output:**
```text
12
```

---

## 2. Turn Off the Rightmost Set Bit

A problem that teaches an important bit manipulation technique. You are given a positive integer `n`, and your task is to turn off its rightmost set bit, meaning the rightmost `1` bit in its binary representation must be changed to `0`.

The key observation is that the expression `n & (n - 1)` removes the rightmost set bit of `n`.

This problem helps build concepts like:
- Binary representation
- Set bits
- Bitwise AND
- Rightmost set bit
- `n & (n - 1)` bit manipulation technique

which are important for solving bit-level problems efficiently.

**Your task:** Turn off the rightmost set bit of `n` using bit manipulation and return the resulting integer.

### Input
A positive integer `n`.

**Constraints:**
- `1 <= n <= 10^9`

### Output
Return the integer obtained after turning off the rightmost set bit of `n`.

### Examples

**Input:**
```text
n = 12
```

**Output:**
```text
8
```

---

**Input:**
```text
n = 10
```

**Output:**
```text
8
```

---
