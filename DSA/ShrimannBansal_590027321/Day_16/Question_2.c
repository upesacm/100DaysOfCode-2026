#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *prev;
    struct Node *next;
};

struct Node* createNode(int value) {
    struct Node *node = (struct Node *)malloc(sizeof(struct Node));
    node->data = value;
    node->prev = NULL;
    node->next = NULL;
    return node;
}

void insert(struct Node **head, int value) {
    struct Node *node = createNode(value);

    if (*head == NULL) {
        *head = node;
        return;
    }

    struct Node *temp = *head;
    while (temp->next != NULL)
        temp = temp->next;

    temp->next = node;
    node->prev = temp;
}

struct Node* deleteLast(struct Node *head) {
    if (head == NULL)
        return NULL;

    if (head->next == NULL) {
        free(head);
        return NULL;
    }

    struct Node *temp = head;

    while (temp->next != NULL)
        temp = temp->next;

    temp->prev->next = NULL;
    free(temp);

    return head;
}

void display(struct Node *head) {
    if (head == NULL) {
        printf("NULL\n");
        return;
    }

    while (head != NULL) {
        printf("%d", head->data);
        if (head->next != NULL)
            printf(" <-> ");
        head = head->next;
    }

    printf("\n");
}

int main() {
    struct Node *head = NULL;
    int n, value;

    printf("Enter number of nodes: ");
    scanf("%d", &n);

    printf("Enter the elements: ");
    for (int i = 0; i < n; i++) {
        scanf("%d", &value);
        insert(&head, value);
    }

    head = deleteLast(head);

    printf("Updated Doubly Linked List: ");
    display(head);

    return 0;
}