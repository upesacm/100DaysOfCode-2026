<h2 align="center">Week 2 Day 13 (27/06/2026)</h2>

## 1. Most Common Word (LeetCode #819)

### Solution

```python
class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        # Convert banned words into a set for faster lookup
        banned = set(banned)

        # Remove punctuation from the paragraph
        for ch in string.punctuation:
            paragraph = paragraph.replace(ch, " ")

        # Convert to lowercase and split into words
        words = paragraph.lower().split()

        # Dictionary to store frequency of each word
        freq = {}

        # Count frequency of non-banned words
        for word in words:
            if word not in banned:
                if word in freq:
                    freq[word] += 1
                else:
                    freq[word] = 1

        # Find the most frequent non-banned word
        answer = ""
        max_count = 0

        for word in freq:
            if freq[word] > max_count:
                max_count = freq[word]
                answer = word

        return answer
```

---

## 2. Better String

### Solution

```python
# Function to count all distinct subsequences
def countSubsequences(s):
    # Store all distinct subsequences in a set
    subsequences = {""}
    # Traverse each character of the string
    for ch in s:
        new_subsequences = set()
        # Append the current character to every existing subsequence
        for sub in subsequences:
            new_subsequences.add(sub + ch)
        # Add the newly formed subsequences to the set
        subsequences.update(new_subsequences)
    # Return the total number of distinct subsequences
    return len(subsequences)

# Function to determine the better string
def betterString(s1, s2):
    # Count distinct subsequences of both strings
    count1 = countSubsequences(s1)
    count2 = countSubsequences(s2)
    # Return s1 if it has more or equal distinct subsequences
    if count1 >= count2:
        return s1
    else:
        return s2
```
