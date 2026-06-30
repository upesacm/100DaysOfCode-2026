/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     struct ListNode *next;
 * };
 */
struct ListNode* swapPairs(struct ListNode* head) {
    if(head==NULL || head->next==NULL) return head;
    struct ListNode* new=head->next;
    struct ListNode* prev=NULL;
    struct ListNode* first=head;
    struct ListNode* second=head->next;
    while(first && second){
        struct ListNode* third=second->next;
        second->next=first;
        first->next=third;
        if (prev!=NULL) prev->next=second;
        prev=first;
        first=third;
        if (first!=NULL) second=first->next;
        else second=NULL;
    }

    return new;
}
