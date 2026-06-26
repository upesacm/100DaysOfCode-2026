<h2 align="center">Week 2 Day 11 (25/06/2026)</h2>

## 1. Isomorphic Strings (LeetCode #205)

### Solution

```python
class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        # Dictionaries to store the last occurrence of characters
        first = {}
        second = {}
        # Traverse both strings
        for i in range(len(s)):
            # If previous occurrences are different
            if first.get(s[i], 0) != second.get(t[i], 0):
                return False
            # Store current position (+1 because default value is 0)
            first[s[i]] = i + 1
            second[t[i]] = i + 1
        return True
```

---

## 2. String Processing Task

### Solution

```python
class Solution:
    def solve(self, s: str) -> str:
        ans = ""

        # Traverse each character of the string
        for ch in s:
            # Convert uppercase letter to lowercase
            ch = ch.lower()

            # Check if the character is not a vowel
            if ch != 'a' and ch != 'e' and ch != 'i' and ch != 'o' and ch != 'u':
                # Add '.' before every consonant
                ans = ans + "." + ch

        return ans


# Input string
s = input("Enter the string: ")

# Create object and print the result
obj = Solution()
print("Output:", obj.solve(s))
```
