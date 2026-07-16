<h2 align="center">Week 4 Day 27 (11/07/2026)</h2>

## 1. String Compression (LeetCode #443)
A problem that teaches string traversal and in place modification techniques by compressing consecutive repeating characters. Given an array of characters chars, compress the array such that consecutive repeating characters are replaced by the character followed by its frequency count. Return the length of the compressed array after modification.

This problem is commonly asked in interviews and helps build concepts like:
- Two pointers
- String compression

which are important for efficient string manipulation problems.

**Your task:** Compress the given character array using an optimized approach.

### Examples

**Input:**
```
chars = ["a","a","b","b","c","c","c"]
```
**Output:**
```
6
```

---

**Input:**
```
chars = ["a"]
```
**Output:**
```
1
```

---

**Input:**
```
chars = ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
```
**Output:**
```
43
```

---

## 2. Subarrays with Bounded Maximum
A problem that teaches sliding window and array traversal techniques by counting subarrays whose maximum value lies within a specified range. Given an integer array arr[] and two integers l and r, count the number of subarrays where the maximum element is at least l and at most r.

This problem is commonly asked in interviews and helps build concepts like:
- Sliding window
- Subarray counting
- Range based processing

which are important for efficient array processing problems.

**Your task:** Count all valid subarrays whose maximum element lies within the range [l, r] using an optimized approach.

### Examples

**Input:**
```
arr[] = [1,2,3,4,5], l = 2, r = 5
```
**Output:**
```
14
```

---

**Input:**
```
arr[] = [3,1,6,4], l = 3, r = 6
```
**Output:**
```
9
```

---

**Input:**
```
arr[] = [1,2,3,4], l = 5, r = 7
```
**Output:**
```
0
```

---
