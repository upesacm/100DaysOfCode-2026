#include<stdio.h>
int lengthOfLastWord(char* s)
{
int len=strlen(s);
int count=0;
while(len>0&&s[len-1]==' ')
{
    len--;
}
while(len>0 && s[len-1]!=' ')
{
    count++;
    len--;
}
return count;
}
