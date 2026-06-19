#include <stdio.h>
#include <stdbool.h>

#define MAX 100000

bool checkEqual(int a[], int b[], int n) {
    int freq[MAX + 1] = {0};

    for (int i = 0; i < n; i++)
        freq[a[i]]++;

    for (int i = 0; i < n; i++) {
        if (--freq[b[i]] < 0)
            return false;
    }

    return true;
}

int main() {
    int a[] = {1,2,5,4,0};
    int b[] = {2,4,5,0,1};

    int n = sizeof(a) / sizeof(a[0]);

    printf("%s\n", checkEqual(a, b, n) ? "true" : "false");

    return 0;
}