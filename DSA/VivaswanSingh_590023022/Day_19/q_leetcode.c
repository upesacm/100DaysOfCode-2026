struct ListNode* deleteDuplicates(struct ListNode* head)
{
    struct ListNode *current = head;

    while (current != NULL && current->next != NULL)
    {
        if (current->val == current->next->val)
        {
            struct ListNode *duplicate = current->next;
            current->next = duplicate->next;
            free(duplicate);
        }
        else
        {
            current = current->next;
        }
    }

    return head;
}