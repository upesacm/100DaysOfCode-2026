import java.io.*;
import java.util.*;

public class Question2 {
    static int[] head,to,next,cap,level,ptr;
    static int edgeCount,nodes;

    static void init(int n,int maxEdges){
        nodes=n;
        head=new int[n];
        to=new int[maxEdges];
        next=new int[maxEdges];
        cap=new int[maxEdges];
        level=new int[n];
        ptr=new int[n];
        Arrays.fill(head,-1);
        edgeCount=0;
    }

    static void addEdge(int u,int v,int c){
        to[edgeCount]=v;
        cap[edgeCount]=c;
        next[edgeCount]=head[u];
        head[u]=edgeCount++;
        to[edgeCount]=u;
        cap[edgeCount]=0;
        next[edgeCount]=head[v];
        head[v]=edgeCount++;
    }

    static boolean bfs(int s,int t){
        Arrays.fill(level,-1);
        int[] q=new int[nodes];
        int front=0,rear=0;
        level[s]=0;
        q[rear++]=s;

        while(front<rear){
            int u=q[front++];
            for(int e=head[u];e!=-1;e=next[e]){
                int v=to[e];
                if(cap[e]>0&&level[v]==-1){
                    level[v]=level[u]+1;
                    q[rear++]=v;
                }
            }
        }
        return level[t]!=-1;
    }

    static int dfs(int u,int t,int flow){
        if(u==t)return flow;

        for(int e=ptr[u];e!=-1;ptr[u]=e=next[e]){
            int v=to[e];
            if(cap[e]>0&&level[v]==level[u]+1){
                int pushed=dfs(v,t,Math.min(flow,cap[e]));
                if(pushed>0){
                    cap[e]-=pushed;
                    cap[e^1]+=pushed;
                    return pushed;
                }
            }
        }
        return 0;
    }

    static int maxFlow(int s,int t){
        int flow=0;
        while(bfs(s,t)){
            System.arraycopy(head,0,ptr,0,nodes);
            int pushed;
            while((pushed=dfs(s,t,Integer.MAX_VALUE))>0)
                flow+=pushed;
        }
        return flow;
    }

    static int solve(int n,int t,int m,int[][] edges){
        int source=2*n,sink=source+1;
        init(2*n+2,4*m+4*n+5);

        int[] degree=new int[n];
        for(int[] e:edges){
            degree[e[0]]++;
            degree[e[1]]++;
        }

        for(int v=0;v<n;v++){
            addEdge(source,v,Math.min(t,degree[v]));
            addEdge(n+v,sink,1);
        }

        for(int[] e:edges){
            int u=e[0],v=e[1];
            addEdge(u,n+v,1);
            addEdge(v,n+u,1);
        }

        return maxFlow(source,sink);
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter number of test cases: ");
        int c=Integer.parseInt(br.readLine().trim());
        StringBuilder out=new StringBuilder();

        for(int tc=1;tc<=c;tc++){
            System.out.println("\nTest case "+tc);
            System.out.print("Enter number of vertices, maximum number of feet, and number of edges: ");

            StringTokenizer st=new StringTokenizer(br.readLine());
            int n=Integer.parseInt(st.nextToken());
            int t=Integer.parseInt(st.nextToken());
            int m=Integer.parseInt(st.nextToken());

            int[][] edges=new int[m][2];
            System.out.println("Enter "+m+" edges:");

            for(int i=0;i<m;i++){
                st=new StringTokenizer(br.readLine());
                edges[i][0]=Integer.parseInt(st.nextToken())-1;
                edges[i][1]=Integer.parseInt(st.nextToken())-1;
            }

            int answer=solve(n,t,m,edges);
            System.out.println("Maximum vertices covered = "+answer);
        }
    }
}