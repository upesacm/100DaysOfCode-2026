#include <stdio.h>


int main() {
    
    int n,location;
    printf("Enter size of priority queue: ");
    scanf("%d",&n);
    int priority[10000];
    int index[10000];
    printf("Enter elements: ");
    for(int i=0;i<n;i++){
        scanf("%d",&priority[i]);
        index[i]=i;
    }
    printf("Enter location: ");
    scanf("%d",&location);
    int front=0;
    int rear=n-1;
    int min=0;
    while(front<=rear){
        int max=0;
        for(int i=front;i<=rear;i++){
            
            if(priority[i]>max)
            max=priority[i];
        }
        if(priority[front]<max){
            rear++;
            priority[rear]=priority[front];
            index[rear]=index[front];
            front++;
        }
        else{
            min++;
            if(index[front]==location){
                printf("%d",min);
                return 0;
            }
            front++;
        }
    }
    
    return 0;
}
