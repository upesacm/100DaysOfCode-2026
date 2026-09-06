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
        dist1[curr] = d;
        d++;
        curr = edges[curr];
    }
    curr = node2;
    d = 0;
    while (curr != -1 && dist2[curr] == -1) {
        dist2[curr] = d;
        d++;
        curr = edges[curr];
    }
    int answer = -1;
    int minDistance = edgesSize + 1;
    for (int i = 0; i < edgesSize; i++) {
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
    return answer;
}