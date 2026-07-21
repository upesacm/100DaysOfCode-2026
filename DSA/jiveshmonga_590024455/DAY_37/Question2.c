#include <stdio.h>

int printerQueue(int priorities[],int n,int location) 
{
    int queue[100],front=0,rear=n-1;
    int printTime=0;
    for (int i=0;i<n;i++)
        queue[i]=i;
    while (front<=rear) 
    {
        int idx=queue[front];
        front++;

        int higher=0;
        for (int i=front;i<=rear;i++) {
            if (priorities[queue[i]]>priorities[idx]) 
            {
                higher=1;
                break;
            }
        }
        if (higher) 
        {
            rear++;
            queue[rear]=idx;
        }
        else 
        {
            printTime++;
            if (idx==location)
                return printTime;
        }
    }
    return printTime;
}

int main() 
{
    int n,location;
    scanf("%d",&n);
    int priorities[100];
    for (int i=0;i<n;i++)
        scanf("%d", &priorities[i]);
    scanf("%d",&location);
    printf("%d\n", printerQueue(priorities,n,location));
    return 0;
}