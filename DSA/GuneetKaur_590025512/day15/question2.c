//reverse singly linked list

#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node* next;
};

struct Node* reverseList(struct Node* head) {
    struct Node* prev = NULL;
    struct Node* current = head;
    struct Node* nextnode = head;

    while (nextnode != NULL) {
        nextnode = nextnode->next;
        current->next = prev;
        prev = current;
        current = nextnode;
    }

    return prev;
}

void createList(struct Node** head, int n) {
    struct Node* newNode;
    struct Node* temp;
    for (int i = 0; i < n; i++) {
        newNode = (struct Node*)malloc(sizeof(struct Node));
        printf("Enter data for node %d: ", i + 1);
        scanf("%d", &newNode->data);
        newNode->next = NULL;

        if (*head == NULL) {
            *head = newNode;
            temp = *head;
        } else {
            temp->next = newNode;
            temp = temp->next;
        }
    }
}
int main() {
    struct Node* head = NULL;
    int n;

    printf("Enter the number of nodes: ");
    scanf("%d", &n);

    createList(&head, n);

    printf("Original list: ");
    struct Node* temp = head;
    while (temp != NULL) {
        printf("%d ", temp->data);
        temp = temp->next;
    }
    printf("\n");

    head = reverseList(head);

    printf("Reversed list: ");
    temp = head;
    while (temp != NULL) {
        printf("%d ", temp->data);
        temp = temp->next;
    }
    printf("\n");

    return 0;
}