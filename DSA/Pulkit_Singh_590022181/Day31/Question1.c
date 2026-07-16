#include <stdio.h>

#define MAX 500

void finalPrices(int prices[], int n) {

    int stack[MAX];
    int top = -1;

    for (int i = 0; i < n; i++) {

        while (top != -1 && prices[stack[top]] >= prices[i]) {
            prices[stack[top]] -= prices[i];
            top--;
        }

        stack[++top] = i;
    }
}

void printArray(int arr[], int n) {

    printf("[");

    for (int i = 0; i < n; i++) {
        printf("%d", arr[i]);

        if (i != n - 1)
            printf(", ");
    }

    printf("]\n");
}

int main() {

    int prices[] = {8, 4, 6, 2, 3};
    int n = sizeof(prices) / sizeof(prices[0]);

    printf("Original Prices: ");
    printArray(prices, n);

    finalPrices(prices, n);

    printf("Final Prices: ");
    printArray(prices, n);

    return 0;
}