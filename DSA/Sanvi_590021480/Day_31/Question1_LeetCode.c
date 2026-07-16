/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* finalPrices(int* prices, int pricesSize, int* returnSize) {
    int *arr=malloc(sizeof(int)*pricesSize);
    for(int i=0;i<pricesSize;i++){
        int flag=0;
        for(int j=i+1;j<pricesSize;j++){
            if(prices[j]<=prices[i]){
                arr[i]=prices[i]-prices[j];
                flag=0;
                break;
            }
            else{
                flag=1;
                continue;
            }
        }
        if(flag==1){
            arr[i]=prices[i];
        }
    }
    arr[pricesSize-1]=prices[pricesSize-1];
    *returnSize=pricesSize;
    return arr;
}
