//Need to reverse the linked list without making a new one

#include <iostream>
using namespace std;

struct Node
{
    int data;
    Node* next;

    Node(int val)
    {
        data = val;
        next = NULL;
    }
};

Node* reverse(Node* head)
{
    Node* prev = NULL;
    Node* curr = head;
    Node* next = NULL;

    while (curr != NULL)
    {
        // save next node before changing the link
        next = curr->next;

        curr->next = prev;

        prev = curr;
        curr = next;
    }

    return prev;
}

void print(Node* head)
{
    while (head != NULL)
    {
        cout << head->data << " ";
        head = head->next;
    }
}

int main()
{
    Node* head = new Node(1);
    head->next = new Node(2);
    head->next->next = new Node(3);
    head->next->next->next = new Node(4);
    head->next->next->next->next = new Node(5);

    head = reverse(head);

    print(head);

    return 0;
}