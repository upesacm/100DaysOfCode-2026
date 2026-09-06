import java.util.*;
public class Question1 
{
    public static long countPairs(int n, int[][] edges) 
    {
        ArrayList<Integer>[] graph = new ArrayList[n];
        for (int i=0;i<n;i++) 
            {
            graph[i]=new ArrayList<>();
        }
        for (int[] edge:edges) 
            {
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        boolean[] visited=new boolean[n];
        long answer=0;
        long remaining=n;
        for (int i=0;i<n;i++) 
            {
            if (!visited[i]) 
                {
                long size=0;
                Queue<Integer> queue=new LinkedList<>();
                queue.add(i);
                visited[i]=true;
                while (!queue.isEmpty()) 
                    {
                    int node=queue.poll();
                    size++;
                    for (int next:graph[node]) 
                        {
                        if (!visited[next]) 
                            {
                            visited[next]=true;
                            queue.add(next);
                        }
                    }
                }
                remaining-=size;
                answer+=size*remaining;
            }
        }
        return answer;
    }
    public static void main(String[] args) 
    {
        int n=7;
        int[][] edges={
            {0,2},
            {0,5},
            {2,4},
            {1,6},
            {5,4}
        };
        System.out.println(countPairs(n,edges));
    }
}