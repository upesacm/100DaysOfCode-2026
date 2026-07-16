#include <stdio.h>
#include <stdlib.h>

int* finalPrices(int prices[], int n) {
    int *result = (int *)malloc(n * sizeof(int));

    int stack[n];
    int top = -1;

    for (int i = 0; i < n; i++)
        result[i] = prices[i];

    for (int i = 0; i < n; i++) {
        while (top != -1 && prices[stack[top]] >= prices[i]) {
            result[stack[top]] -= prices[i];
            top--;
        }
        stack[++top] = i;
    }

    return result;
}

int main() {
    int n;

    printf("Enter number of items: ");
    scanf("%d", &n);

    int prices[n];

    printf("Enter prices:\n");
    for (int i = 0; i < n; i++)
        scanf("%d", &prices[i]);

    int *result = finalPrices(prices, n);

    printf("Final Prices: ");
    for (int i = 0; i < n; i++)
        printf("%d ", result[i]);

    printf("\n");

    free(result);
    return 0;
}