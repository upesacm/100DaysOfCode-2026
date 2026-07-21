#include <stdio.h>

#define SIZE 100000

typedef struct {
    int priority;
    int index;
} Document;

int timeRequiredToPrint(int priorities[], int n, int location) {
    Document queue[SIZE];
    int count[10] = {0};

    int front = 0;
    int rear = n;

    for (int i = 0; i < n; i++) {
        queue[i].priority = priorities[i];
        queue[i].index = i;
        count[priorities[i]]++;
    }

    int highestPriority = 9;
    int time = 0;

    while (front < rear) {
        Document current = queue[front++];

        while (highestPriority > 0 &&
               count[highestPriority] == 0) {
            highestPriority--;
        }

        if (current.priority < highestPriority) {

            queue[rear++] = current;
        } else {

            time++;
            count[current.priority]--;

            if (current.index == location)
                return time;
        }
    }

    return time;
}

int main() {
    int n, location;

    printf("Enter number of documents: ");
    scanf("%d", &n);

    int priorities[n];

    printf("Enter priorities:\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", &priorities[i]);
    }

    printf("Enter your document location: ");
    scanf("%d", &location);

    int result = timeRequiredToPrint(priorities, n, location);

    printf("Time required: %d minutes\n", result);

    return 0;
}