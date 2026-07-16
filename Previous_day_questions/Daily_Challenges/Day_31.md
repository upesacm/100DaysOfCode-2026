<h2 align="center">Week 5 Day 31 (15/07/2026)</h2>

## 1. Final Prices With a Special Discount in a Shop (LeetCode #1475)
A problem that teaches stack simulation and array traversal techniques by calculating discounted prices using a stack. You are given an integer array prices where prices[i] is the price of the ith item in a shop. There is a special discount for items in the shop: if you buy the ith item, you receive a discount equal to prices[j], where j is the minimum index such that j > i and prices[j] <= prices[i]. If no such index exists, you receive no discount.

This problem is commonly asked in interviews and helps build concepts like:
- Stack simulation
- Array traversal

which are important for efficient price calculation and comparison problems.

**Your task:** Calculate the final discounted price for every item in the shop using an optimized approach.

### Examples

**Input:**
```
prices = [8,4,6,2,3]
```
**Output:**
```
[4,2,4,2,3]
```

---

**Input:**
```
prices = [1,2,3,4,5]
```
**Output:**
```
[1,2,3,4,5]
```

---

## 2. Next Greater Element in Array
A problem that teaches stack and array traversal techniques by finding the next greater element for every array element. Given an integer array arr[], find the Next Greater Element (NGE) for each element in the array. The Next Greater Element of an element x is the first greater element present on its right side in the array. If no greater element exists, return -1 for that position.

This problem is commonly asked in interviews and helps build concepts like:
- Stack operations
- Array traversal

which are important for efficient range query and comparison problems.

**Your task:** Find the next greater element for every array element using an optimized approach.

### Examples

**Input:**
```
arr[] = [1,3,2,4]
```
**Output:**
```
[3,4,4,-1]
```

---

**Input:**
```
arr[] = [6,8,0,1,3]
```
**Output:**
```
[8,-1,1,3,-1]
```

---
