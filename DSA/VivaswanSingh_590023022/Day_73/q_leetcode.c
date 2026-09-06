#include <stdlib.h>

int closestMeetingNode(int* edges, int edgesSize, int node1, int node2)
{
    int *dist1 = malloc(edgesSize * sizeof(int));
    int *dist2 = malloc(edgesSize * sizeof(int));

    for (int i = 0; i < edgesSize; i++)
    {
        dist1[i] = -1;
        dist2[i] = -1;
    }

    // Distance from node1
    int node = node1;
    int distance = 0;

    while (node != -1 && dist1[node] == -1)
    {
        dist1[node] = distance++;
        node = edges[node];
    }

    // Distance from node2
    node = node2;
    distance = 0;

    while (node != -1 && dist2[node] == -1)
    {
        dist2[node] = distance++;
        node = edges[node];
    }

    int answer = -1;
    int best = 1000000000;

    for (int i = 0; i < edgesSize; i++)
    {
        if (dist1[i] != -1 && dist2[i] != -1)
        {
            int current = dist1[i] > dist2[i] ? dist1[i] : dist2[i];

            if (current < best)
            {
                best = current;
                answer = i;
            }
        }
    }

    free(dist1);
    free(dist2);

    return answer;
}