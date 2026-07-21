#include <stdio.h>

int printerQueue(int priorities[], int n, int location){
    int queue[100];
    int front=0,rear=0;
    for(int i=0;i<n;i++)
        queue[rear++]=i;
    int time=0;
    while(front<rear){
        int current=queue[front++];
        int higher=0;
        for(int i=front;i<rear;i++){
            if(priorities[queue[i]]>priorities[current]){
                higher=1;
                break;
            }
        }
        if(higher)
            queue[rear++]=current;
        else{
            time++;
            if(current==location)
                return time;
        }
    }
    return time;
}

int main(){
    int priorities[]={2,1,3,2};
    int n=4;
    int location=2;
    printf("%d",printerQueue(priorities,n,location));
    return 0;
}