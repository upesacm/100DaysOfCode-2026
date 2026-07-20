#include <stdio.h>
#define MAX 500
int main()
{
    int n, k;
    int queue[MAX];
    int front = 0, rear = 0;
    int time = 0;
    scanf("%d %d", &n, &k);
    for(int i = 1; i <= n; i++)
    {
        queue[rear++] = i;
    }
    while(front < rear)
    {
        int person = queue[front++];
        time++;
        if(person == k)
        {
            printf("%d", time);
            return 0;
        }
        if(front < rear && queue[front] % 2 != 0)
        {
            queue[rear++] = queue[front];
            front++;
        }
    }
    return 0;
}