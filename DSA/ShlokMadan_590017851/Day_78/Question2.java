import java.util.*;
public class Question2 
{
    static class Node 
    {
        Node[] child=new Node[2];
    }
    static Node root=new Node();
    static void insert(int num) 
    {
        Node curr=root;
        for(int i=30;i>=0;i--) 
            {
            int bit=(num>>i)&1;
            if(curr.child[bit]==null)
                curr.child[bit]=new Node();
            curr=curr.child[bit];
        }
    }
    static int getMaxXor(int num) 
    {
        Node curr=root;
        int ans=0;
        for(int i=30;i>=0;i--) 
            {
            int bit=(num>>i)&1;
            int opposite=1-bit;
            if(curr.child[opposite]!=null) 
                {
                ans|=(1<<i);
                curr=curr.child[opposite];
            } else {
                curr=curr.child[bit];
            }
        }
        return ans;
    }
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++) 
            {
            arr[i]=sc.nextInt();
            insert(arr[i]);
        }
        int ans=0;
        for(int i=0;i<n;i++)
            ans=Math.max(ans,getMaxXor(arr[i]));
        System.out.println(ans);
    }
}