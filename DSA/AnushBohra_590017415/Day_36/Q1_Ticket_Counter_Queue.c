#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

// Structure to represent a Circular Queue
struct Queue {
    int* arr;
    int front;
    int rear;
    int capacity;
    int size;
};

// Function to initialize the queue
struct Queue* createQueue(int capacity) {
    struct Queue* q = (struct Queue*)malloc(sizeof(struct Queue));
    q->capacity = capacity;
    q->front = 0;
    q->size = 0;
    q->rear = capacity - 1;
    q->arr = (int*)malloc(q->capacity * sizeof(int));
    return q;
}

// Check if queue is empty
bool isEmpty(struct Queue* q) {
    return (q->size == 0);
}

// Add an item to the queue
void enqueue(struct Queue* q, int item) {
    q->rear = (q->rear + 1) % q->capacity;
    q->arr[q->rear] = item;
    q->size++;
}

// Remove an item from the queue
int dequeue(struct Queue* q) {
    if (isEmpty(q)) return -1;
    int item = q->arr[q->front];
    q->front = (q->front + 1) % q->capacity;
    q->size--;
    return item;
}

// Get the front element without removing it
int getFront(struct Queue* q) {
    if (isEmpty(q)) return -1;
    return q->arr[q->front];
}

// Function to calculate time to serve person k
int timeToServe(int n, int k) {
    // We set capacity slightly larger to handle elements moving around safely
    struct Queue* q = createQueue(n * 2 + 1);
    int minutes = 0;

    // Fill the queue with initial people 1 to n
    for (int i = 1; i <= n; i++) {
        enqueue(q, i);
    }

    while (!isEmpty(q)) {
        // Step 1: Serve the front person
        int served_person = dequeue(q);
        minutes++;

        // If the served person is k, we found our answer
        if (served_person == k) {
            free(q->arr);
            free(q);
            return minutes;
        }

        // Step 2: Check the new front person
        if (!isEmpty(q)) {
            int new_front = getFront(q);
            if (new_front % 2 != 0) { // If the person's number is odd
                dequeue(q);           // Remove them from front
                enqueue(q, new_front); // Move them to the back
            }
        }
    }

    free(q->arr);
    free(q);
    return minutes;
}

int main() {
    int n = 4;
    int k = 3;
    
    int result = timeToServe(n, k);
    printf("Time taken for person %d to get served: %d minutes\n", k, result);
    
    return 0;
}