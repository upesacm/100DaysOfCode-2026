#include <stdio.h>
#include <string.h>
int main() {
    
    int n,x,j=0;
    int top=-1;
    printf("Enter size: ");
    scanf("%d",&n);
    int s[n];
    for(int i=0;i<n;i++){
        printf("Enter element: ");
        scanf("%d",&s[i]);
    }
    printf("Enter x: ");
    scanf("%d",&x);
    int ans[n+1];
    for(int i=n-1;i>=0;i--) ans[++top]=s[i];
    ans[++top]=x;
    for(int i=top;i>=0;i--) s[j++]=ans[i];
    printf("Output: ");
    for(int i=0;i<n+1;i++) printf("%d ",s[i]);
    return 0;
}
