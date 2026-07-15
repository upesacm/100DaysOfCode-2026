int* finalPrices(int* prices, int pricesSize, int* returnSize) {
    *returnSize = pricesSize;
    int *answer = (int *)malloc(pricesSize * sizeof(int));
    int *stack = (int *)malloc(pricesSize * sizeof(int));
    int top = -1;
    for(int i = 0; i < pricesSize; i++){
        answer[i] = prices[i];
    }
    for(int i = 0; i<pricesSize; i++){
        while (top != -1 && prices[i] <= prices[stack[top]]) {
            answer[stack[top]] -= prices[i];
            top--;
        } stack[++top] = i;
    }
    free(stack);
    return answer;
}