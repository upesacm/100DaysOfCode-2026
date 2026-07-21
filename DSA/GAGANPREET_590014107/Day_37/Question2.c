#include <stdio.h>

int main()
{
    int n, location;

    scanf("%d", &n);

    int priority[100];
    int index[100];

    for (int i = 0; i < n; i++)
    {
        scanf("%d", &priority[i]);
        index[i] = i;
    }

    scanf("%d", &location);

    int front = 0;
    int rear = n;
    int time = 0;

    while (front < rear)
    {
        int currentPriority = priority[front];
        int currentIndex = index[front];
        front++;

        int higher = 0;

        for (int i = front; i < rear; i++)
        {
            if (priority[i] > currentPriority)
            {
                higher = 1;
                break;
            }
        }

        if (higher)
        {
            priority[rear] = currentPriority;
            index[rear] = currentIndex;
            rear++;
        }
        else
        {
            time++;

            if (currentIndex == location)
            {
                printf("%d", time);
                return 0;
            }
        }
    }

    return 0;
}
