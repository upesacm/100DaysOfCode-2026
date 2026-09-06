#include <stdlib.h>

int minCostToMakeRingStronglyConnected(int n, int** roads, int roadsSize, int* roadsColSize) {
    int clockwise = 0;
    for (int i = 0; i < roadsSize; i++) {
        int u = roads[i][0];
        int v = roads[i][1];
        if (v != (u + 1) % n)
            clockwise++;
    }
    return clockwise < n - clockwise ? clockwise : n - clockwise;
}