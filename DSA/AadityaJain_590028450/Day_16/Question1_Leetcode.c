/*Swap Nodes in Pairs
Explanation
Swap every pair of adjacent nodes in a linked list and return the updated list.*/

/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* swapPairs(struct ListNode* head) {
    struct ListNode ptr;
    ptr.next = head;

    struct ListNode *prev = &ptr;
    struct ListNode *ptr1;
    struct ListNode *ptr2;

    while(prev->next != NULL && prev->next->next != NULL){
        ptr1 = prev->next;
        ptr2 = ptr1->next;

        ptr1->next = ptr2->next;
        ptr2->next = ptr1;
        prev->next = ptr2;

        prev = ptr1;
    }

    return ptr.next;
}