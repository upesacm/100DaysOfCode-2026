#include <stdio.h>

int main() {
    char s[105];
    scanf("%s", s);

    int mask = 0;

    for (int i = 0; s[i] != '\0'; i++) {
        mask |= (1 << (s[i] - 'a'));
    }

    int distinct = 0;

    while (mask) {
        distinct += mask & 1;
        mask >>= 1;
    }

    if (distinct % 2 == 0)
        printf("CHAT WITH HER!\n");
    else
        printf("IGNORE HIM!\n");

    return 0;
}
