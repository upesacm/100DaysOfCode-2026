#include <stdio.h>
#include <stdlib.h>

// Base node structure
struct Node {
    int val;
    struct Node* next;
};

// Function to create a new node
struct Node* create_node(int val) {
    struct Node* new_node = (struct Node*)malloc(sizeof(struct Node));
    new_node->val = val;
    new_node->next = NULL;
    return new_node;
}

// Function to reverse a linked list
struct Node* rev_list(struct Node* head) {
    // Three pointers to store the previous, current and next node
    struct Node* head0 = NULL;
    struct Node* head1 = head;
    struct Node* head2 = NULL;

    //Reversing the list
    while (head1 != NULL) {
        head2 = head1->next;
        head1->next = head0;
        head0 = head1;
        head1 = head2;
    }
    return head0;
}

// Function to add a new node to the list
struct Node* add_node(struct Node* head, int val) {
    struct Node* new_node = create_node(val);
    
    // For empty list, return the new_node
    if (head == NULL) {
        return new_node;
    }
    
    // Travel to the last node of the list
    struct Node* temp = head;
    while (temp->next != NULL) {
        temp = temp->next;
    }
    
    // Append the new node to the end of the list
    temp->next = new_node;
    
    // Return the head
    return head;
}

void print_list(struct Node* head) {
    if (head == NULL) {
        printf("Empty Linked List\n");
        return;
    }
    while (head != NULL) {
        printf("%d -> ", head->val);
        head = head->next;
    }
    printf("NULL\n");
}

int main() {
    int n;
    printf("Enter the number of Nodes in the Linked List: ");
    scanf("%d", &n);

    struct Node* head = NULL;
    int val;
    if (n>0) {
        printf("Enter %d integers: ", n);
        for (int i = 0; i<n; i++){
            scanf("%d", &val);
            head = add_node(head, val);
        }
    }
    printf("Original Linked List:\n");
    print_list(head);

    head = rev_list(head);

    printf("Reversed Linked List:\n");
    print_list(head);
}