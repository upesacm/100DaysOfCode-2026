#include <stdio.h>

int main() {
    int n, k;
    scanf("%d %d", &n, &k);

    int queue[1000];
    int front = 0, rear = 0;

    // Initialize queue with persons 1 to n
    for (int i = 1; i <= n; i++) {
        queue[rear++] = i;
    }

    int minute = 0;

    while (front < rear) {
        int served = queue[front++];
        minute++;

        if (served == k) {
            printf("%d", minute);
            break;
        }

        // If new front exists and is odd, move them to the back
        if (front < rear && queue[front] % 2 != 0) {
            queue[rear++] = queue[front];
            front++;
        }
    }

    return 0;
}
