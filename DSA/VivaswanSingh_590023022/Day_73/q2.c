#include <stdio.h>

#define MAX 100005

int parent[MAX];
int size[MAX];

int find(int x)
{
    if (parent[x] != x)
        parent[x] = find(parent[x]);

    return parent[x];
}

void unite(int a, int b)
{
    a = find(a);
    b = find(b);

    if (a == b)
        return;

    if (size[a] < size[b])
    {
        int temp = a;
        a = b;
        b = temp;
    }

    parent[b] = a;
    size[a] += size[b];
}

void solve(int n, int m, int edges[][2])
{
    for (int i = 1; i <= n; i++)
    {
        parent[i] = i;
        size[i] = 1;
    }

    for (int i = 0; i < m; i++)
        unite(edges[i][0], edges[i][1]);

    int components = 0;
    int largest = 0;

    for (int i = 1; i <= n; i++)
    {
        if (parent[i] == i)
        {
            components++;

            if (size[i] > largest)
                largest = size[i];
        }
    }

    printf("%d %d\n", components, largest);
}

int main()
{
    int n = 4;
    int m = 3;

    int edges[3][2] = {
        {1, 2},
        {2, 3},
        {1, 4}
    };

    solve(n, m, edges);

    return 0;
}