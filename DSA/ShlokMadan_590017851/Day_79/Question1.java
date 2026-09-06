import java.util.*;
public class Question1 
{
    public static void main(String[] args) 
    {
        Scanner sc=new Scanner(System.in);
        String a=sc.next();
        String b=sc.next();
        int i=a.length()-1;
        int j=b.length()-1;
        int carry=0;
        StringBuilder ans=new StringBuilder();
        while(i>=0 || j>=0 || carry>0) 
            {
            int sum=carry;
            if(i>=0)
                sum+=a.charAt(i--)-'0';
            if(j>=0)
                sum+=b.charAt(j--)-'0';
            ans.append(sum%2);
            carry=sum/2;
        }
        System.out.println(ans.reverse());
    }
}