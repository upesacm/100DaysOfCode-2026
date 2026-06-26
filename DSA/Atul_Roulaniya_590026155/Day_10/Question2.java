import java.util.*;
class distinct
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        String s;
        System.out.println("Enter a string");
        s=sc.nextLine();
        int size=s.length();
        String str="";
        for(int i=0 ; i < size ; i++)
        {
              char ch=s.charAt(i);
              if(str.indexOf(ch) ==-1)
              {
                 str=str+ch;
              }
        }
        int size1=str.length();
        if(size1 % 2 == 0)
        {
            System.out.println("CHAT WITH HER!");
        }
        else
        {
            System.out.println("IGNORE HIM!");
        }

    }
}