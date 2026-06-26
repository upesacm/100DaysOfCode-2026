#include <stdio.h>
#include <string.h>
#include <ctype.h>

int isPalindrome(char* s) {
    int left = 0, right = strlen(s) - 1;

    while (left < right) {
        while (left < right && !isalnum(s[left]))
            left++;
        while (left < right && !isalnum(s[right]))
            right--;

        if (tolower(s[left]) != tolower(s[right]))
            return 0;

        left++;
        right--;
    }

    return 1;
}

int main() {
    char s[1000];

    printf("Enter a string: ");
    fgets(s, sizeof(s), stdin);
    s[strcspn(s, "\n")] = '\0';

    if (isPalindrome(s))
        printf("%s is a Palindrome\n", s);
    else
        printf("%s is not a Palindrome\n", s);

    return 0;
}
