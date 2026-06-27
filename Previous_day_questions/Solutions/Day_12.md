<h2 align="center">Week 2 Day 12 (26/06/2026)</h2>

## 1. Number of Lines To Write String (LeetCode #806)

### Solution

```python
class Solution:
    def numberOfLines(self, widths: List[int], s: str) -> List[int]:
        # Initially, one line is being used
        lines = 1
        # Current width occupied in the current line
        current_width = 0
        # Traverse each character in the string
        for ch in s:
            # Find the width of the current character
            width = widths[ord(ch) - ord('a')]
            # If the character fits in the current line
            if current_width + width <= 100:
                current_width += width
            # Otherwise, move to a new line
            else:
                lines += 1
                current_width = width
        # Return total lines and width of the last line
        return [lines, current_width]
```

---

## 2. Smallest Distinct Window

### Solution

```python
# Input string
s = input()
# Store all distinct characters of the string
distinct_chars = set(s)
# Total distinct characters required
total_distinct = len(distinct_chars)
# Initialize answer with maximum possible length
answer = len(s)
# Check every possible substring
for i in range(len(s)):
    # Store distinct characters in the current substring
    current = set()
    for j in range(i, len(s)):
        # Add current character
        current.add(s[j])
        # If all distinct characters are present
        if len(current) == total_distinct:
            # Update minimum length
            if (j - i + 1) < answer:
                answer = j - i + 1
            # No need to expand this substring further
            break
# Print the length of the smallest valid substring
print(answer)
```
