// Problem 2
// The Mountain Expedition 

#include <stdio.h>
#include <stdlib.h>

struct Node {
    int data;
    struct Node *left;
    struct Node *right;
};

struct Node* createNode(int value) {
    struct Node* newNode = (struct Node*)malloc(sizeof(struct Node));
    newNode->data = value;
    newNode->left = NULL;
    newNode->right = NULL;
    return newNode;
}

struct Node* buildTree(int tree[], int n) {
    if (n == 0 || tree[0] == -1)
        return NULL;
    struct Node* nodes[n];
    for (int i = 0; i < n; i++) {
        if (tree[i] == -1)
            nodes[i] = NULL;
        else
            nodes[i] = createNode(tree[i]);
    }
    int j = 1;
    for (int i = 0; i < n && j < n; i++) {
        if (nodes[i] != NULL) {
            if (j < n) {
                nodes[i]->left = nodes[j];
                j++;
            }
            if (j < n) {
                nodes[i]->right = nodes[j];
                j++;
            }
        }
    }
    return nodes[0];
}

int countSafe(struct Node* root, int maxAltitude) {
    if (root == NULL)
        return 0;
    int count = 0;
    if (root->data >= maxAltitude)
        count = 1;
    if (root->data > maxAltitude)
        maxAltitude = root->data;
    count += countSafe(root->left, maxAltitude);
    count += countSafe(root->right, maxAltitude);
    return count;
}

int main() {
    int n;
    printf("Enter number of nodes: ");
    scanf("%d", &n);
    int tree[n];
    printf("Enter the level-order array (-1 for NULL):\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", &tree[i]);
    }
    struct Node* root = buildTree(tree, n);
    if (root == NULL) {
        printf("Number of safe campsites: 0\n");
    } else {
        int result = countSafe(root, root->data);
        printf("Number of safe campsites: %d\n", result);
    }
    return 0;
}