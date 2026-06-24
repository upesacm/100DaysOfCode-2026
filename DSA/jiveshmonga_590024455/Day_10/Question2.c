#include<stdio.h>
#include<string.h>
int main()
{
    char str[100];
    int i,j,count=0;
    printf("Enter a string: ");
    scanf("%s",str);
    for(i=0; str[i]!='\0'; i++)
    {
        int found=0;
        for(j=0; j<i; j++)
        {
            if(str[i]==str[j])
            {
                found=1;
                break;
            }
        }
        if(found==0)
        {
            count++;
        }
    }
    if(count%2==0)
    {
        printf("CHAT WITH HER!");
    }
    else
    {
        printf("IGNORE HIM!");
    }
    return 0;
}
