/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* finalPrices(int* prices, int pricesSize, int* returnSize) {
    *returnSize = pricesSize;
    int* ans = (int*)malloc(pricesSize * sizeof(int));
    int* stack = (int*)malloc(pricesSize * sizeof(int));
    int top = -1;
    for (int i = pricesSize - 1; i >= 0; i--) {
        while (top != -1 && stack[top] > prices[i]) {
            top--;
        }
        if (top == -1)
            ans[i] = prices[i];
        else
            ans[i] = prices[i] - stack[top];

        stack[++top] = prices[i];
    }
    free(stack);
    return ans;
}