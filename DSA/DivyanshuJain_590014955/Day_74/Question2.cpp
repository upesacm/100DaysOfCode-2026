#include <iostream>
#include <vector>
#include <queue>
#include <climits>
#include <algorithm>

using namespace std;

class MaxFlow {
public:
    int n;
    vector<vector<int>> cap;

    MaxFlow(int n) {
        this->n = n;
        cap.resize(n, vector<int>(n, 0));
    }

    void addEdge(int u, int v, int c) {
        cap[u][v] += c;
    }

    bool bfs(int s, int t, vector<int>& parent) {
        fill(parent.begin(), parent.end(), -1);

        queue<int> q;
        q.push(s);
        parent[s] = -2;

        while (!q.empty()) {
            int u = q.front();
            q.pop();

            for (int v = 0; v < n; v++) {
                if (parent[v] == -1 && cap[u][v] > 0) {
                    parent[v] = u;

                    if (v == t)
                        return true;

                    q.push(v);
                }
            }
        }

        return false;
    }

    int maxFlow(int s, int t) {
        int flow = 0;
        vector<int> parent(n);

        while (bfs(s, t, parent)) {

            int pathFlow = INT_MAX;

            for (int v = t; v != s; v = parent[v]) {
                int u = parent[v];
                pathFlow = min(pathFlow, cap[u][v]);
            }

            for (int v = t; v != s; v = parent[v]) {
                int u = parent[v];

                cap[u][v] -= pathFlow;
                cap[v][u] += pathFlow;
            }

            flow += pathFlow;
        }

        return flow;
    }
};

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int C;
    cin >> C;

    while (C--) {

        int N, T, M;
        cin >> N >> T >> M;

        int source = 0;
        int headStart = 1;
        int footStart = N + 1;
        int sink = 2 * N + 1;

        MaxFlow mf(2 * N + 2);

        vector<int> degree(N + 1, 0);

        for (int i = 0; i < M; i++) {
            int u, v;
            cin >> u >> v;

            degree[u]++;
            degree[v]++;

            // u is head, v is foot
            mf.addEdge(
                headStart + u - 1,
                footStart + v - 1,
                1
            );

            // v is head, u is foot
            mf.addEdge(
                headStart + v - 1,
                footStart + u - 1,
                1
            );
        }

        // Source -> heads
        for (int i = 1; i <= N; i++) {

            int head = headStart + i - 1;
            int foot = footStart + i - 1;

            // A head can have at most T feet
            mf.addEdge(
                source,
                head,
                min(T, degree[i])
            );

            // A vertex can be used as a foot only once
            mf.addEdge(
                foot,
                sink,
                1
            );
        }

        cout << mf.maxFlow(source, sink) << '\n';
    }

    return 0;
}