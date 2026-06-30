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

// Insert node at the end
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

// Swap adjacent nodes
struct Node* swapPairs(struct Node* head) {
    if (head == NULL || head->next == NULL)
        return head;

    struct Node dummy;
    dummy.next = head;

    struct Node* prev = &dummy;

    while (head != NULL && head->next != NULL) {
        struct Node* first = head;
        struct Node* second = head->next;

        // Swapping
        prev->next = second;
        first->next = second->next;
        second->next = first;

        // Move pointers
        prev = first;
        head = first->next;
    }

    return dummy.next;
}

// Display linked list
void display(struct Node* head) {
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
    int n, value;

    printf("Enter number of nodes: ");
    scanf("%d", &n);

    printf("Enter the node values:\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", &value);
        insertEnd(&head, value);
    }

    printf("Original Linked List:\n");
    display(head);

    head = swapPairs(head);

    printf("Linked List after swapping adjacent nodes:\n");
    display(head);

    return 0;
}