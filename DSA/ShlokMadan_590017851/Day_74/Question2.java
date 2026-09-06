import java.util.*;

public class Question2 {

    static ArrayList<Integer>[] graph;
    static int[] match;
    static boolean[] visited;

    static boolean dfs(int node) {

        for (int next:graph[node]) {

            if (visited[next]) {
                continue;
            }

            visited[next]=true;

            if (match[next]==-1 || dfs(match[next])) {
                match[next]=node;
                return true;
            }
        }

        return false;
    }

    public static int maxCrabCoverage(int n,int t,int[][] edges) {

        graph=new ArrayList[n+1];

        for (int i=1;i<=n;i++) {
            graph[i]=new ArrayList<>();
        }

        for (int[] edge:edges) {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }

        match=new int[n+1];
        Arrays.fill(match,-1);

        int matched=0;

        for (int i=1;i<=n;i++) {

            visited=new boolean[n+1];

            if (dfs(i)) {
                matched++;
            }
        }

        return Math.min(n,matched*2);
    }

    public static void main(String[] args) {

        int n=3;
        int t=2;

        int[][] edges={
            {1,2},
            {1,3}
        };

        System.out.println(maxCrabCoverage(n,t,edges));
    }
}