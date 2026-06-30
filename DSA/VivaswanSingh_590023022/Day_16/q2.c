struct Node* deleteLastNode(struct Node* head)
{
    if (head == NULL)
        return NULL;

    if (head->next == NULL)
    {
        free(head);
        return NULL;
    }

    struct Node *current = head;

    while (current->next != NULL)
    {
        current = current->next;
    }

    current->prev->next = NULL;
    free(current);

    return head;
}