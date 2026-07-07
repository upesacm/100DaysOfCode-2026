#include <stdio.h>
#include <stdlib.h>

int compare(const void *a, const void *b) {
    return (*(int *)a - *(int *)b);
}

int findContentChildren(int g[], int gSize, int s[], int sSize) {

    qsort(g, gSize, sizeof(int), compare);
    qsort(s, sSize, sizeof(int), compare);

    int i = 0; // Children
    int j = 0; // Cookies

    while (i < gSize && j < sSize) {

        if (s[j] >= g[i]) {
            i++;
        }

        j++;
    }

    return i;
}

int main() {

    int g[] = {1, 2, 3};
    int s[] = {1, 1};

    int gSize = sizeof(g) / sizeof(g[0]);
    int sSize = sizeof(s) / sizeof(s[0]);

    printf("Maximum satisfied children: %d\n",
           findContentChildren(g, gSize, s, sSize));

    return 0;
}