#include <stdio.h>
#include <string.h>

int main() {
    char username[101];
    int freq[26] = {0};
    int distinct = 0;

    scanf("%s", username);

    for (int i = 0; username[i] != '\0'; i++) {
        if (freq[username[i] - 'a'] == 0) {
            freq[username[i] - 'a'] = 1;
            distinct++;
        }
    }

    if (distinct % 2 == 0)
        printf("CHAT WITH HER!");
    else
        printf("IGNORE HIM!");

    return 0;
}