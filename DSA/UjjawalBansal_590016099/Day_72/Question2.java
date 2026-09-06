import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

class Edge implements Comparable<Edge> {
    int u, v, w;

    public Edge(int u, int v, int w) {
        this.u = u;
        this.v = v;
        this.w = w;
    }

    @Override
    public int compareTo(Edge other) {
        if (this.w != other.w) {
            return Integer.compare(this.w, other.w);
        }
        return Integer.compare(this.u + this.v + this.w, other.u + other.v + other.w);
    }
}

public class Question2{

    public static int find(int i, int[] parent) {
        if (parent[i] == i) {
            return i;
        }
        return parent[i] = find(parent[i], parent);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);        
        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            edges.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }

        Collections.sort(edges);

        int[] parent = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i; 
        }
        long totalWeight = 0;

        for (Edge edge : edges) {
            int rootU = find(edge.u, parent);
            int rootV = find(edge.v, parent);
            if (rootU != rootV) {
                totalWeight += edge.w;
                
                parent[rootU] = rootV;
            }
        }

        System.out.println(totalWeight);
        sc.close();
    }
}