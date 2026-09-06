long long countPairs(int n, int** edges, int edgesSize, int* edgesColSize)
{
    int *parent = malloc(n * sizeof(int));
    int *size = malloc(n * sizeof(int));

    for (int i = 0; i < n; i++)
    {
        parent[i] = i;
        size[i] = 1;
    }

    int find(int x)
    {
        if (parent[x] != x)
            parent[x] = find(parent[x]);

        return parent[x];
    }

    for (int i = 0; i < edgesSize; i++)
    {
        int a = find(edges[i][0]);
        int b = find(edges[i][1]);

        if (a != b)
        {
            if (size[a] < size[b])
            {
                int temp = a;
                a = b;
                b = temp;
            }

            parent[b] = a;
            size[a] += size[b];
        }
    }

    long long answer = 0;
    long long previous = 0;

    for (int i = 0; i < n; i++)
    {
        if (parent[i] == i)
        {
            answer += previous * size[i];
            previous += size[i];
        }
    }

    free(parent);
    free(size);

    return answer;
}