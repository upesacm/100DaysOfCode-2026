//Reverse a singly linked list without creating a new list.
//Input:1 -> 2 -> 3 -> 4 -> 5. Output:5 -> 4 -> 3 -> 2 -> 1

#include <stdio.h>
#include <stdlib.h>
struct Node {
    int data;
    struct Node *next;
};

struct Node* createNode(int data) {
    struct Node *newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->next = NULL;
    return newNode;
}

struct Node* reverseList(struct Node *head) {
    struct Node *prev = NULL;
    struct Node *curr = head;
    struct Node *next = NULL;

    while (curr != NULL) {
        next = curr->next;   
        curr->next = prev;   
        prev = curr;         
        curr = next;         
    }

    return prev; 
}

void display(struct Node *head) {
    struct Node *temp = head;

    while (temp != NULL) {
        printf("%d", temp->data);
        if (temp->next != NULL)
            printf(" -> ");
        temp = temp->next;
    }
    printf("\n");
}

int main() {
    int n, value;
    struct Node *head = NULL, *tail = NULL;
    printf("Enter the number of nodes: ");
    scanf("%d", &n);
    printf("Enter the node values:\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", &value);
        struct Node *newNode = createNode(value);
        if (head == NULL) {
            head = newNode;
            tail = newNode;
        } else {
            tail->next = newNode;
            tail = newNode;
        }
    }

    printf("\nOriginal Linked List:\n");
    display(head);
    head = reverseList(head);
    printf("Reversed Linked List:\n");
    display(head);

    return 0;
}