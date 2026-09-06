import java.util.*;

// ---------------------------------------------------------
// EDGE CLASS
// ---------------------------------------------------------

class Edge {

    int u;      // First vertex
    int v;      // Second vertex
    int weight; // Weight of the edge

    // Constructor
    Edge(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }
}


// ---------------------------------------------------------
// SOLUTION CLASS
// ---------------------------------------------------------

class Solution {

    // Parent array for Union-Find
    int[] parent;

    // Find the parent of a node
    int find(int x) {

        // If x is not its own parent
        if (parent[x] != x) {

            // Find the actual parent
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }


    // Join two sets
    boolean union(int a, int b) {

        // Find parents of both nodes
        int parentA = find(a);
        int parentB = find(b);

        // If both have same parent,
        // adding this edge creates a cycle
        if (parentA == parentB) {
            return false;
        }

        // Join the two sets
        parent[parentB] = parentA;

        return true;
    }


    // ---------------------------------------------------------
    // KRUSKAL'S ALGORITHM
    // ---------------------------------------------------------

    int kruskal(int n, ArrayList<Edge> edges) {

        // Create parent array
        parent = new int[n + 1];

        // Initially every node is its own parent
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }


        // Sort edges by weight
        Collections.sort(edges, (a, b) -> a.weight - b.weight);


        // Store total MST weight
        int totalWeight = 0;

        // Count edges added to MST
        int edgesUsed = 0;


        // Go through every edge
        for (Edge edge : edges) {

            // Try to join the two vertices
            if (union(edge.u, edge.v)) {

                // Edge does not create a cycle,
                // so add its weight
                totalWeight += edge.weight;

                // One more edge added
                edgesUsed++;

                // MST needs exactly n - 1 edges
                if (edgesUsed == n - 1) {
                    break;
                }
            }
        }

        // Return total weight of MST
        return totalWeight;
    }
}


// ---------------------------------------------------------
// DRIVER / MAIN CLASS
// ---------------------------------------------------------

public class Question2{

    public static void main(String[] args) {

        // Scanner takes input from user
        Scanner sc = new Scanner(System.in);

        // Take number of vertices
        int n = sc.nextInt();

        // Take number of edges
        int m = sc.nextInt();


        // Store all edges
        ArrayList<Edge> edges = new ArrayList<>();


        // Take all edges
        for (int i = 0; i < m; i++) {

            // First vertex
            int u = sc.nextInt();

            // Second vertex
            int v = sc.nextInt();

            // Weight
            int weight = sc.nextInt();

            // Create and store edge
            edges.add(new Edge(u, v, weight));
        }


        // Create Solution object
        Solution solution = new Solution();


        // Find MST total weight
        int answer = solution.kruskal(n, edges);


        // Print answer
        System.out.println(answer);


        // Close Scanner
        sc.close();
    }
}