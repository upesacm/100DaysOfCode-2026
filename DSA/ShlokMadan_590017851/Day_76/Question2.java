import java.util.*;

public class Question2 {

    public static boolean hasEulerTrail(int n,int[][] edges,int k) {

        int[] degree=new int[n+1];

        for(int[] edge:edges) {
            degree[edge[0]]++;
            degree[edge[1]]++;
        }

        int oddCount=0;
        int odd1=-1;
        int odd2=-1;

        for(int i=1;i<=n;i++) {

            if(degree[i]%2==1) {
                oddCount++;

                if(odd1==-1) {
                    odd1=i;
                } else {
                    odd2=i;
                }
            }
        }

        if(oddCount==0) {
            return true;
        }

        if(k==0) {
            return true;
        }

        int mixedEdges=0;

        for(int[] edge:edges) {

            boolean firstOdd=degree[edge[0]]%2==1;
            boolean secondOdd=degree[edge[1]]%2==1;

            if(firstOdd!=secondOdd) {
                mixedEdges++;
            }
        }

        if(mixedEdges<=2) {
            return true;
        }

        return k>=2;
    }

    public static void main(String[] args) {

        int n=4;

        int[][] edges={
            {1,2},
            {2,3},
            {3,4},
            {4,1}
        };

        int k=1;

        System.out.println(hasEulerTrail(n,edges,k));
    }
}