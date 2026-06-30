#include <stdio.h>
#include <stdlib.h>

// Base node structure
struct Node {
    int val;
    struct Node* next;
    struct Node* prev;
};

// Function to create a new node
struct Node* create_node(int val) {
    struct Node* new_node = (struct Node*)malloc(sizeof(struct Node));
    new_node->val = val;
    new_node->next = NULL;
    new_node->prev = NULL;
    return new_node;
}

// Function to delete the last node
struct Node* del_last(struct Node* head) {

    if (!head || !head->next) return NULL;
    struct Node* temp = head;
    
    // Traverse to the last node
    while (temp->next != NULL) {
        temp = temp->next;
    }

    // disconnect the last node
    temp->prev->next = NULL;
    free(temp);

    return head; 
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
    new_node->prev = temp;
    
    // Return the head
    return head;
}

// Function to print Linked list
void print_list(struct Node* head) {
    if (head == NULL) {
        printf("NULL\n");
        return;
    }
    while (head->next != NULL) {
        printf("%d <-> ", head->val);
        head = head->next;
    }
    printf("%d\n", head->val);
}

int main() {
    int n;
    printf("Enter the number of Nodes in the Linked List: ");
    scanf("%d", &n);

    struct Node* head = NULL;
    int val;

    // Creating the linked list
    if (n>0) {
        printf("Enter %d integers: ", n);
        for (int i = 0; i<n; i++){
            scanf("%d", &val);
            head = add_node(head, val);
        }
    }

    // print original linked list and updated linked list
    printf("Original Linked List:\n");
    print_list(head);

    head = del_last(head);

    printf("Linked List after deletion of last node:\n");
    print_list(head);
}