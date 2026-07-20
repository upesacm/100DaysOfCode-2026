#include <stdio.h>

#define MAX 500

int main() {

    int n, k;
    scanf("%d %d", &n, &k);

    int queue[MAX];
    int front = 0, rear = 0;

    for (int i = 1; i <= n; i++) {
        queue[rear++] = i;
    }

    int minute = 0;

    while (front < rear) {

        minute++;

        int served = queue[front++];

        if (served == k) {
            printf("%d\n", minute);
            break;
        }

        if (front < rear && queue[front] % 2 != 0) {
            queue[rear++] = queue[front];
            front++;
        }
    }

    return 0;
}