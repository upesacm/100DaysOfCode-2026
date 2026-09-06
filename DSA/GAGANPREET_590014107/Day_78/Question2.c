#include <stdio.h>
#include <stdlib.h>

typedef struct Node {
    struct Node *child[2];
} Node;

Node* createNode() {
    Node *node = (Node*)malloc(sizeof(Node));
    node->child[0] = NULL;
    node->child[1] = NULL;
    return node;
}

void insert(Node *root, int num) {
    Node *curr = root;

    for (int i = 31; i >= 0; i--) {
        int bit = (num >> i) & 1;

        if (curr->child[bit] == NULL)
            curr->child[bit] = createNode();

        curr = curr->child[bit];
    }
}

int findMaxXOR(Node *root, int num) {
    Node *curr = root;
    int result = 0;

    for (int i = 31; i >= 0; i--) {
        int bit = (num >> i) & 1;
        int opposite = 1 - bit;

        // Prefer opposite bit to maximize XOR
        if (curr->child[opposite] != NULL) {
            result |= (1 << i);
            curr = curr->child[opposite];
        } else {
            curr = curr->child[bit];
        }
    }

    return result;
}

int main() {
    int n;
    scanf("%d", &n);

    int *arr = (int*)malloc(n * sizeof(int));

    for (int i = 0; i < n; i++)
        scanf("%d", &arr[i]);

    Node *root = createNode();

    int maxXOR = 0;

    // Insert first element
    insert(root, arr[0]);

    for (int i = 1; i < n; i++) {
        int current = findMaxXOR(root, arr[i]);

        if (current > maxXOR)
            maxXOR = current;

        insert(root, arr[i]);
    }

    printf("%d\n", maxXOR);

    free(arr);

    return 0;
}
