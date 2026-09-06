#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// Disjoint Set Union (DSU) structure to help detect cycles
struct DSU {
    vector<int> parent;
    vector<int> rank;

    DSU(int n) {
        parent.resize(n + 1);
        rank.resize(n + 1, 0);
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
    }

    int find(int i) {
        if (parent[i] == i)
            return i;
        // Path compression
        return parent[i] = find(parent[i]);
    }

    bool unite(int i, int j) {
        int root_i = find(i);
        int root_j = find(j);

        if (root_i != root_j) {
            // Union by rank
            if (rank[root_i] < rank[root_j]) {
                swap(root_i, root_j);
            }
            parent[root_j] = root_i;
            if (rank[root_i] == rank[root_j]) {
                rank[root_i]++;
            }
            return true;
        }
        return false;
    }
};

int kruskalsMST(int n, vector<vector<int>>& edges) {
    // Sort edges ascending by weight (the 3rd element in each edge vector)
    sort(edges.begin(), edges.end(), [](const vector<int>& a, const vector<int>& b) {
        return a[2] < b[2];
    });

    DSU dsu(n);
    int totalWeight = 0;

    // Process each edge
    for (const auto& edge : edges) {
        int u = edge[0];
        int v = edge[1];
        int weight = edge[2];

        // If including this edge doesn't cause a cycle, add it to the MST
        if (dsu.unite(u, v)) {
            totalWeight += weight;
        }
    }

    return totalWeight;
}

int main() {
    int n = 4; // Number of nodes
    vector<vector<int>> edges = {
        {1, 2, 5}, {1, 3, 3}, {4, 1, 6}, 
        {2, 4, 7}, {3, 2, 4}, {3, 4, 5}
    };
    
    cout << "Output: " << kruskalsMST(n, edges) << "\n";
    // Expected Output: 12
    
    return 0;
}