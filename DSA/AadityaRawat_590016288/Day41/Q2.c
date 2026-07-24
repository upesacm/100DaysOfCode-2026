#include <stdio.h>
#include <stdlib.h>

char* predictWinner(char* jobs) {
    int n = 0;
    while (jobs[n] != '\0')
        n++;

    int *sales = (int *)malloc(n * 2 * sizeof(int));
    int *marketing = (int *)malloc(n * 2 * sizeof(int));

    int sf = 0, sr = 0;
    int mf = 0, mr = 0;

    for (int i = 0; i < n; i++) {
        if (jobs[i] == 'S')
            sales[sr++] = i;
        else
            marketing[mr++] = i;
    }

    while (sf < sr && mf < mr) {
        int s = sales[sf++];
        int m = marketing[mf++];

        if (s < m)
            sales[sr++] = s + n;
        else
            marketing[mr++] = m + n;
    }

    free(sales);
    free(marketing);

    if (sf < sr)
        return "Sales";
    else
        return "Marketing";
}

int main() {
    char jobs[] = "SMM";
    printf("%s\n", predictWinner(jobs));
    return 0;
}