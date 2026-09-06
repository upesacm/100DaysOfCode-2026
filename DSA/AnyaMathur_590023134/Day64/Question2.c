// Problem 2
// The Conference Room

#include <stdio.h>

int findLCA(int tree[], int n, int a, int b) {
    int i = 0;
    while (i < n && tree[i] != -1) {
        if (a < tree[i] && b < tree[i])
            i = 2 * i + 1;
        else if (a > tree[i] && b > tree[i])
            i = 2 * i + 2;
        else
            return tree[i];
    }
    return -1;
}

int main() {
    int n;
    printf("Enter number of nodes: ");
    scanf("%d", &n);
    int tree[n];
    printf("Enter the level-order array (-1 for NULL):\n");
    for (int i = 0; i < n; i++)
        scanf("%d", &tree[i]);
    int a, b;
    printf("Enter the two room numbers: ");
    scanf("%d %d", &a, &b);
    printf("Lowest Common Ancestor: %d\n", findLCA(tree, n, a, b));
    return 0;
}