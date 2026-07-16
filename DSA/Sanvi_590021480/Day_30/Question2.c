#include <stdio.h>
#include <string.h>

int main() {
    
    int n,x;
    int top=-1;
    printf("Enter the size of stack: ");
    scanf("%d",&n);
    int s[n];
    printf("Enter elements: ");
    for(int i=0;i<n;i++){
        scanf("%d",&s[i]);
    }
    printf("Enter x: ");
    scanf("%d",&x);
    int stack[n+1];
    for(int i=n-1;i>=0;i--){
        stack[++top]=s[i];
    }
    stack[++top]=x;
    int j=0;
    for(int i=top;i>=0;i--){
        s[j++]=stack[i];
    }
    for(int i=0;i<n+1;i++){
        printf("%d ",s[i]);
    }
    return 0;
}
