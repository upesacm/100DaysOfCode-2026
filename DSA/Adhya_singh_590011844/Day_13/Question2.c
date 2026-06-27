#include <stdio.h>
#include <string.h>

int countDistinct(char s[]) {
    int count = 0;

    for (int i = 0; s[i] != '\0'; i++) {
        int found = 0;
        for (int j = 0; j < i; j++) {
            if (s[i] == s[j]) {
                found = 1;
                break;
            }
        }
        if (!found)
            count++;
    }

    return count;
}

int main() {
    char s1[100], s2[100];

    scanf("%s", s1);
    scanf("%s", s2);

    if (countDistinct(s1) >= countDistinct(s2))
        printf("%s", s1);
    else
        printf("%s", s2);

    return 0;
}