#include <stdio.h>

int servedMinute(int n, int k) {
    int queue[100000];
    int front = 0, rear = 0;

    // Initial queue
    for (int i = 1; i <= n; i++)
        queue[rear++] = i;

    int minute = 0;

    while (front < rear) {
        int person = queue[front++];
        minute++;

        if (person == k)
            return minute;

        if (person % 2 == 1)
            queue[rear++] = person;
    }

    return -1;
}

int main() {
    int n, k;

    scanf("%d %d", &n, &k);

    printf("%d\n", servedMinute(n, k));

    return 0;
}