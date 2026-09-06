import java.util.*;

public class Question2 {
    static int[] parent;

    static int find(int x) {
        int r = x;
        while (parent[r] != r) r = parent[r];
        while (parent[x] != x) {
            int t = parent[x];
            parent[x] = r;
            x = t;
        }
        return r;
    }

    static void remove(int x) {
        parent[x] = find(x + 1);
    }

    static void solve(int n,int s,int[] head,int[] to,int[] nextEdge) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist,-1);
        parent = new int[n + 2];
        for (int i = 1; i <= n + 1; i++) parent[i] = i;

        int[] queue = new int[n];
        int[] blocked = new int[n + 1];
        int front = 0,rear = 0;

        dist[s] = 0;
        remove(s);
        queue[rear++] = s;

        while (front < rear) {
            int u = queue[front++];
            for (int e = head[u]; e != -1; e = nextEdge[e])
                blocked[to[e]] = u;

            int v = find(1);
            while (v <= n) {
                if (blocked[v] != u) {
                    dist[v] = dist[u] + 1;
                    queue[rear++] = v;
                    remove(v);
                    v = find(v);
                } else v = find(v + 1);
            }
        }

        System.out.println("\nShortest distances:");
        for (int v = 1; v <= n; v++) {
            if (v == s) continue;
            System.out.print(dist[v] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number of test cases: ");
        int T = sc.nextInt();

        while (T-- > 0) {
            System.out.print("Enter the number of nodes (N): ");
            int n = sc.nextInt();
            System.out.print("Enter the number of main-road edges (M): ");
            int m = sc.nextInt();

            int[] head = new int[n + 1];
            Arrays.fill(head,-1);
            int[] to = new int[2 * m];
            int[] nextEdge = new int[2 * m];
            int idx = 0;

            System.out.println("Enter the " + m + " main-road edges (u v):");
            for (int i = 0; i < m; i++) {
                System.out.print("Edge " + (i + 1) + ": ");
                int u = sc.nextInt(),v = sc.nextInt();

                to[idx] = v;
                nextEdge[idx] = head[u];
                head[u] = idx++;

                to[idx] = u;
                nextEdge[idx] = head[v];
                head[v] = idx++;
            }

            System.out.print("Enter starting node (S): ");
            int s = sc.nextInt();
            solve(n,s,head,to,nextEdge);
            
        }
        sc.close();
    }
}