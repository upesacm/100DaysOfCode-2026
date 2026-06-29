#include <stdio.h>
#include <stdlib.h>
struct ListNode {
    int val;
    struct ListNode *next;
};
struct ListNode* createNode(int data) {
    struct ListNode *newNode = (struct ListNode *)malloc(sizeof(struct ListNode));
    newNode->val = data;
    newNode->next = NULL;
    return newNode;
}
struct ListNode* reverseList(struct ListNode* head) {
    struct ListNode *prev = NULL;
    struct ListNode *curr = head;
    struct ListNode *next;
    while (curr != NULL) {
        next = curr->next;
        curr->next = prev;
        prev = curr;
        curr = next;
    }
    return prev;
}
void printList(struct ListNode *head) {
    while (head != NULL) {
        printf("%d ", head->val);
        head = head->next;
    }
}
int main() {
    int n, x;
    scanf("%d", &n);
    struct ListNode *head = NULL;
    struct ListNode *tail = NULL;
    for (int i = 0; i < n; i++) {
        scanf("%d", &x);
        struct ListNode *newNode = createNode(x);
        if (head == NULL) {
            head = newNode;
            tail = newNode;
        } else {
            tail->next = newNode;
            tail = newNode;
        }
    }
    head = reverseList(head);
    printList(head);
    return 0;
}