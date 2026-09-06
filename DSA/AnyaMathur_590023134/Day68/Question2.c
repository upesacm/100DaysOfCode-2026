// Problem 2
// The Franchise Audit

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
    if (arr[0] == -1)
        return NULL;
    Node *root = createNode(arr[0]);
    Node *queue[n];
    int front = 0, rear = 0, i = 1;
    queue[rear++] = root;

    while (front < rear && i < n) {
        Node *temp = queue[front++];
        if (i < n && arr[i] != -1) {
            temp->left = createNode(arr[i]);
            queue[rear++] = temp->left;
        }
        i++;
        if (i < n && arr[i] != -1) {
            temp->right = createNode(arr[i]);
            queue[rear++] = temp->right;
        }
        i++;
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

int countNodes(Node *root) {
    if (root == NULL)
        return 0;
    return 1 + countNodes(root->left) + countNodes(root->right);
}

int isBST(Node *root) {
    if (root == NULL)
        return 1;
    int n = countNodes(root);
    int arr[n];
    int index = 0;
    inorder(root, arr, &index);
    for (int i = 1; i < n; i++) {
        if (arr[i] <= arr[i - 1])
            return 0;
    }
    return 1;
}

int largestBST(Node *root) {
    if (root == NULL)
        return 0;
    if (isBST(root))
        return countNodes(root);
    int left = largestBST(root->left);
    int right = largestBST(root->right);
    return left > right ? left : right;
}

int main() {
    int n;
    printf("Enter number of nodes: ");
    scanf("%d", &n);
    int tree[n];
    printf("Enter tree in level order: ");
    for (int i = 0; i < n; i++)
        scanf("%d", &tree[i]);
    Node *root = buildTree(tree, n);
    printf("Size of largest BST subtree: %d\n", largestBST(root));
    return 0;
}