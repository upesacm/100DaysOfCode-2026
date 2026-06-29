struct ListNode* reverseList(struct ListNode* head)
{
    struct ListNode *prev=NULL;
    struct ListNode *curr=head;
    struct ListNode *next=NULL;
    while(curr!=NULL)
    {
        next = curr->next;
        curr->next=prev;
        prev=curr;
        curr=next;
    }
    return prev;
}
