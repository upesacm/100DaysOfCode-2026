import java.util.*;
class reverse
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        {
            String s,str="";
            System.out.println("Enter string");
            s=sc.nextLine();
            int size=s.length();
             for (int i =size-1; i >= 0 ; i--)
             {
                char ch=s.charAt(i);
                str=str+ch;
             }
             System.out.println(str);
        }
    }
}