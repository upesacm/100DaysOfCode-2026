struct ListNode* mergeTwoLists(struct ListNode* list1, struct ListNode* list2)
{
    struct ListNode dummy;
    struct ListNode *temp=&dummy;
    dummy.next=NULL;

    while(list1!=NULL&&list2!=NULL)
    {
        if(list1->val<=list2->val)
        {
        temp->next=list1;
        list1=list1->next;
        }
        else
        {
            temp->next=list2;
            list2=list2->next;
        }

        temp=temp->next;
        }
        if(list1!=NULL)
        {
            temp->next=list1;
        }
        else
        {
            temp->next=list2;
        }
    return dummy.next;
}
