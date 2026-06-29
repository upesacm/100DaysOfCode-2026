#include<stdio.h>
#include<string.h>
#include<ctype.h>
char* mostCommonWord(char* paragraph,char** banned,int bannedSize)
{
    static char words[1000][20];
    static int freq[1000];
    int n=0,k=0;
    char temp[20];
    for (int i = 0; ;i++)
        {
            if (isalpha(paragraph[i]))
            {
                temp[k++]=tolower(paragraph[i]);
            }
            else
            {
                if(k>0)
                {
                    temp[k]='\0';
                    k=0;
                    int ban=0;
                    for (int j=0;j<bannedSize;j++)
                    {
                        if (strcmp(temp,banned[j])==0)
                            ban=1;
                    }
                    if (!ban)
                    {
                        int found=-1;
                        for (int j=0;j<n;j++)
                        {
                            if (strcmp(words[j],temp)==0)
                            found=j;
                        }
                        if (found==-1)
                        {
                            strcpy(words[n],temp);
                            freq[n++]=1;
                        }
                        else
                        {
                            freq[found]++;
                        }
                    }
                }
                if (paragraph[i]=='\0')
                    break;
        }
    }
    int max=0;
    for (int i=1;i<n;i++) {
        if (freq[i]>freq[max])
            max=i;
    }
    return words[max];
}
