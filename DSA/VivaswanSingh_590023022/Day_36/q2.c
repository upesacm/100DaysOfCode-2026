#include <stdio.h>

#define MAX 1000

int serveMinute(int n, int k)
{
    int queue[MAX];
    int front = 0, rear = -1;

    for (int i = 1; i <= n; i++)
        queue[++rear] = i;

    int minute = 0;

    while (front <= rear)
    {
        minute++;

        int served = queue[front++];

        if (served == k)
            return minute;

        if (front <= rear && queue[front] % 2 != 0)
        {
            queue[++rear] = queue[front];
            front++;
        }
    }

    return -1;
}

int main()
{
    int n = 4, k = 3;

    printf("%d\n", serveMinute(n, k));

    return 0;
}