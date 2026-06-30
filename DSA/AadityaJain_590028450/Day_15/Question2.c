/*Reverse a Singly Linked List
Explanation
Reverse a singly linked list without creating a new list.*/

#include<stdio.h>
#include<stdlib.h>

struct Node{
    int data;
    struct Node *next;
};

struct Node *head = NULL;

void insertEnd(int value){
    struct Node *ptr = (struct Node *)malloc(sizeof(struct Node));
    ptr->data = value;
    ptr->next = NULL;

    if(head == NULL){
        head = ptr;
        return;
    }

    struct Node *temp = head;
    while(temp->next != NULL){
        temp = temp->next;
    }

    temp->next = ptr;
}


void reverse(){
    struct Node *prev = NULL;
    struct Node *temp = head;
    struct Node *next;

    while(temp != NULL){
        next = temp->next;
        temp->next = prev;
        prev = temp;
        temp = next;
    }

    head = prev;
}

void display(){

    struct Node *temp = head;

    while(temp != NULL){
        printf("%d", temp->data);
        temp = temp->next;
        if(temp != NULL){
            printf("->");
        }
    }

}

int main(){
    int i, n, value;

    printf("Enter number of nodes: ");
    scanf("%d", &n);

    printf("Enter node values: ");
    for(i = 0; i < n; i++){
        scanf("%d", &value);
        insertEnd(value);
    }

    printf("Original List: ");
    display();

    reverse();

    printf("\nReversed List: ");
    display();

    return 0;
}