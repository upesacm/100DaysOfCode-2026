int closestMeetingNode(int* edges, int edgesSize, int node1, int node2) {
    int dist1[edgesSize];
    int dist2[edgesSize];

    for (int i = 0; i < edgesSize; i++) {
        dist1[i] = -1;
        dist2[i] = -1;
    }

    int curr = node1;
    int d = 0;

    while (curr != -1 && dist1[curr] == -1) {
        dist1[curr] = d++;
        curr = edges[curr];
    }

    curr = node2;
    d = 0;

    while (curr != -1 && dist2[curr] == -1) {
        dist2[curr] = d++;
        curr = edges[curr];
    }

    int ans = -1;
    int minDist = edgesSize + 1;

    for (int i = 0; i < edgesSize; i++) {
        if (dist1[i] != -1 && dist2[i] != -1) {
            int maxDist = dist1[i] > dist2[i] ? dist1[i] : dist2[i];

            if (maxDist < minDist) {
                minDist = maxDist;
                ans = i;
            }
        }
    }

    return ans;
}