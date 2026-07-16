#include <stdio.h>
#include <stdlib.h>

int* finalPrices(int* prices, int pricesSize, int* returnSize) {
    *returnSize = pricesSize;
    int* result = (int*)malloc(pricesSize * sizeof(int));
    int* stack = (int*)malloc(pricesSize * sizeof(int));
    int top = -1;

    for (int i = 0; i < pricesSize; i++) {
        result[i] = prices[i];
    }

    for (int i = 0; i < pricesSize; i++) {
        while (top >= 0 && prices[stack[top]] >= prices[i]) {
            int index = stack[top--];
            result[index] = prices[index] - prices[i];
        }
        stack[++top] = i;
    }

    free(stack);
    return result;
}

int main() {
    int prices[] = {8, 4, 6, 2, 3};
    int pricesSize = sizeof(prices) / sizeof(prices[0]);
    int returnSize;

    int* final_prices = finalPrices(prices, pricesSize, &returnSize);

    for (int i = 0; i < returnSize; i++) {
        printf("%d ", final_prices[i]);
    }
    printf("\n");

    free(final_prices);
    return 0;
}