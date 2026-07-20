#include <stdio.h>

#define MAX 1000

int main() {
    int n, k;
    int queue[MAX];
    int front = 0, rear = -1;
    int minute = 0;

    printf("Enter number of people (n): ");
    scanf("%d", &n);

    printf("Enter target person (k): ");
    scanf("%d", &k);

    for (int i = 1; i <= n; i++) {
        queue[++rear] = i;
    }

    while (front <= rear) {

        int served = queue[front++];
        minute++;

        if (served == k) {
            printf("Person %d receives the ticket at minute: %d\n", k, minute);
            break;
        }

        if (front <= rear && queue[front] % 2 != 0) {
            int person = queue[front++];
            queue[++rear] = person;
        }
    }

    return 0;
}