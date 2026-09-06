import java.util.*;
public class Question1 
{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int ones=0;
        int twos=0;
        for(int i=0;i<n;i++) 
            {
            int num=sc.nextInt();
            twos|=ones&num;
            ones^=num;
            int common=ones&twos;
            ones&=~common;
            twos&=~common;
        }
        System.out.println(ones);
    }
}