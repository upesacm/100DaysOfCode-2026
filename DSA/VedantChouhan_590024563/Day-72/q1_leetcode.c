#include <stdio.h>

int main() {
    int n;

    printf("Enter number of nodes: ");
    scanf("%d", &n);

    int edges[n - 1][2];

    printf("Enter the edges:\n");

    for (int i = 0; i < n - 1; i++) {
        scanf("%d %d", &edges[i][0], &edges[i][1]);
    }

    int center;

    // The center must appear in both of the first two edges
    if (edges[0][0] == edges[1][0] ||
        edges[0][0] == edges[1][1]) {
        center = edges[0][0];
    } else {
        center = edges[0][1];
    }

    printf("Center: %d\n", center);

    return 0;
}