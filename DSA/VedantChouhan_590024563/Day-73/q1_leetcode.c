#include <stdio.h>

int main() {
    int n;

    printf("Enter number of nodes: ");
    scanf("%d", &n);

    int edges[n];

    printf("Enter edges:\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", &edges[i]);
    }

    int node1, node2;

    printf("Enter node1 and node2: ");
    scanf("%d %d", &node1, &node2);

    int dist1[n];
    int dist2[n];

    // Initialize distances
    for (int i = 0; i < n; i++) {
        dist1[i] = -1;
        dist2[i] = -1;
    }

    // Calculate distances from node1
    int current = node1;
    int distance = 0;

    while (current != -1 && dist1[current] == -1) {
        dist1[current] = distance;
        distance++;
        current = edges[current];
    }

    // Calculate distances from node2
    current = node2;
    distance = 0;

    while (current != -1 && dist2[current] == -1) {
        dist2[current] = distance;
        distance++;
        current = edges[current];
    }

    int answer = -1;
    int minDistance = 1000000000;

    // Find the best common node
    for (int i = 0; i < n; i++) {

        if (dist1[i] != -1 && dist2[i] != -1) {

            int maxDistance;

            if (dist1[i] > dist2[i])
                maxDistance = dist1[i];
            else
                maxDistance = dist2[i];

            if (maxDistance < minDistance) {
                minDistance = maxDistance;
                answer = i;
            }
        }
    }

    printf("Closest Meeting Node: %d\n", answer);

    return 0;
}