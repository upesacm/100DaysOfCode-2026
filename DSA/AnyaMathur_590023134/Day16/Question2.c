/* Problem 2 
Delete Last Node of a Doubly Linked List*/

#include <stdio.h>
#include <stdlib.h>

struct Node{
    int data;
    struct Node* prev;
    struct Node* next;
};

struct Node* head = NULL;
struct Node* tail = NULL;

void create(int value){
    struct Node* newnode = (struct Node*)malloc(sizeof(struct Node));
    newnode->data = value;
    newnode->next = NULL;
    newnode->prev = NULL;
    if (head == NULL){
        head = tail = newnode;
    }
    else{
        tail->next = newnode;
        newnode->prev = tail;
        tail = newnode;
    }
}

void deletetail(){
    if (head == NULL){
        return;
    }
    if (head->next == NULL){
        free(head);
        head = NULL;
        tail = NULL;
        return;
    }
    struct Node* temp = tail;
    tail = tail->prev;
    tail->next = NULL;
    free(temp);
}

void display(){
    struct Node* temp = head;
    if (head == NULL){
        printf("NULL");
        return;
    }
    while (temp != NULL){
        printf("%d -> ", temp->data);
        temp = temp->next;
    }
    printf("NULL");
}

int main(){
    int n, value;
    printf("Enter number of nodes: ");
    scanf("%d", &n);
    printf("Enter elements: ");
    for (int i = 0; i < n; i++){
        scanf("%d", &value);
        create(value);
    }
    deletetail();
    printf("Updated List: ");
    display();
    return 0;
}