#include <stdio.h>
#include <stdlib.h>

typedef struct {
    int priority;
    int index;
} Document;

typedef struct {
    Document data[1000];
    int front;
    int rear;
    int size;
} Queue;

void initQueue(Queue *q) {
    q->front = 0;
    q->rear = -1;
    q->size = 0;
}

void enqueue(Queue *q, Document doc) {
    q->rear++;
    q->data[q->rear] = doc;
    q->size++;
}

Document dequeue(Queue *q) {
    Document doc = q->data[q->front];
    q->front++;
    q->size--;
    return doc;
}

int hasHigherPriority(Queue *q, int priority) {
    for (int i = q->front; i <= q->rear; i++) {
        if (q->data[i].priority > priority) {
            return 1;
        }
    }
    return 0;
}

int timeRequiredToPrint(int* priorities, int prioritiesSize, int location) {
    Queue q;
    initQueue(&q);

    for (int i = 0; i < prioritiesSize; i++) {
        Document doc;
        doc.priority = priorities[i];
        doc.index = i;
        enqueue(&q, doc);
    }

    int minutes = 0;

    while (q.size > 0) {
        Document current = dequeue(&q);

        if (hasHigherPriority(&q, current.priority)) {
            enqueue(&q, current);
        } else {
            minutes++;
            if (current.index == location) {
                return minutes;
            }
        }
    }

    return minutes;
}

int main() {
    int priorities[] = {2, 1, 3, 2};
    int prioritiesSize = sizeof(priorities) / sizeof(priorities[0]);
    int location = 2;

    int result = timeRequiredToPrint(priorities, prioritiesSize, location);
    printf("Output: %d\n", result);

    return 0;
}