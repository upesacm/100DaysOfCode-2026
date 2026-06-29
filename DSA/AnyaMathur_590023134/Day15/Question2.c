/* Problem 2 
Reverse a Singly Linked List*/

#include <stdio.h>
#include <stdlib.h>

struct Node{
    int data;
    struct Node *next;
};

struct Node* reversed(struct Node *head){
    struct Node *prev = NULL;
    struct Node *temp = head;
    struct Node *next;

    while (temp != NULL){
        next = temp->next;
        temp->next = prev;
        prev = temp;
        temp = next;
    }
    return prev;
}

void display(struct Node *head){
    while (head != NULL){
        printf("%d", head->data);

        if (head->next != NULL){
            printf(" -> ");
        }
        head = head->next;
    }
}

int main(){
    int n;
    printf("Enter number of nodes: ");
    scanf("%d", &n);

    struct Node *head = NULL;
    struct Node *temp = NULL;
    struct Node *newnode;

    printf("Enter node values: ");

    for (int i = 0; i < n; i++){
        newnode = (struct Node *)malloc(sizeof(struct Node));

        scanf("%d", &newnode->data);
        newnode->next = NULL;

        if (head == NULL){
            head = newnode;
            temp = newnode;
        }
        else{
            temp->next = newnode;
            temp = newnode;
        }
    }
    head = reversed(head);

    printf("Reversed linked list: ");
    display(head);
    return 0;
}