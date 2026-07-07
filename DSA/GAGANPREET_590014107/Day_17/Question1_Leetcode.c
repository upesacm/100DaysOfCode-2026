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

// Reverse a linked list
struct Node* reverse(struct Node* head) {
    struct Node *prev = NULL, *curr = head, *next = NULL;

    while (curr != NULL) {
        next = curr->next;
        curr->next = prev;
        prev = curr;
        curr = next;
    }

    return prev;
}

// Check if palindrome
int isPalindrome(struct Node* head) {

    if (head == NULL || head->next == NULL)
        return 1;

    struct Node *slow = head, *fast = head;

    // Find middle
    while (fast != NULL && fast->next != NULL) {
        slow = slow->next;
        fast = fast->next->next;
    }

    // Reverse second half
    struct Node* second = reverse(slow);
    struct Node* first = head;

    // Compare both halves
    while (second != NULL) {
        if (first->data != second->data)
            return 0;

        first = first->next;
        second = second->next;
    }

    return 1;
}

// Print list
void printList(struct Node* head) {
    while (head != NULL) {
        printf("%d ", head->data);
        head = head->next;
    }
    printf("\n");
}

int main() {

    struct Node* head = NULL;

    // Example: 1 -> 2 -> 2 -> 1
    insertEnd(&head, 1);
    insertEnd(&head, 2);
    insertEnd(&head, 2);
    insertEnd(&head, 1);

    printf("Linked List: ");
    printList(head);

    if (isPalindrome(head))
        printf("Palindrome\n");
    else
        printf("Not Palindrome\n");

    return 0;
}