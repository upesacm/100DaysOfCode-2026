#include <stdio.h>
#include <string.h>
int countDistinct(char s[])
{
    int n=strlen(s);
    int dp[n+1];
    dp[0]=1;
    int last[256];
    for (int i=0;i<256;i++)
        last[i]=-1;
    for (int i=1;i<=n;i++)
        {
            dp[i]=2*dp[i-1];
            char ch=s[i-1];
            if (last[ch]!=-1)
            {
                dp[i]=dp[i]-dp[last[ch]];
            }
            last[ch]=i-1;
        }
    return dp[n];
}
char* betterString(char s1[], char s2[])
{
    int c1=countDistinct(s1);
    int c2=countDistinct(s2);
    if (c1>=c2)
        return s1;
    else
        return s2;
}
int main()
{
    char s1[]="abc";
    char s2[]="aac";
    printf("%s", betterString(s1,s2));
    return 0;
}
