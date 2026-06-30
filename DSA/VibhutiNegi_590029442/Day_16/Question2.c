#include <stdio.h>
#include <stdlib.h>
struct Node
{
    int data;
    struct Node *prev;
    struct Node *next;
};
struct Node* createNode(int data)
{
    struct Node *newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = data;
    newNode->prev = NULL;
    newNode->next = NULL;
    return newNode;
}
struct Node* deleteLastNode(struct Node *head)
{
    if (head == NULL)
        return NULL;
    if (head->next == NULL)
    {
        free(head);
        return NULL;
    }
    struct Node *temp = head;
    while (temp->next != NULL)
        temp = temp->next;
    temp->prev->next = NULL;
    free(temp);
    return head;
}
void printList(struct Node *head)
{
    if (head == NULL)
    {
        printf("NULL");
        return;
    }
    while (head != NULL)
    {
        printf("%d ", head->data);
        head = head->next;
    }
}
int main()
{
    int n, x;
    scanf("%d", &n);
    struct Node *head = NULL;
    struct Node *tail = NULL;
    for (int i = 0; i < n; i++)
    {
        scanf("%d", &x);
        struct Node *newNode = createNode(x);
        if (head == NULL)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            tail->next = newNode;
            newNode->prev = tail;
            tail = newNode;
        }
    }
    head = deleteLastNode(head);
    printList(head);
    return 0;
}