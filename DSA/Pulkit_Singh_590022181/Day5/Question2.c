#include <stdio.h>
#include <stdbool.h>

int main() {
    int n;
    scanf("%d", &n);

    int a[n], b[n];

    for (int i = 0; i < n; i++)
        scanf("%d", &a[i]);

    for (int i = 0; i < n; i++)
        scanf("%d", &b[i]);

    int freq[100001] = {0};

    for (int i = 0; i < n; i++)
        freq[a[i]]++;

    for (int i = 0; i < n; i++)
        freq[b[i]]--;

    bool equal = true;

    for (int i = 0; i < 100001; i++) {
        if (freq[i] != 0) {
            equal = false;
            break;
        }
    }

    if (equal)
        printf("true");
    else
        printf("false");

    return 0;
}