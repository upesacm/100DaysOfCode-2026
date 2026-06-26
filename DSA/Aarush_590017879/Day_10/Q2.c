#include <stdio.h>
#include <string.h>

int main() {
    char str[101];
    scanf("%s", str);

    int freq[26] = {0};
    int distinct = 0;

    for (int i = 0; str[i] != '\0'; i++) {
        if (freq[str[i] - 'a'] == 0) {
            freq[str[i] - 'a'] = 1;
            distinct++;
        }
    }

    if (distinct % 2 == 0)
        printf("CHAT WITH HER!");
    else
        printf("IGNORE HIM!");

    return 0;
}