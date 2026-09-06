int* getDistances(int* edges, int n, int start) {
    int* dist = (int*)malloc(n * sizeof(int));

    for (int i = 0; i < n; i++)
        dist[i] = -1;

    int curr = start;
    int d = 0;

    while (curr != -1 && dist[curr] == -1) {
        dist[curr] = d;
        d++;
        curr = edges[curr];
    }

    return dist;
}

int closestMeetingNode(int* edges, int edgesSize, int node1, int node2) {
    int n = edgesSize;

    int* dist1 = getDistances(edges, n, node1);
    int* dist2 = getDistances(edges, n, node2);

    int answer = -1;
    int minDist = n + 1;

    for (int i = 0; i < n; i++) {
        // Node must be reachable from both nodes
        if (dist1[i] != -1 && dist2[i] != -1) {
            int maxDist = dist1[i] > dist2[i] ? dist1[i] : dist2[i];

            if (maxDist < minDist) {
                minDist = maxDist;
                answer = i;
            }
        }
    }

    free(dist1);
    free(dist2);

    return answer;
}
