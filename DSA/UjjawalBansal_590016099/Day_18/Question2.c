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

// Function to delete a node from nth postion from last
struct Node* del_element(struct Node* head, int k) {
    // A tail pointer to perform operations
    struct Node* tail = head;

    // Counting the total number of nodes in the Linked list
    int count = 1;
    while (tail->next != NULL) {
        tail = tail->next;
        count ++;
    }

    // Position of node to be deleted from start
    k = count - k;

    // When original postion from end(k) == Number of nodes in the Linked List
    if (k==0) {
        struct Node* temp = head;
        head = head->next;
        free(temp);
        return head;
    }

    // traversing to the node before the one that needs to be deleted
    tail = head;
    while(k>1) {
       tail = tail->next;
       k--;
    }

    //Attaching it to the next to next node
    struct Node* temp = tail->next;
    tail->next = temp->next;
    free(temp);

    return head;
}
//Function to print a Linked List
void print_list(struct Node* head) {
    if (head == NULL) {
        printf("NULL\n");
        return;
    }
    while (head->next != NULL) {
        printf("%d -> ", head->val);
        head = head->next;
    }
    printf("%d\n", head->val);
}

int main() {
    int n,k;
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

    printf("Enter the position from end which node has to be deleted: ");
    scanf("%d", &k);

    printf("Original Linked List:\n");
    print_list(head);

    if (k>0 && k<=n && head != NULL) {
        head = del_element(head, k);
        printf("Linked List after deleting nth element from end: \n");
        print_list(head);
    }

    else printf("Invalid Inputs for k");
    return 0;
}