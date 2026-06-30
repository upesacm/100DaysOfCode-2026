#include <stdio.h>
#include <stdlib.h>
struct node{
    int val;
    struct node *prev;
    struct node *next;
};
struct node *newNode(int val){
    struct node *temp = (struct node *)malloc(sizeof(struct node));
    temp->val = val;
    temp->prev = NULL;
    temp->next = NULL;
    return temp;
}
struct node *createList(int n){
    struct node *head = NULL;
    struct node *tail = NULL;
    int value;
    printf("Enter %d elements:\n", n);
    for (int i = 0; i < n; i++){
        scanf("%d", &value);
        struct node *temp = newNode(value);
        if (head == NULL){
            head = temp;
            tail = temp;
        } else{
            tail->next = temp;
            temp->prev = tail;
            tail = temp;
        }
    } return head;
}
void display(struct node *head){
    printf("NULL <- ");
    while (head != NULL){
        printf("%d", head->val);
        if (head->next != NULL)
            printf(" <-> ");
        head = head->next;
    }
    printf(" -> NULL");
}
struct node *deletetail(struct node* head){
    if(head == NULL){
        return NULL;
    }
    if(head -> next == NULL){
        free(head);
        return NULL;
    } 
    struct node* temp = head;
    while(temp->next != NULL){
        temp = temp->next;
    }
    temp->prev->next = NULL;
    free(temp);
    return head;
}

int main(){
    int n;
    printf("Enter number of nodes: ");
    scanf("%d", &n);
    struct node *head = createList(n);
    printf("Doubly Linked List: ");
    display(head);
    head = deletetail(head);
    display(head);
    return 0;
}