#include <stdio.h>
#include <string.h>
#include <math.h>
void encryption(char *s) 
{
    char str[1000];
    int n=0;
    for (int i = 0; s[i] != '\0'; i++) 
    {
        if (s[i] != ' ')
            str[n++] = s[i];
    }
    str[n] = '\0';
    int rows=sqrt(n);
    int cols=rows;
    if (rows*cols<n)
        cols++;
    if (rows*cols<n)
        rows++;
    for (int j=0;j<cols;j++) 
    {
        for (int i=0;i<rows;i++) 
        {
            int index=i*cols+j;
            if (index<n)
                printf("%c", str[index]);
        }
        if (j!=cols-1)
            printf(" ");
    }
}