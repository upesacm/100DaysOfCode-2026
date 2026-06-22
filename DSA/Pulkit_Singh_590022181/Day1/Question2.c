#include <stdio.h>


int main()
{
    int n,sum=0;
    scanf("%d",&n);
    int arr[n];

     for (int i = 0; i < n; i++) {
        scanf("%d", &arr[i]);
        sum += arr[i];
    }
    int ans=n*(n+1)/2;
    ans=ans-sum;
    printf("%d",ans);
    
    return 0;

    
}