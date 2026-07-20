// Ticket Counter Queue

#include <stdio.h>

int main()
{
    int n, k;

    printf("Enter number of people: ");
    scanf("%d", &n);

    printf("Enter person k: ");
    scanf("%d", &k);

    int queue[n];

    // Initialize queue
    for (int i = 0; i < n; i++)
    {
        queue[i] = i + 1;
    }

    int front = 0;
    int rear = n - 1;
    int minute = 0;

    while (1)
    {
        int person = queue[front];

        // Remove person from front
        front = (front + 1) % n;
        minute++;

        // Check if person k is served
        if (person == k)
        {
            printf("Person %d gets served at minute %d.\n", k, minute);
            break;
        }

        // Odd numbered person goes to the back
        if (person % 2 != 0)
        {
            rear = (rear + 1) % n;
            queue[rear] = person;
        }
    }

    return 0;
}