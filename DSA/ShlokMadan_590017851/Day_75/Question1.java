import java.util.*;
public class Question1 
{
    public static int largestPathValue(String colors,int[][] edges) 
    {
        int n=colors.length();
        ArrayList<Integer>[] graph=new ArrayList[n];
        int[] indegree=new int[n];
        for(int i=0;i<n;i++) 
            {
            graph[i]=new ArrayList<>();
        }
        for(int[] edge:edges) 
            {
            graph[edge[0]].add(edge[1]);
            indegree[edge[1]]++;
        }
        int[][] count=new int[n][26];
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<n;i++) 
            {
            if(indegree[i]==0) 
                {
                queue.add(i);
            }
        }
        int answer=0;
        int visited=0;
        while(!queue.isEmpty()) 
            {
            int node=queue.poll();
            visited++;
            int color=colors.charAt(node)-'a';
            count[node][color]++;
            answer=Math.max(answer,count[node][color]);
            for(int next:graph[node]) 
                {
                for(int i=0;i<26;i++) 
                    {
                    count[next][i]=Math.max(count[next][i],count[node][i]);
                }
                indegree[next]--;
                if(indegree[next]==0) 
                    {
                    queue.add(next);
                }
            }
        }
        if(visited<n) 
            {
            return -1;
        }
        return answer;
    }
    public static void main(String[] args) 
    {
        String colors="abaca";
        int[][] edges={
            {0,1},
            {0,2},
            {2,3},
            {3,4}
        };
        System.out.println(largestPathValue(colors,edges));
    }
}