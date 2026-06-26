/*   Q1: Reverse the given string and print the reversed result.
Example:
Input: Computer. Output: retupmoC    */


#include <stdio.h>
#include <string.h>

int main()
{
    int i,n,len;

    scanf("%d",&n);


    char str[n];

    scanf("%s",str);

    len = strlen(str);


    for (i=0; i<len/2; i++)
    {
        char temp = str[i];
        str[i] = str[len-1-i];
        str[len-1-i] = temp;
    }


    printf("%s",str);

    return 0;
}