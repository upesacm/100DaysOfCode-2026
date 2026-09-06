// Problem 2
// The Heist

#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *left;
    struct Node *right;
};

struct Node* createNode(int value) {
    struct Node* newNode = malloc(sizeof(struct Node));
    newNode->data = value;
    newNode->left = NULL;
    newNode->right = NULL;
    return newNode;
}

struct Node* buildTree(int tree[], int n, int index) {
    if (index >= n || tree[index] == -1)
        return NULL;
    struct Node* root = createNode(tree[index]);
    root->left = buildTree(tree, n, 2 * index + 1);
    root->right = buildTree(tree, n, 2 * index + 2);
    return root;
}

int max(int a, int b) {
    if (a > b)
        return a;
    return b;
}

int rob(struct Node* root) {
    if (root == NULL)
        return 0;
    int robRoot = root->data;
    if (root->left != NULL)
        robRoot += rob(root->left->left) + rob(root->left->right);
    if (root->right != NULL)
        robRoot += rob(root->right->left) + rob(root->right->right);
    int skipRoot = rob(root->left) + rob(root->right);
    return max(robRoot, skipRoot);
}

int main() {
    int n;
    printf("Enter number of houses: ");
    scanf("%d", &n);
    int tree[n];
    printf("Enter the tree array (-1 for no house):\n");
    for (int i = 0; i < n; i++)
        scanf("%d", &tree[i]);
    struct Node* root = buildTree(tree, n, 0);
    printf("Maximum amount that can be robbed: %d\n", rob(root));
    return 0;
}