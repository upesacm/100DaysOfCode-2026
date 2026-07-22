#include <stdio.h>
#include <stdlib.h>

int* initialDeck(int n, int* returnSize) {
    int *deque = (int *)malloc(sizeof(int) * (2 * n));
    int front = n;
    int rear = n - 1;

    for (int card = n; card >= 1; card--) {
        if (front <= rear) {
            deque[--front] = deque[rear--];
        }
        deque[--front] = card;
    }

    int *ans = (int *)malloc(sizeof(int) * n);
    for (int i = 0; i < n; i++) {
        ans[i] = deque[front + i];
    }

    *returnSize = n;
    free(deque);
    return ans;
}

int main() {
    int n;
    scanf("%d", &n);

    int size;
    int *ans = initialDeck(n, &size);

    printf("[");
    for (int i = 0; i < size; i++) {
        printf("%d", ans[i]);
        if (i != size - 1)
            printf(", ");
    }
    printf("]");

    free(ans);
    return 0;
}