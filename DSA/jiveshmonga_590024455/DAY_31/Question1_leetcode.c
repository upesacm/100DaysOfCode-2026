#include<stdio.h>

int* finalPrices(int* prices, int pricesSize, int* returnSize) {
*returnSize=pricesSize;

int *ans=(int *)malloc(sizeof(int)*pricesSize);

int stack[pricesSize];

int top=-1;

for(int i=pricesSize-1;i>=0;i--)
{
    while(top!=-1 && stack[top]>prices[i])
    {
        top--;
    }
    if(top==-1)
        ans[i]=prices[i];
    else
        ans[i]=prices[i]-stack[top];

    stack[++top]=prices[i];
}
return ans;
}