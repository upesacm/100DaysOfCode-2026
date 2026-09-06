import java.util.*;

public class Question1 {

    static final long MOD=1000000007;

    static ArrayList<Integer>[] tree;
    static long[] fact;
    static long[] invFact;

    static long power(long a,long b) {
        long result=1;

        while(b>0) {
            if((b&1)==1) {
                result=result*a%MOD;
            }

            a=a*a%MOD;
            b/=2;
        }

        return result;
    }

    static void dfs(int node) {

        int size=1;
        long ways=1;

        ArrayList<Integer> children=tree[node];

        for(int child:children) {
            dfs(child);

            int childSize=subtreeSize[child];

            ways=ways*subtreeWays[child]%MOD;
            ways=ways*invFact[childSize]%MOD;

            size+=childSize;
        }

        ways=ways*fact[size-1]%MOD;

        subtreeSize[node]=size;
        subtreeWays[node]=ways;
    }

    static int[] subtreeSize;
    static long[] subtreeWays;

    public static int waysToBuildRooms(int[] prevRoom) {

        int n=prevRoom.length;

        tree=new ArrayList[n];

        for(int i=0;i<n;i++) {
            tree[i]=new ArrayList<>();
        }

        for(int i=1;i<n;i++) {
            tree[prevRoom[i]].add(i);
        }

        fact=new long[n+1];
        invFact=new long[n+1];

        fact[0]=1;

        for(int i=1;i<=n;i++) {
            fact[i]=fact[i-1]*i%MOD;
        }

        invFact[n]=power(fact[n],MOD-2);

        for(int i=n-1;i>=0;i--) {
            invFact[i]=invFact[i+1]*(i+1)%MOD;
        }

        subtreeSize=new int[n];
        subtreeWays=new long[n];

        dfs(0);

        return (int)subtreeWays[0];
    }

    public static void main(String[] args) {

        int[] prevRoom={-1,0,0,1,2};

        System.out.println(waysToBuildRooms(prevRoom));
    }
}