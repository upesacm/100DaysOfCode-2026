#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *next;
};

// Create a new node
struct Node* createNode(int data) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->next = NULL;
    return newNode;
}

// Insert at end
void insertEnd(struct Node** head, int data) {
    struct Node* newNode = createNode(data);

    if (*head == NULL) {
        *head = newNode;
        return;
    }

    struct Node* temp = *head;
    while (temp->next != NULL)
        temp = temp->next;

    temp->next = newNode;
}

// Rotate list to the right by k positions
struct Node* rotateRight(struct Node* head, int k) {

    if (head == NULL || head->next == NULL || k == 0)
        return head;

    // Find length and last node
    int n = 1;
    struct Node* tail = head;

    while (tail->next != NULL) {
        tail = tail->next;
        n++;
    }

    // Reduce unnecessary rotations
    k = k % n;

    if (k == 0)
        return head;

    // Make list circular
    tail->next = head;

    // Find new tail
    int steps = n - k;
    struct Node* newTail = head;

    for (int i = 1; i < steps; i++)
        newTail = newTail->next;

    // New head
    struct Node* newHead = newTail->next;

    // Break the circle
    newTail->next = NULL;

    return newHead;
}

// Print the list
void printList(struct Node* head) {
    while (head != NULL) {
        printf("%d", head->data);
        if (head->next != NULL)
            printf(" -> ");
        head = head->next;
    }
    printf("\n");
}

int main() {

    struct Node* head = NULL;

    insertEnd(&head, 1);
    insertEnd(&head, 2);
    insertEnd(&head, 3);
    insertEnd(&head, 4);
    insertEnd(&head, 5);

    int k = 2;

    printf("Original List:\n");
    printList(head);

    head = rotateRight(head, k);

    printf("After Rotating by %d:\n", k);
    printList(head);

    return 0;
}