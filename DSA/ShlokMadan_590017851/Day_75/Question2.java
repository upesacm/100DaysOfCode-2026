import java.util.*;
public class Question2 
{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[][] roads=new int[n][3];
        for(int i=0;i<n;i++) 
            {
            roads[i][0]=sc.nextInt();
            roads[i][1]=sc.nextInt();
            roads[i][2]=sc.nextInt();
        }
        ArrayList<Integer>[] graph=new ArrayList[n+1];
        for(int i=1;i<=n;i++) 
            {
            graph[i]=new ArrayList<>();
        }
        for(int[] road:roads) 
            {
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }
        ArrayList<Integer> order=new ArrayList<>();
        int previous=-1;
        int current=1;
        while(order.size()<n) 
            {
            order.add(current);
            int next=-1;
            for(int node:graph[current]) 
                {
                if(node!=previous) 
                    {
                    next=node;
                    break;
                }
            }
            previous=current;
            current=next;
        }
        int clockwise=0;
        int anticlockwise=0;
        for(int i=0;i<n;i++) 
            {
            int from=order.get(i);
            int to=order.get((i+1)%n);
            for(int[] road:roads) 
                {
                if(road[0]==from && road[1]==to) 
                    {
                    anticlockwise+=road[2];
                }
                if(road[0]==to && road[1]==from) 
                    {
                    clockwise+=road[2];
                }
            }
        }
        System.out.println(Math.min(clockwise,anticlockwise));
    }
}