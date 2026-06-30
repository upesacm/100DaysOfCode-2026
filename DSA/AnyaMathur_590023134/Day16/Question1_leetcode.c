/* leetcode probelm 24
   Swap Nodes In Pairs*/ 

   /**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* swapPairs(struct ListNode* head) {
    if (head == NULL || head->next == NULL){
        return head;
    }
    struct ListNode* newhead = (struct ListNode*)malloc(sizeof(struct ListNode));
    newhead->next = head;
    struct ListNode* temp = newhead;
    while (temp->next != NULL && temp->next->next != NULL){
        struct ListNode* first = temp->next;
        struct ListNode* second = first->next;
        first->next = second->next;
        second->next = first;
        temp->next = second;
        temp = first;
    }
    head = newhead->next;
    free(newhead);
    return head;
}