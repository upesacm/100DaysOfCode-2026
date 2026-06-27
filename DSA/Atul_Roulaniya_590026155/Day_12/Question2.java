import java.util.*;
class window
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String s;
        System.out.println("Enter a string");
        s=sc.nextLine();
        int n=s.length();
        boolean vis[]=new boolean[256];
        int dis=0;

        for(int i=0; i < n; i++)
        {
            if(!vis[s.charAt(i)])
            {
                vis[s.charAt(i)]=true;
                dis++;
            }
        }
        int ans=n;
        for(int i=0;i < n;i++)
        {
            int freq[]=new int[256];
            int count=0;

            for(int j=i; j < n ;j++)
            {
                if(freq[s.charAt(j)]==0)
                {
                    count++;
                }
                freq[s.charAt(j)]++;
                if(count == dis)
                {
                    ans=Math.min(ans,j-i+1);
                    break;
                }
            }
        }
        System.out.println(ans);
    }
}