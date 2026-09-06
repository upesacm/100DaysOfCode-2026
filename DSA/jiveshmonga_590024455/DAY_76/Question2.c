#include <stdio.h>
#include <stdbool.h>

bool hasEulerTrail(int n, int edges[][2], int m) {
    int degree[1000] = {0};

    for (int i = 0; i < m; i++) {
        degree[edges[i][0]]++;
        degree[edges[i][1]]++;
    }

    int odd = 0;

    for (int i = 0; i < n; i++) {
        if (degree[i] % 2 != 0)
            odd++;
    }

    return odd == 0 || odd == 2;
}

bool kthLineGraphEuler(int n, int edges[][2], int m, int k) {
    if (m == 0)
        return true;

    return hasEulerTrail(n, edges, m);
}