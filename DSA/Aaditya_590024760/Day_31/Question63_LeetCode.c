int* finalPrices(int* prices, int pricesSize, int* returnSize) {
    *returnSize = pricesSize;
    int* result = (int*)malloc(pricesSize * sizeof(int));
    int stack[pricesSize];
    int top = -1;

    for (int i = 0; i < pricesSize; i++)
        result[i] = prices[i];

    for (int i = 0; i < pricesSize; i++) {
        while (top != -1 && prices[stack[top]] >= prices[i]) {
            int idx = stack[top--];
            result[idx] = prices[idx] - prices[i];
        }
        stack[++top] = i;
    }

    return result;
}
