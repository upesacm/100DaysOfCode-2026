#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node* next;
};

// Create a new node
struct Node* createNode(int data) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->next = NULL;
    return newNode;
}

// Detect cycle
int detectCycle(struct Node* head) {

    struct Node* slow = head;
    struct Node* fast = head;

    while (fast != NULL && fast->next != NULL) {

        slow = slow->next;
        fast = fast->next->next;

        if (slow == fast)
            return 1;   // Cycle found
    }

    return 0;   // No cycle
}

int main() {

    // Creating nodes
    struct Node* head = createNode(3);
    head->next = createNode(2);
    head->next->next = createNode(0);
    head->next->next->next = createNode(-4);

    // Creating a cycle
    // Last node points to node with value 2
    head->next->next->next->next = head->next;

    if (detectCycle(head))
        printf("Cycle Detected\n");
    else
        printf("No Cycle\n");

    return 0;
}