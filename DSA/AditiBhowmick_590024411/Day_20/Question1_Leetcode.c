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
void insertEnd(struct Node **head, int data) {
    struct Node *newNode = createNode(data);

    if (*head == NULL) {
        *head = newNode;
        return;
    }

    struct Node *temp = *head;
    while (temp->next != NULL)
        temp = temp->next;

    temp->next = newNode;
}

// Remove all nodes with the given value
struct Node* removeElements(struct Node *head, int val) {
    // Remove matching nodes from the beginning
    while (head != NULL && head->data == val) {
        struct Node *temp = head;
        head = head->next;
        free(temp);
    }

    struct Node *current = head;

    while (current != NULL && current->next != NULL) {
        if (current->next->data == val) {
            struct Node *temp = current->next;
            current->next = temp->next;
            free(temp);
        } else {
            current = current->next;
        }
    }

    return head;
}

// Display linked list
void display(struct Node *head) {
    if (head == NULL) {
        printf("NULL\n");
        return;
    }

    while (head != NULL) {
        printf("%d", head->data);
        if (head->next != NULL)
            printf(" -> ");
        head = head->next;
    }
    printf("\n");
}

int main() {
    struct Node *head = NULL;
    int n, value, val;

    printf("Enter number of nodes: ");
    scanf("%d", &n);

    printf("Enter node values:\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", &value);
        insertEnd(&head, value);
    }

    printf("Enter value to remove: ");
    scanf("%d", &val);

    printf("Original Linked List:\n");
    display(head);

    head = removeElements(head, val);

    printf("Updated Linked List:\n");
    display(head);

    return 0;
}