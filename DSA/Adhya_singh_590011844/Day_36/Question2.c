#include <stdio.h>

int ticketTime(int n, int k) {
    int queue[1000];
    int front = 0, rear = 0;

    for (int i = 1; i <= n; i++)
        queue[rear++] = i;

    int minute = 0;

    while (front < rear) {
        int person = queue[front++];
        minute++;

        if (person == k)
            return minute;

        if (front < rear && queue[front] % 2 == 1) {
            queue[rear++] = queue[front];
            front++;
        }
    }

    return -1;
}

int main() {
    int n, k;

    printf("Enter n and k: ");
    scanf("%d %d", &n, &k);

    printf("Person %d gets the ticket at minute %d\n", k, ticketTime(n, k));

    return 0;
}