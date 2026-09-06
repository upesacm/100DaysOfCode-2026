#include<iostream>
#include<vector>
using namespace std;

struct Edge {
    int u, v, w;
};

vector<int> par;

int find(int x) {
    while (par[x] != x)
        x = par[x];

    return x;
}

void Union(int a, int b) {
    a = find(a);
    b = find(b);

    if (a != b)
        par[b] = a;
}

int main() {
    int n, m;
    cin >> n >> m;

    vector<Edge> edges(m);

    for (int i = 0; i < m; i++) {
        cin >> edges[i].u >> edges[i].v >> edges[i].w;
    }

    // Kruskal sorting
    sort(edges.begin(), edges.end(), [](const Edge& a, const Edge& b) {
        if (a.w != b.w)
            return a.w < b.w;

        return a.u + a.v + a.w < b.u + b.v + b.w;
    });

    // Initialize DSU
    par.resize(n + 1);

    for (int i = 1; i <= n; i++)
        par[i] = i;

    long long ans = 0;
    int count = 0;

    for (auto &e : edges) {
        if (find(e.u) != find(e.v)) {
            Union(e.u, e.v);

            ans += e.w;
            count++;

            if (count == n - 1)
                break;
        }
    }

    cout << ans << '\n';

    return 0;
}