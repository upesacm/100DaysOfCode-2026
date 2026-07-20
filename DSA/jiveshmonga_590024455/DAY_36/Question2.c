#include <stdio.h>
int main() 
{
    int n,k;
    scanf("%d %d",&n,&k);
    int q[1000];
    int front=0,rear=0;
    for (int i = 1; i <= n; i++)
        q[rear++] = i;
    int minute=0;
    while (front<rear) 
    {
        minute++;
        int served=q[front++];
        if (served == k) 
        {
            printf("%d\n", minute);
            break;
        }
        if (front < rear) 
        {   
            if (q[front]%2!=0) 
            {
                q[rear++]=q[front];
                front++;
            }
        }
    }
    return 0;
}