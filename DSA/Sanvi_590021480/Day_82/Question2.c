#include <stdio.h>


int main(){

    int n;
    printf("Enter number: ");
    scanf("%d",&n);
    int res=n&(n-1);
    printf("%d",res);

    return 0;
}
