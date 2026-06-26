<h2 align="center">Week 2 Day 8 (22/06/2026)</h2>

## 1. Valid Palindrome (LeetCode #125)

### Solution

```c
#include <stdbool.h>
#include <string.h>

bool isPalindrome(char *s) {
    char str[100000];
    int k = 0;

    // Copy only letters and digits
    for (int i = 0; s[i] != '\0'; i++) {
        // Convert uppercase to lowercase
        if (s[i] >= 'A' && s[i] <= 'Z') {
            str[k++] = s[i] + 32;
        }
        // Store lowercase letters
        else if (s[i] >= 'a' && s[i] <= 'z') {
            str[k++] = s[i];
        }
        // Store digits
        else if (s[i] >= '0' && s[i] <= '9') {
            str[k++] = s[i];
        }
    }

    // Check palindrome
    int left = 0;
    int right = k - 1;
    while (left < right) {
        if (str[left] != str[right]) {
            return false;
        }
        left++;
        right--;
    }
    return true;
}
```

---

## 2. Reverse a String

### Solution

```c
#include <stdio.h>
#include <string.h>

int main() {
    char s[1000];

    // Read the string
    scanf("%s", s);

    // Find the length of the string
    int n = strlen(s);

    // Reverse the string by swapping characters
    for (int i = 0; i < n / 2; i++) {
        char temp = s[i];
        s[i] = s[n - 1 - i];
        s[n - 1 - i] = temp;
    }

    // Print the reversed string
    printf("%s\n", s);

    return 0;
}
```
