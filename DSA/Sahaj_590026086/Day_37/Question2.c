#include <stdio.h>
int main() {
    int n, loc;
    printf("Enter the number of elements you want to add:");
    scanf("%d", &n);
    int priority[n];
    for (int i=0;i<n;i++){
        printf("Enter the element:");
        scanf("%d", &priority[i]);
    }
    printf("Enter the location:");
    scanf("%d", &loc);

    int queue[n], front=0, rear=n-1;
    for (int i=0;i<n;i++)
        queue[i]=i;

    int time=0;
    while (1){
        int curr=queue[front];
        front++;
        int flag=1;
        for (int i=front;i<=rear;i++){
            if (priority[queue[i]]>priority[curr]) {
                flag=0;
                break;
            }
        }
        if (!flag) {
            queue[++rear]=curr;
        }else{
            time++;
            if (curr==loc){
                printf("%d\n", time);
                break;
            }
        }
    }
    return 0;
}
