import java.util.Scanner;

public class Question2 {
    public boolean hasEulerTrail(int n, int[][] edges, int k) {
        int m = edges.length;
        
        int[] head = new int[n + 1];
        int[] next = new int[2 * m];
        int[] to = new int[2 * m];
        int[] degree = new int[n + 1];
        
        for (int i = 0; i <= n; i++) {
            head[i] = -1;
        }
        
        int edgeIdx = 0;
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            
            to[edgeIdx] = v;
            next[edgeIdx] = head[u];
            head[u] = edgeIdx++;
            
            to[edgeIdx] = u;
            next[edgeIdx] = head[v];
            head[v] = edgeIdx++;
            
            degree[u]++;
            degree[v]++;
        }
        
        int odd1 = -1, odd2 = -1;
        for (int i = 1; i <= n; i++) {
            if (degree[i] % 2 != 0) {
                if (odd1 == -1) odd1 = i;
                else if (odd2 == -1) odd2 = i;
                else return false;
            }
        }
        if (odd1 == -1 && odd2 == -1) {
            return true;
        }
        
        if (k == 1) {
            if (degree[odd1] == 1 && degree[odd2] == 1) return true;
            if (degree[odd1] == 3 && degree[odd2] == 1) {
                return to[head[odd2]] == odd1;
            }
            if (degree[odd1] == 1 && degree[odd2] == 3) {
                return to[head[odd1]] == odd2;
            }
            return false;
        }
    
        if (degree[odd1] == 1 && degree[odd2] == 1) {
            int tailLength1 = getTailLength(odd1, head, next, to, degree);
            int tailLength2 = getTailLength(odd2, head, next, to, degree);
            
            return tailLength1 >= k - 1 && tailLength2 >= k - 1;
        }
        return false;
    }
    private int getTailLength(int startVertex, int[] head, int[] next, int[] to, int[] degree) {
        int len = 0;
        int curr = startVertex;
        int prev = -1;
        
        while (true) {
            int nxt = -1;
            
            for (int e = head[curr]; e != -1; e = next[e]) {
                int v = to[e];
                if (v != prev) {
                    nxt = v;
                    break;
                }
            }
            
            if (nxt == -1) break;
            if (degree[nxt] == 2) {
                len++;
                prev = curr;
                curr = nxt;
            } 
            else {
                break;
            }
        }
        
        return len;
    }
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of vertices (n): ");
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();
            
        System.out.println("Enter the number of edges: ");
        int m = sc.nextInt();
            
        int[][] edges = new int[m][2];
        if (m > 0) {
            System.out.println("Enter the " + m + " edges (u v) separated by spaces:");
            for (int i = 0; i < m; i++) {
                edges[i][0] = sc.nextInt();
                edges[i][1] = sc.nextInt();
            }
        }
            
        System.out.println("Enter the value of k (number of line-graph iterations): ");
        int k = sc.nextInt();
        Question2 solver = new Question2();
        boolean result = solver.hasEulerTrail(n, edges, k);
        System.out.println("\nDoes L^k(G) have an Euler trail? " + result);
        sc.close();
    }
}