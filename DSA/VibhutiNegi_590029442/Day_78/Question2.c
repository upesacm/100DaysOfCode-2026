#include <stdio.h>
#include <stdlib.h>
#define MAXN 100000
#define MAXBIT 30
typedef struct Node {
    struct Node *child[2];
} Node;
Node* createNode() {
    Node *newNode = (Node*)malloc(sizeof(Node));
    newNode->child[0] = NULL;
    newNode->child[1] = NULL;
    return newNode;
}
void insert(Node *root, int num) {
    Node *current = root;
    for (int i = MAXBIT; i >= 0; i--) {
        int bit = (num >> i) & 1;
        if (current->child[bit] == NULL)
            current->child[bit] = createNode();
        current = current->child[bit];
    }
}
int findMaxXor(Node *root, int num) {
    Node *current = root;
    int answer = 0;
    for (int i = MAXBIT; i >= 0; i--) {
        int bit = (num >> i) & 1;
        int opposite = 1 - bit;
        if (current->child[opposite] != NULL) {
            answer = answer | (1 << i);
            current = current->child[opposite];
        }
        else {
            current = current->child[bit];
        }
    }
    return answer;
}
int main() {
    int n;
    scanf("%d", &n);
    int arr[MAXN];
    for (int i = 0; i < n; i++)
        scanf("%d", &arr[i]);
    Node *root = createNode();
    insert(root, arr[0]);
    int maximum = 0;
    for (int i = 1; i < n; i++) {
        int currentXor = findMaxXor(root, arr[i]);
        if (currentXor > maximum)
            maximum = currentXor;
        insert(root, arr[i]);
    }
    printf("%d\n", maximum);
    return 0;
}