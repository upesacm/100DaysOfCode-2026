#include <stdlib.h>

int* finalPrices(int* prices, int pricesSize, int* returnSize) {
    int* answer = (int*)malloc(pricesSize * sizeof(int));
    int* stack = (int*)malloc(pricesSize * sizeof(int));

    int top = -1;

    *returnSize = pricesSize;

    for (int i = pricesSize - 1; i >= 0; i--) {

        // Remove prices that cannot be the discount
        while (top >= 0 && stack[top] > prices[i]) {
            top--;
        }

        // If a valid discount exists
        if (top >= 0) {
            answer[i] = prices[i] - stack[top];
        } else {
            answer[i] = prices[i];
        }

        // Push current price
        stack[++top] = prices[i];
    }

    free(stack);

    return answer;
}