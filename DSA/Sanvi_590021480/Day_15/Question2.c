#include <stdio.h>
#include <stdlib.h>

struct node {
  int data;
  struct node* next;
};

struct node* createNode(int value){
  struct node*n=malloc(sizeof(struct node));
  n->data=value;
  n->next=NULL;
  return n;
}

void printList(struct node* head){
  while(head!=NULL){
    printf("%d ",head->data);
    head=head->next;
  }
}

struct node* reverseList(struct node* head){
  struct node* prev=NULL;
  struct node* current=head;
  struct node* next=NULL;
  while(current!=NULL){
    next=current->next;
    current->next=prev;
    prev=current;
    current=next;
  }
  return prev;
}

int main(){
  struct node* head=NULL;
  struct node* tail=NULL;
  int value;

  char choice='Y';
  do{
    printf("Enter the data: ");
    scanf("%d",&value);
    struct node* newNode=createNode(value);

    if(head==NULL){
      head=newNode;
      tail=newNode;
    }
    else{
      tail->next=newNode;
      tail=newNode;
    }
    printf("Add another node?");
    scanf(" %c",&choice);
    if(choice!='Y' && choice!='N'){
      printf("Invalid choice");
      choice='Y';
    }
  }
  while(choice=='Y');

  head=reverseList(head);
  printf("Reverse: ");
  printList(head);
  
  return 0;
}
