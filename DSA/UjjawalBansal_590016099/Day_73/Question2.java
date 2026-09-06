import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class Question2 {

    public static void solve() {
        Scanner sc = new Scanner(System.in);
        
        if (!sc.hasNextInt()) return;
        int t = sc.nextInt();
        
        while (t-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            
            List<List<Integer>> adj = new ArrayList<>();
            for (int i = 0; i <= n; i++) {
                adj.add(new ArrayList<>());
            }
            
            for (int i = 0; i < m; i++) {
                int u = sc.nextInt();
                int v = sc.nextInt();
                adj.get(u).add(v);
                adj.get(v).add(u);
            }
            
            int startNode = sc.nextInt();
            
            int[] prev = new int[n + 1];
            int[] next = new int[n + 1];
            int head = 0;
            int tail = 0;
            
            for (int i = 1; i <= n; i++) {
                if (i == startNode) continue; // Start node is already visited
                
                if (head == 0) {
                    head = i;
                    tail = i;
                } else {
                    next[tail] = i;
                    prev[i] = tail;
                    tail = i;
                }
            }
            
            int[] dist = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                dist[i] = -1;
            }
            dist[startNode] = 0;
            
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(startNode);
            
            boolean[] isNeighbor = new boolean[n + 1];
            
            while (!queue.isEmpty()) {
                int u = queue.poll();
                
                for (int neighbor : adj.get(u)) {
                    isNeighbor[neighbor] = true;
                }
                
                int curr = head;
                while (curr != 0) {
                    int nextUnvisited = next[curr]; 
                    
                    if (!isNeighbor[curr]) {
                        dist[curr] = dist[u] + 1;
                        queue.offer(curr);
                        
                        if (prev[curr] != 0) {
                            next[prev[curr]] = next[curr];
                        } else {
                            head = next[curr]; 
                        }
                        
                        if (next[curr] != 0) {
                            prev[next[curr]] = prev[curr];
                        }
                    }
                    
                    curr = nextUnvisited;
                }
                
                for (int neighbor : adj.get(u)) {
                    isNeighbor[neighbor] = false;
                }
            }
            
            StringBuilder sb = new StringBuilder();
            for (int i = 1; i <= n; i++) {
                if (i != startNode) {
                    sb.append(dist[i]).append(" ");
                }
            }
            System.out.println(sb.toString().trim());
        }
        
        sc.close();
    }

    public static void main(String[] args) {
        try {
            solve();
        } 
        catch (Exception e) {
            System.out.println("Invalid input format detected.");
        }
    }
}