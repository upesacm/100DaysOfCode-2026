#include <stdio.h>
#include <string.h>

int main() {
    char haystack[1000];
    char needle[1000];

    printf("Enter haystack: ");
    fgets(haystack, sizeof(haystack), stdin);

    printf("Enter needle: ");
    fgets(needle, sizeof(needle), stdin);

    // Remove newline characters
    haystack[strcspn(haystack, "\n")] = '\0';
    needle[strcspn(needle, "\n")] = '\0';

    int n = strlen(haystack);
    int m = strlen(needle);

    int index = -1;

    for (int i = 0; i <= n - m; i++) {
        int j;

        for (j = 0; j < m; j++) {
            if (haystack[i + j] != needle[j]) {
                break;
            }
        }

        if (j == m) {
            index = i;
            break;
        }
    }

    printf("%d\n", index);

    return 0;
}