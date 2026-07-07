#include <stdio.h>
#include <stdlib.h>

struct Node
{
    int heroID;
    struct Node *next;
};

struct Node *head = NULL;

void insert(int id)
{
    struct Node *newNode = (struct Node *)malloc(sizeof(struct Node));
    newNode->heroID = id;
    newNode->next = NULL;

    if (head == NULL)
    {
        head = newNode;
        return;
    }

    struct Node *temp = head;

    while (temp->next != NULL)
        temp = temp->next;

    temp->next = newNode;
}

void removeLoop()
{
    struct Node *slow = head;
    struct Node *fast = head;

    while (fast != NULL && fast->next != NULL)
    {
        slow = slow->next;
        fast = fast->next->next;

        if (slow == fast)
            break;
    }

    if (fast == NULL || fast->next == NULL)
        return;

    slow = head;

    if (slow == fast)
    {
        while (fast->next != slow)
            fast = fast->next;

        fast->next = NULL;
        return;
    }

    while (slow->next != fast->next)
    {
        slow = slow->next;
        fast = fast->next;
    }

    fast->next = NULL;
}

void display()
{
    removeLoop();

    struct Node *temp = head;

    while (temp != NULL)
    {
        printf("%d -> ", temp->heroID);
        temp = temp->next;
    }

    printf("NULL\n");
}

void deleteHero(int id)
{
    struct Node *temp = head;
    struct Node *prev = NULL;

    while (temp != NULL && temp->heroID != id)
    {
        prev = temp;
        temp = temp->next;
    }

    if (temp == NULL)
        return;

    if (prev == NULL)
        head = head->next;
    else
        prev->next = temp->next;

    free(temp);
}

struct Node *findMiddle()
{
    struct Node *slow = head;
    struct Node *fast = head;

    while (fast != NULL && fast->next != NULL)
    {
        slow = slow->next;
        fast = fast->next->next;
    }

    return slow;
}

int main()
{
    insert(1);
    insert(2);
    insert(3);
    insert(4);
    insert(5);

    display();

    deleteHero(3);

    display();

    struct Node *mid = findMiddle();

    if (mid != NULL)
        printf("Backup Leader: %d\n", mid->heroID);

    return 0;
}