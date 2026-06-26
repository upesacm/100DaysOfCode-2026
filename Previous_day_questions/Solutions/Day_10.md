<h2 align="center">Week 2 Day 10 (24/06/2026)</h2>

## 1. Find the Index of the First Occurrence in a String (LeetCode #28)

### Solution

```c
int strStr(char* haystack, char* needle) {
    // If needle is empty, return 0
    if (needle[0] == '\0')
        return 0;
    int i, j;
    // Check every possible starting position in haystack
    for (i = 0; haystack[i] != '\0'; i++) {
        j = 0;
        // Compare characters of needle with haystack
        while (needle[j] != '\0' &&
               haystack[i + j] != '\0' &&
               haystack[i + j] == needle[j]) {
            j++;
        }
        // If we reached the end of needle,
        // then the whole substring matched
        if (needle[j] == '\0')
            return i;
    }
    // Substring not found
    return -1;
}
```

---

## 2. Determine Gender

### Solution

```c
#include <stdio.h>

int main() {
    char username[101];
    int freq[26] = {0}; // To store whether a character appeared or not
    int i, distinct = 0;

    // Input username
    scanf("%s", username);

    // Traverse the string
    for (i = 0; username[i] != '\0'; i++) {
        // If character is seen for the first time
        if (freq[username[i] - 'a'] == 0) {
            freq[username[i] - 'a'] = 1;
            distinct++;
        }
    }

    // Check if number of distinct characters is even or odd
    if (distinct % 2 == 0)
        printf("CHAT WITH HER!");
    else
        printf("IGNORE HIM!");

    return 0;
}
```
