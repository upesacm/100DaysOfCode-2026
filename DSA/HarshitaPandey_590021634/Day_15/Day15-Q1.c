/* Reverse a singly linked list without creating a new list.

Example
Input:1 -> 2 -> 3 -> 4 -> 5;  Output:5 -> 4 -> 3 -> 2 -> 1   */


#include <stdio.h>
#include <stdlib.h>


struct node
{
    int data;
    struct node *next;
};




struct node *reverse (struct node* head)
{
    if (head == NULL || head->next == NULL)
    {
        return head;
    }

    struct node *prev = NULL;
    struct node *current = head;
    struct node *next_node = NULL;

    while (current !=NULL)
    {
        next_node = current->next;
        current->next=prev; 

        prev = current;
        current = next_node;
    }
    return prev;
}




int main()
{
    int n;
    struct node *head = NULL;
    struct node *temp = NULL;

    printf("Enter the number of nodes: ");
    scanf("%d", &n);

    for (int i = 0; i < n; i++)
    {
        struct node *new_node = (struct node *)malloc (sizeof(struct node));
        printf("Enter data for node %d: ", i + 1);
        scanf("%d", &new_node->data);

        new_node->next = NULL;

        if (head == NULL)
        {
            head = new_node;
        }

        else
        {
            temp = head;

            while (temp->next != NULL)
            {
                temp = temp->next;
            }
            temp->next = new_node;
        }
    }

    printf("Original linked list: ");
    temp = head;

    while (temp != NULL)
    {
        printf("%d -> ", temp->data);
        temp = temp->next;
    }

    head = reverse(head);

    printf("\nReversed linked list: ");

    temp = head;

    while (temp != NULL)
    {
        printf("%d -> ", temp->data);
        temp = temp->next;
    }

}