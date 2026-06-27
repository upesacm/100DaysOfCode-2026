#include<stdio.h>
#include<string.h>
int main()
{
    char str[100];
    int freq[256]={0};
    int count=0,i,start=0,min=1000;
    printf("Enter string: ");
    scanf("%s",str);
    int n=strlen(str);
    for(i=0;i<n;i++)
    {
        if(freq[str[i]]==0)
            count++;
        freq[str[i]]++;
    }
    int window[256]={0};
    int start_index=0, matched=0;

    for(i=0;i<n;i++)
    {
        window[str[i]]++;
        if(window[str[i]]==1)
            matched++;
        while(matched==count)
        {
            if(min > i-start_index+1)
                min = i-start_index+1;
            window[str[start_index]]--;
            if(window[str[start_index]]==0)
                matched--;
            start_index++;
        }
    }
    printf("Smallest window length = %d",min);
    return 0;
}
