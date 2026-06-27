import java.util.*;
public class Question2 {
    public static int Better_String(String s){
        int n=s.length();
        int[] dp=new int [n+1];
        dp[0]=1;
        int[] prev=new int[256];
        Arrays.fill(prev,-1);                                                                                      
        for(int i=1;i<=n;i++){
            char c= s.charAt(i-1);
            dp[i]=2*dp[i-1];
            if(prev[c]!=-1) dp[i]-=dp[prev[c]];
            prev[c]=i-1;
        }
    return dp[n];
    }
    public static String compare_Strings(String s1,String s2){
        int dp_s1=Better_String(s1);
        int dp_s2=Better_String(s2);
        if(dp_s1>=dp_s2) return s1;
        else return s2;
    }          
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the first string: ");
        String s1=sc.nextLine();
        System.out.println("Enter the second string: ");
        String s2=sc.nextLine();
        System.out.println("Better string is: "+compare_Strings(s1,s2));
        sc.close();
    }
}