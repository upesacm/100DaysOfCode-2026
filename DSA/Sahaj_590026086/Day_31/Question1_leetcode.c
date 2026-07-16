int* finalPrices(int* prices, int pricesSize, int* returnSize) {
    *returnSize=pricesSize;
    int* stack=(int*)malloc(sizeof(int)*pricesSize);
    int top=-1;
    for (int i=0;i<pricesSize;i++) {
        while (top>=0&&prices[stack[top]]>=prices[i]){
            prices[stack[top]]-=prices[i];
            top--;
        }
        stack[++top]=i;
    }
    return prices;
}
