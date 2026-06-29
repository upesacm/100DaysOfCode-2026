#include <stdio.h>
#include <string.h>
int countDistinctSubseq(char *s){
    int n=strlen(s);
    long long dp[n+1];
    int last[256];
    for(int i=0;i<256;i++) 
      last[i]=-1;
    dp[0]=1;
    for(int i=1;i<=n;i++){
        dp[i]=2*dp[i-1];
        if(last[(unsigned char)s[i-1]]!=-1){
            dp[i]-=dp[last[(unsigned char)s[i-1]]];
        }
        last[(unsigned char)s[i-1]]=i-1;
    }
    return dp[n];
}
int main() {
    char s1[1000], s2[1000];
    printf("Enter first string: ");
    scanf("%s", s1);
    printf("Enter second string: ");
    scanf("%s", s2);
    int c1=countDistinctSubseq(s1);
    int c2=countDistinctSubseq(s2);
    if(c1>=c2)
        printf("%s\n", s1);
    else
        printf("%s\n", s2);
    return 0;
}
