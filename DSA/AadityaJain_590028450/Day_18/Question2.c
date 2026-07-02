/*Remove Nth Node From End of Linked List
Explanation
Remove the nth node from the end of a singly linked list and print the updated linked list.*/

#include<stdio.h>
#include<stdlib.h>

struct node{
    int data;
    struct node *next;
};

struct node *head = NULL;

void insert(int data){
    struct node *ptr = (struct node *)malloc(sizeof(struct node));
    ptr->data = data;
    ptr->next = NULL;

    if(head == NULL){
        head = ptr;
        return;
    }

    struct node *temp = head;
    while(temp->next != NULL){
        temp = temp->next;
    }

    temp->next = ptr;
}

void display(){
    
    struct node *temp = head;

    while(temp != NULL){
        printf("%d ", temp->data);
        temp = temp->next;
    }
    printf("\n");
}

void removeEnd(int n){

    struct node *ptr1 = head;
    struct node *ptr2 = head;

     for(int i = 0; i < n; i++){
        if(ptr1 == NULL){
            printf("Invalid\n");
            return;
        }
        ptr1 = ptr1->next;
    }

    if(ptr1 == NULL){
        struct node *temp1 = head;
        head = head->next;
        free(temp1);
        return;
    }

    while(ptr1->next != NULL){
        ptr1 = ptr1->next;
        ptr2 = ptr2->next;
    }

    struct node *temp2 = ptr2->next;
    ptr2->next = temp2->next;
    free(temp2);
}

int main(){
    int i, n, value, key;

    printf("Enter number of nodes: ");
    scanf("%d", &n);

    printf("Enter %d elements:\n", n);
    for(i = 0; i < n; i++){
        scanf("%d", &value);
        insert(value);
    }

    printf("Enter position of node to remove from end: ");
    scanf("%d", &key);

    removeEnd(key);

    printf("Updated Linked List: ");
    display();

    return 0;
}