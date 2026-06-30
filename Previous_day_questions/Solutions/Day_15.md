<h2 align="center">Week 3 Day 15 (29/06/2026)</h2>

## 1. Merge Two Sorted Lists (LeetCode #21)

### Solution

```c
/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* mergeTwoLists(struct ListNode* list1, struct ListNode* list2) {

    // Pointers for the head of merged list and current node
    struct ListNode *head = NULL, *temp = NULL;

    // If both lists are non-empty
    if (list1 && list2)
    {
        // Select the smaller node as the head
        if (list1->val > list2->val)
        {
            head = list2;
            list2 = list2->next;
        }
        else
        {
            head = list1;
            list1 = list1->next;
        }

        // temp keeps track of the last node in merged list
        temp = head;

        // Merge the remaining nodes in sorted order
        while (list1 != NULL && list2 != NULL)
        {
            if (list1->val > list2->val)
            {
                temp->next = list2;
                temp = temp->next;
                list2 = list2->next;
            }
            else
            {
                temp->next = list1;
                temp = temp->next;
                list1 = list1->next;
            }
        }

        // Attach the remaining nodes of list1 (if any)
        if (list1 != NULL)
        {
            temp->next = list1;
        }

        // Attach the remaining nodes of list2 (if any)
        if (list2 != NULL)
        {
            temp->next = list2;
        }

        // Return the head of the merged list
        return head;
    }
    else
    {
        // If one list is empty, return the other list
        if (list1 != NULL)
            return list1;
        else if (list2 != NULL)
            return list2;
        else
            return NULL;   // Both lists are empty
    }
}
```

---

## 2. Reverse a Singly Linked List

### Solution

```c
#include <stdio.h>
#include <stdlib.h>

// Structure of a linked list node
struct Node {
    int data;
    struct Node *next;
};

// Function to reverse the linked list
struct Node* reverseList(struct Node *head) {
    struct Node *prev = NULL;
    struct Node *curr = head;
    struct Node *next = NULL;

    // Reverse the links
    while (curr != NULL) {
        // Store the next node
        next = curr->next;
        // Reverse the current node's link
        curr->next = prev;
        // Move all pointers one step forward
        prev = curr;
        curr = next;
    }

    // prev becomes the new head
    return prev;
}

// Function to print the linked list
void printList(struct Node *head) {
    while (head != NULL) {
        printf("%d ", head->data);
        head = head->next;
    }
}

// Driver code
int main() {
    // Creating the linked list: 1 -> 2 -> 3 -> 4 -> 5
    struct Node *head = (struct Node*)malloc(sizeof(struct Node));
    head->data = 1;
    head->next = (struct Node*)malloc(sizeof(struct Node));
    head->next->data = 2;
    head->next->next = (struct Node*)malloc(sizeof(struct Node));
    head->next->next->data = 3;
    head->next->next->next = (struct Node*)malloc(sizeof(struct Node));
    head->next->next->next->data = 4;
    head->next->next->next->next = (struct Node*)malloc(sizeof(struct Node));
    head->next->next->next->next->data = 5;
    head->next->next->next->next->next = NULL;

    printf("Original List: ");
    printList(head);

    // Reverse the linked list
    head = reverseList(head);

    printf("\nReversed List: ");
    printList(head);

    return 0;
}
```
