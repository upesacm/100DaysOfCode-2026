/*Delete Last Node of a Doubly Linked List.
Explanation
Delete the last node from a doubly linked list, print the updated list, or return NULL if the list becomes empty.*/

#include<stdio.h>
#include<stdlib.h>

struct node{
    int data;
    struct node *prev;
    struct node *next;
};

struct node *head = NULL;

void insertEnd(int value){
    struct node *ptr= (struct node *)malloc(sizeof(struct node));
    ptr->data = value;
    ptr->next = NULL;
    ptr->prev = NULL;

    if(head == NULL){
        head = ptr;
        return;
    }

    struct node *temp = head;
    while(temp->next != NULL){
        temp = temp->next;
    }

    temp->next = ptr;
    ptr->prev = temp;
}

void deleteEnd(){

    if(head == NULL){
        printf("NULL\n");
        return;
    }

    if(head->next == NULL){
        free(head);
        head = NULL;
        return;
    }

    struct node *temp = head;
    while(temp->next != NULL){
        temp = temp->next;
    }

    temp->prev->next = NULL;
    free(temp);
}

void display(){
    struct node *temp = head;

    if(head == NULL){
        printf("NULL\n");
        return;
    }

    while(temp != NULL){
        printf("%d", temp->data);
        if(temp->next != NULL){
            printf(" <-> ");
        }
        temp = temp->next;
    }
    printf("\n");
}

int main(){
    int n, value, i;

    printf("Enter number of nodes: ");
    scanf("%d", &n);

    printf("Enter node values: ");
    for(i = 1; i <= n; i++){
        scanf("%d", &value);
        insertEnd(value);
    }

    printf("Original List: ");
    display();

    deleteEnd();

    printf("After deletion: ");
    display();

    return 0;
}

