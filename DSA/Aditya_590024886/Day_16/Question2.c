#include <stdio.h>
#include <stdlib.h>

struct node {
  int data;
  struct node* next;
  struct node* prev;
};

struct node* createNode(int value){
  struct node*n=malloc(sizeof(struct node));
  n->data=value;
  n->next=NULL;
  n->prev=NULL;
  return n;
}

struct node* InsertEnd(struct node* head, int value){
    struct node* newNode = createNode(value);

    if(head == NULL){  
        return newNode;
    }

    struct node* temp = head;
    while(temp->next != NULL){
        temp = temp->next;
    }

    temp->next = newNode;
    newNode->prev = temp;

    return head;
}

struct node* removeEnd(struct node* head){
  if(head==NULL) return NULL;
  if (head->next==NULL){
    free(head);
    return NULL;
  }

  struct node* temp=head;
  while(temp->next->next!=NULL){
    temp=temp->next;
  }
  free(temp->next);
  temp->next=NULL;
  return head;
}

void printList(struct node* head){
    struct node* temp = head;
   
    while (temp != NULL) {
        printf("%d ", temp->data);
        temp = temp->next;
    }
    printf("\n");
}

int main(){

  struct node* head=NULL;
  int value;
  char choice;

  do{
    printf("Enter value: ");
    scanf("%d",&value);
    head=InsertEnd(head,value);
    printf("Add another node? (Y/N): ");
    scanf(" %c",&choice);

  }while(choice=='Y');

  head=removeEnd(head);
  printList(head);

  return 0;
}
