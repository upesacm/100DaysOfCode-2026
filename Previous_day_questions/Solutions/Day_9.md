<h2 align="center">Week 2 Day 9 (23/06/2026)</h2>

## 1. Length of Last Word (LeetCode #58)

### Solution

```c
int lengthOfLastWord(char* s) {
    int i = 0;
    int length = 0;

    // Find the end of the string
    while (s[i] != '\0') {
        i++;
    }

    // Move backwards and skip trailing spaces
    i--;
    while (i >= 0 && s[i] == ' ') {
        i--;
    }

    // Count characters of the last word
    while (i >= 0 && s[i] != ' ') {
        length++;
        i--;
    }

    return length;
}
```

---

## 2. Remove Spaces from String

### Solution

```c
#include <stdio.h>

int main() {
    char str[1000];
    int i = 0, j = 0;

    // Read the complete string including spaces
    fgets(str, sizeof(str), stdin);

    // Traverse the string
    while (str[i] != '\0') {
        // Copy only non-space characters
        if (str[i] != ' ') {
            str[j] = str[i];
            j++;
        }
        i++;
    }

    // Add null character at the end
    str[j] = '\0';

    // Print the modified string
    printf("%s", str);

    return 0;
}
```
