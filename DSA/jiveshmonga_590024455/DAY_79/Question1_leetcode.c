#include <stdlib.h>
#include <string.h>
char* addBinary(char* a, char* b) 
{
    int n=strlen(a);
    int m=strlen(b);
    int size=(n>m?n:m)+2;
    char *result=malloc(size);
    int i=n-1;
    int j=m-1;
    int k=size-1;
    int carry=0;
    result[k]='\0';
    k--;
    while (i>=0||j>=0||carry) 
    {
        int sum=carry;
        if (i>=0)
            sum+=a[i--]-'0';
        if (j>=0)
            sum+=b[j--]-'0';
        result[k--]=(sum%2)+'0';
        carry=sum/2;
    }
    memmove(result,result+k+1,size-k-1);
    return result;
}