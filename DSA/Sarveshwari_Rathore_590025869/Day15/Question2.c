#include <stdio.h>
#include <stdlib.h>
struct node {
    int  val;
    struct node *next;
};
struct node* newNode(int val) {
    struct node *temp = (struct node*)malloc(sizeof(struct node));
    temp->val = val;
    temp->next = NULL;
    return temp;
}
struct node* createList(int n) {
    struct node *head = NULL;
    struct node *tail = NULL;
    int value;
    printf("Enter %d elements:\n", n);
    for (int i = 0; i < n; i++) {
        scanf("%d", &value);
        struct node *temp = newNode(value);
        if (head == NULL) {
            head = temp;
            tail = temp;
        } else {
            tail->next = temp;
            tail = temp;
        }
    } return head;
}
void display(struct node *head) {
    while (head != NULL) {
        printf("%d -> ", head->val);
        head = head->next;
    } printf("NULL\n");
}
struct node *reverse(struct node *head){
    struct node *prev = NULL;
    struct node *curr = head;
    struct node *Next;
    while(curr != NULL){
        Next = curr -> next;
        curr -> next = prev;
        prev = curr; 
        curr = Next; 
    } return prev;
}
int main(){
    int n;
    printf("Enter number of nodes: ");
    scanf("%d", &n);
    struct node *head = createList(n);
    printf("\nOriginal List:\n");
    display(head);
    head = reverse(head);
    printf("\nReversed List:\n");
    display(head);
    return 0;
}