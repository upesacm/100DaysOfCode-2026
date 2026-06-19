/*  Q2: Given an integer array digits, where each element is a digit of a non-negative integer, 
return the array after adding one to the represented integer.   */


/**
 * Note: The returned array must be malloced, assume caller calls free().
 */



#include <stdio.h>
#include <stdlib.h>


int* plusOne(int* digits, int digitsSize, int* returnSize) 
{

    for (int i=digitsSize-1; i>=0 ; i--)
    {
        if (digits[i] < 9)
        {
            digits[i] += 1;
            
            *returnSize= digitsSize;

            int *result= (int*) malloc (digitsSize* sizeof(int));
            for (int j=0; j< *returnSize; j++)
            {
                result[j] = digits[j];
            }
            return result;
        }

        digits[i] = 0;

    }
        //for numbers like: 999, 9999

        *returnSize= digitsSize+1;
        int* specialresult = (int*) malloc (*returnSize * sizeof(int));

        specialresult[0]=1;

        for (int i=1; i< *returnSize; i++)
        {
            specialresult[i]=0;
        }

        return specialresult;
}

int main()
{
    int digits[] = {1, 2, 3};
    int digitsSize = sizeof(digits) / sizeof(digits[0]);
    int returnSize = 0;


    int *result = plusOne(digits, digitsSize, &returnSize);
    if (result == NULL)
    {
        return 1;
    }

    printf("Result: [");
    for (int i = 0; i < returnSize; i++)
    {
        printf("%d", result[i]);
        if (i + 1 < returnSize)
        {
            printf(", ");
        }
    }
    printf("]\n");

    free(result);
    return 0;
} 