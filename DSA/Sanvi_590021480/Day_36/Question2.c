#include <stdio.h>
#define max 500

int main() {
    
    int q[max];
    int front=0;
    int rear=-1;
    int n,k;
    printf("Enter n: ");
    scanf("%d",&n);
    printf("Enter k: ");
    scanf("%d",&k);
    int min=0;
    for(int i=1;i<=n;i++){
        q[++rear]=i;
    }

    while(front<=rear){
        int served=q[front++];
        min++;

        if(served==k){
            printf("%d",min);
            return 0;
        }
        if(front<=rear && q[front]%2!=0){
            int temp=q[front++];
            q[++rear]=temp;
        }
    }
    return 0;
}
