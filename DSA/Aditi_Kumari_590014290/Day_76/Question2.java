package Day_76;

import java.util.*;

public class Question2 {
    static boolean hasEulerTrail(int n,int[][] edges,int k){
        int[] degree=new int[n];
        for(int[] edge:edges){
            degree[edge[0]]++;
            degree[edge[1]]++;
        }
        if(!isConnected(n,edges,degree)) return false;
        int odd=0;
        for(int d:degree){
            if(d%2!=0) odd++;
        }
        if(k==0) return odd==0||odd==2;
        for(int i=0;i<k;i++){
            int oddVertices=0;
            for(int[] edge:edges){
                int d=degree[edge[0]]+degree[edge[1]]-2;
                if(d%2!=0) oddVertices++;
            }
            if(oddVertices!=0&&oddVertices!=2) return false;
        }
        return true;
    }

    static boolean isConnected(int n,int[][] edges,int[] degree){
        int start=-1;
        for(int i=0;i<n;i++){
            if(degree[i]>0){
                start=i;
                break;
            }
        }
        if(start==-1) return true;
        ArrayList<ArrayList<Integer>> graph=new ArrayList<>();
        for(int i=0;i<n;i++) graph.add(new ArrayList<>());
        for(int[] edge:edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        boolean[] visited=new boolean[n];
        Queue<Integer> queue=new LinkedList<>();
        queue.offer(start);
        visited[start]=true;
        while(!queue.isEmpty()){
            int node=queue.poll();
            for(int next:graph.get(node)){
                if(!visited[next]){
                    visited[next]=true;
                    queue.offer(next);
                }
            }
        }
        for(int i=0;i<n;i++){
            if(degree[i]>0&&!visited[i]) return false;
        }
        return true;
    }
}