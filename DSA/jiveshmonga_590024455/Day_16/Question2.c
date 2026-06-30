#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *prev;
    struct Node *next;
};
struct Node* deleteLast(struct Node* head)
{
    if (head==NULL)
    {
        return NULL;
    }
  if (head->next==NULL)
    {
        free(head);
        return NULL;
    }
    struct Node *temp = head;
    while (temp->next != NULL)
    {
        temp=temp->next;
    }
    temp->prev->next=NULL;
    free(temp);

    return head;
}
void printList(struct Node* head)
{
    while (head!=NULL)
    {
        printf("%d",head->data);
        if (head->next!=NULL)
            printf(" <-> ");
        head=head->next;
    }
}
