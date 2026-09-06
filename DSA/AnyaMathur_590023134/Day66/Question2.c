// Problem 2
// The Corporate Merger

#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    int data;
    struct Node *left;
    struct Node *right;
} Node;

Node* createNode(int data) {
    Node *newNode = malloc(sizeof(Node));
    newNode->data = data;
    newNode->left = NULL;
    newNode->right = NULL;
    return newNode;
}

Node* buildTree(int arr[], int n) {
    if (n == 0 || arr[0] == -1)
        return NULL;
    Node *root = createNode(arr[0]);
    Node *queue[n];
    int front = 0, rear = 0, i = 1;
    queue[rear++] = root;
    while (front < rear && i < n) {
        Node *temp = queue[front++];
        if (i < n) {
            if (arr[i] != -1) {
                temp->left = createNode(arr[i]);
                queue[rear++] = temp->left;
            }
            i++;
        }
        if (i < n) {
            if (arr[i] != -1) {
                temp->right = createNode(arr[i]);
                queue[rear++] = temp->right;
            }
            i++;
        }
    }
    return root;
}
void inorder(Node *root, int arr[], int *index) {
    if (root == NULL)
        return;
    inorder(root->left, arr, index);
    arr[(*index)++] = root->data;
    inorder(root->right, arr, index);
}

int main() {
    int n1, n2;
    printf("Enter number of nodes in Tree 1: ");
    scanf("%d", &n1);
    int tree1[n1];
    printf("Enter Tree 1 in level order: ");
    for (int i = 0; i < n1; i++)
        scanf("%d", &tree1[i]);
    printf("Enter number of nodes in Tree 2: ");
    scanf("%d", &n2);
    int tree2[n2];
    printf("Enter Tree 2 in level order: ");
    for (int i = 0; i < n2; i++)
        scanf("%d", &tree2[i]);
    Node *root1 = buildTree(tree1, n1);
    Node *root2 = buildTree(tree2, n2);
    int a[n1], b[n2];
    int x = 0, y = 0;
    inorder(root1, a, &x);
    inorder(root2, b, &y);
    int i = 0, j = 0;
    int result[n1 + n2];
    int k = 0;
    while (i < x && j < y) {
        if (a[i] < b[j])
            result[k++] = a[i++];
        else if (a[i] > b[j])
            result[k++] = b[j++];
        else {
            result[k++] = a[i++];
            j++;
        }
    }
    while (i < x)
        result[k++] = a[i++];
    while (j < y)
        result[k++] = b[j++];
    printf("Merged sorted array: [");
    for (i = 0; i < k; i++) {
        printf("%d", result[i]);
        if (i < k - 1)
            printf(", ");
    }
    printf("]");
    return 0;
}