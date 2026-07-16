#include <stdio.h>

void finalPrices(int prices[], int n) {
    int stack[500];
    int top = -1;

    for (int i = 0; i < n; i++) {
        while (top != -1 && prices[stack[top]] >= prices[i]) {
            prices[stack[top]] -= prices[i];
            top--;
        }
        stack[++top] = i;
    }
}

int main() {
    int n;

    printf("Enter number of items: ");
    scanf("%d", &n);

    int prices[500];

    printf("Enter prices:\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", &prices[i]);
    }

    finalPrices(prices, n);

    printf("Final prices:\n");
    for (int i = 0; i < n; i++) {
        printf("%d ", prices[i]);
    }
    printf("\n");
    return 0;
}