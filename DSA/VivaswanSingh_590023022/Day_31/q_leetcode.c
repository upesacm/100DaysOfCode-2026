/**
 * Note: The returned array must be malloced, assume caller calls free().
 */
int* finalPrices(int* prices, int pricesSize, int* returnSize)
{
    *returnSize = pricesSize;

    int *answer = (int *)malloc(pricesSize * sizeof(int));
    int stack[500];
    int top = -1;

    for (int i = pricesSize - 1; i >= 0; i--)
    {
        while (top >= 0 && stack[top] > prices[i])
        {
            top--;
        }

        if (top == -1)
            answer[i] = prices[i];
        else
            answer[i] = prices[i] - stack[top];

        stack[++top] = prices[i];
    }

    return answer;
}