#include <stdio.h>
#include <stdlib.h>

// Structure for a node
struct Node {
    int data;
    struct Node *next;
};

// Function to create a new node
struct Node* createNode(int value) {
    struct Node *newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = value;
    newNode->next = NULL;
    return newNode;
}

// Function to insert a node at the end
void insertEnd(struct Node **head, int value) {
    struct Node *newNode = createNode(value);

    if (*head == NULL) {
        *head = newNode;
        return;
    }

    struct Node *temp = *head;
    while (temp->next != NULL) {
        temp = temp->next;
    }

    temp->next = newNode;
}

// Function to reverse the linked list
void reverseList(struct Node **head) {
    struct Node *prev = NULL;
    struct Node *current = *head;
    struct Node *nextNode = NULL;

    while (current != NULL) {
        nextNode = current->next;  // Store next node
        current->next = prev;      // Reverse the link
        prev = current;            // Move prev forward
        current = nextNode;        // Move current forward
    }

    *head = prev;
}

// Function to display the linked list
void display(struct Node *head) {
    struct Node *temp = head;

    while (temp != NULL) {
        printf("%d -> ", temp->data);
        temp = temp->next;
    }

    printf("NULL\n");
}

// Main function
int main() {
    struct Node *head = NULL;
    int n, value;

    printf("Enter the number of nodes: ");
    scanf("%d", &n);

    printf("Enter the node values:\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", &value);
        insertEnd(&head, value);
    }

    printf("\nOriginal Linked List:\n");
    display(head);

    reverseList(&head);

    printf("Reversed Linked List:\n");
    display(head);

    return 0;
}