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

// Remove Nth node from end
struct Node* removeNthFromEnd(struct Node* head, int n) {

    struct Node dummy;
    dummy.data = 0;
    dummy.next = head;

    struct Node* fast = &dummy;
    struct Node* slow = &dummy;

    // Move fast pointer n+1 steps
    for (int i = 0; i <= n; i++) {
        if (fast != NULL)
            fast = fast->next;
    }

    // Move both pointers
    while (fast != NULL) {
        fast = fast->next;
        slow = slow->next;
    }

    // Delete node
    struct Node* temp = slow->next;
    slow->next = temp->next;
    free(temp);

    return dummy.next;
}

// Print list
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

    int n = 2;

    printf("Original List:\n");
    printList(head);

    head = removeNthFromEnd(head, n);

    printf("After Removing %dth Node from End:\n", n);
    printList(head);

    return 0;
}