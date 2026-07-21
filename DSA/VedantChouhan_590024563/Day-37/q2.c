#include <stdio.h>

#define MAX 100000

struct Document {
    int priority;
    int index;
};

int main() {

    int n, location;

    printf("Enter number of documents: ");
    scanf("%d", &n);

    struct Document queue[MAX];

    printf("Enter priorities:\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", &queue[i].priority);
        queue[i].index = i;
    }

    printf("Enter location: ");
    scanf("%d", &location);

    int front = 0;
    int rear = n;
    int time = 0;

    while (front < rear) {

        struct Document current = queue[front++];
        int higher = 0;

        for (int i = front; i < rear; i++) {
            if (queue[i].priority > current.priority) {
                higher = 1;
                break;
            }
        }

        if (higher) {
            queue[rear++] = current;
        } else {
            time++;

            if (current.index == location) {
                printf("Time to print your document: %d\n", time);
                break;
            }
        }
    }

    return 0;
}