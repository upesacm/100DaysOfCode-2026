#include <stdio.h>
#define SIZE 5

int queue[SIZE], front = -1, rear = -1;

void enqueue(int reviewID) {
    if ((rear + 1) % SIZE == front) {
        printf("Queue Full\n");
        return;
    }

    if (front == -1)
        front = 0;

    rear = (rear + 1) % SIZE;    
    queue[rear] = reviewID;
}

int dequeue() {
    if (front == -1) {    
        printf("Queue Empty\n");
        return -1;
    }

    int review = queue[front];

    if (front == rear) {
        front = rear = -1;   
    } else {
        front = (front + 1) % SIZE;
    }

    return review;
}

void display() {
    if (front == -1) {
        printf("No pending reviews\n");
        return;
    }

    printf("Pending Reviews: ");

    int i = front;
    while (1) {      
        printf("%d ", queue[i]);
        if (i == rear)
            break;
        i = (i + 1) % SIZE;
    }

    printf("\n");
}

int main() {
    enqueue(101);
    enqueue(102);
    enqueue(103);

    printf("Processed Review: %d\n", dequeue());

    enqueue(104);
    enqueue(105);

    display();

    return 0;
}