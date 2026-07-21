#include <stdio.h>

#define MAX 10000

struct RecentCounter {
    int queue[MAX];
    int front;
    int rear;
};

void initRecentCounter(struct RecentCounter *rc) {
    rc->front = 0;
    rc->rear = 0;
}

int ping(struct RecentCounter *rc, int t) {

    rc->queue[rc->rear++] = t;

    while (rc->front < rc->rear && rc->queue[rc->front] < t - 3000) {
        rc->front++;
    }

    return rc->rear - rc->front;
}

int main() {

    struct RecentCounter rc;
    initRecentCounter(&rc);

    printf("%d\n", ping(&rc, 1));
    printf("%d\n", ping(&rc, 100));
    printf("%d\n", ping(&rc, 3001));
    printf("%d\n", ping(&rc, 3002));

    return 0;
}