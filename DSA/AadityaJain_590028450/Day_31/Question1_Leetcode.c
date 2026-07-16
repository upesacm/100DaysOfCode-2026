/*Final Prices With a Special Discount in a Shop
Explanation
Given the prices of items in a shop, find the final price of each item after subtracting the first smaller or equal price that appears to its right.*/

/**
 * Note: The returned array must be malloced, assume caller calls free().
 */


int* finalPrices(int* prices, int pricesSize, int* returnSize) {
    *returnSize = pricesSize;
    int i, j;
    int *result = (int *)malloc(sizeof(int) * pricesSize);

    for(i = 0; i < pricesSize; i++){
        result[i] = prices[i];

        for(j = i + 1; j < pricesSize; j++){
            if(prices[j] <= prices[i]){
                result[i] = prices[i] - prices[j];
                break;
            }
        }
    }

    return result;
}