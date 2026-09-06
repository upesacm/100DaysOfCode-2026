import java.io.*;
import java.util.*;

public class Question2 {
    static int[] neighbor1,neighbor2,cost1,cost2;

    static int findMinimumCost(int n,int[][] roads) {
        neighbor1=new int[n+1];
        neighbor2=new int[n+1];
        cost1=new int[n+1];
        cost2=new int[n+1];
        int totalCost=0;

        for(int[] road:roads){
            int u=road[0],v=road[1],c=road[2];
            totalCost+=c;

            if(neighbor1[u]==0){neighbor1[u]=v;cost1[u]=0;}
            else{neighbor2[u]=v;cost2[u]=0;}

            if(neighbor1[v]==0){neighbor1[v]=u;cost1[v]=c;}
            else{neighbor2[v]=u;cost2[v]=c;}
        }

        int previous=1,current=neighbor1[1],clockwiseCost=cost1[1];

        while(current!=1){
            if(neighbor1[current]!=previous){
                clockwiseCost+=cost1[current];
                previous=current;
                current=neighbor1[current];
            }else{
                clockwiseCost+=cost2[current];
                previous=current;
                current=neighbor2[current];
            }
        }

        return Math.min(clockwiseCost,totalCost-clockwiseCost);
    }

    public static void main(String[] args)throws Exception{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter the number of cities: ");
        int n=Integer.parseInt(br.readLine().trim());
        int[][] roads=new int[n][3];

        System.out.println("Enter each road as: fromCity toCity reversalCost");
        for(int i=0;i<n;i++){
            System.out.print("Enter road "+(i+1)+": ");
            StringTokenizer st=new StringTokenizer(br.readLine());
            roads[i][0]=Integer.parseInt(st.nextToken());
            roads[i][1]=Integer.parseInt(st.nextToken());
            roads[i][2]=Integer.parseInt(st.nextToken());
        }

        System.out.println("Minimum amount required: "+findMinimumCost(n,roads));
    }
}