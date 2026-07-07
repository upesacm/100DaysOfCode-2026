#include <stdio.h>
#include <string.h>
#include <stdbool.h>

void process(char *str, char *result)
{
    int top=-1;
    for (int i=0; str[i]!='\0';i++)
    {
        if (str[i]=='#')
        {
            if (top>=0)
                top--;
        }
        else
        {
            result[++top]=str[i];
        }
    }
    result[top+1]='\0';
}
bool backspaceCompare(char *s,char *t)
{
    char res1[201],res2[201];
    process(s,res1);
    process(t,res2);
    return strcmp(res1,res2)==0;
}
int main()
{
    char s[]="ab#c";
    char t[]="ad#c";
    if (backspaceCompare(s,t))
        printf("true\n");
    else
        printf("false\n");
    return 0;
}