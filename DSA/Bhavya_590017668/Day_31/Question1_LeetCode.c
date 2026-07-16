int* finalPrices(int* prices, int pricesSize, int* returnSize) {
    int *ans = (int*)malloc(pricesSize * sizeof(int));
    int stack[pricesSize], top = -1;
    *returnSize = pricesSize;
    for(int i = pricesSize - 1; i >= 0; i--){
        while(top != -1 && stack[top] > prices[i]){
            top--;
        }
        if(top == -1)
            ans[i] = prices[i];
        else
            ans[i] = prices[i] - stack[top];
        stack[++top] = prices[i];
    }
    return ans;
}